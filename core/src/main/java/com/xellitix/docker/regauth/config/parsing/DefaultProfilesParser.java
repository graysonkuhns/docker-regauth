package com.xellitix.docker.regauth.config.parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.xellitix.commons.parsing.FailedExpectationException;
import com.xellitix.docker.regauth.config.Profile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Default {@link ProfilesParser} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultProfilesParser implements ProfilesParser {

    // Constants
    private static final String PROFILES_KEY = "profiles";

    // Dependencies
    private final CompositeProfileParser profileParser;

    /**
     * Constructor.
     *
     * @param profileParser The {@link CompositeProfileParser}.
     */
    @Inject
    DefaultProfilesParser(final CompositeProfileParser profileParser) {
        this.profileParser = profileParser;
    }

    /**
     * Parses configuration {@link Profile}s.
     *
     * @param configNode The configuration JSON data.
     * @return The {@link Profile}s.
     * @throws FailedExpectationException If an error occurs while parsing.
     */
    @Override
    public List<Profile> parse(final JsonNode configNode) throws FailedExpectationException {

        // Get the profiles node
        JsonNode profilesNode = configNode.get(PROFILES_KEY);

        // Validate the profiles node
        if (profilesNode == null) {
            throw new FailedExpectationException(PROFILES_KEY, "be defined");
        }

        if (!profilesNode.isObject()) {
            throw new FailedExpectationException(PROFILES_KEY, "be an Object");
        }

        if (profilesNode.size() < 1) {
            throw new FailedExpectationException(PROFILES_KEY, "contain at least 1 element");
        }

        // Parse the profiles
        List<Profile> profiles = new ArrayList<>();

        Iterator<Map.Entry<String, JsonNode>> iterator = profilesNode.fields();
        while (iterator.hasNext()) {
            Map.Entry<String, JsonNode> profileData = iterator.next();
            Profile profile = profileParser.parse(profileData.getKey(), profileData.getValue());
            profiles.add(profile);
        }

        return profiles;
    }
}
