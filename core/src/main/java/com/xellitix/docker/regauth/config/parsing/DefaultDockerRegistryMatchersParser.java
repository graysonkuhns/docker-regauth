package com.xellitix.docker.regauth.config.parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.xellitix.commons.parsing.FailedExpectationException;
import com.xellitix.docker.registry.DockerRegistry;
import com.xellitix.docker.registry.DockerRegistryMatcher;
import com.xellitix.docker.registry.DockerRegistryMatcherParser;

import java.util.*;

/**
 * Default {@link DockerRegistryMatchersParser} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultDockerRegistryMatchersParser implements DockerRegistryMatchersParser {

    // Constants
    private static final String MATCHERS_KEY = "registries";

    // Dependencies
    private final DockerRegistryMatcherParser matcherParser;

    /**
     * Constructor.
     *
     * @param matcherParser The {@link DockerRegistryMatcherParser}.
     */
    @Inject
    DefaultDockerRegistryMatchersParser(final DockerRegistryMatcherParser matcherParser) {
        this.matcherParser = matcherParser;
    }

    /**
     * Parses {@link DockerRegistryMatcher}s.
     *
     * @param profileNode The profile data.
     * @return The {@link DockerRegistryMatcher}s.
     * @throws FailedExpectationException If an error occurs while parsing.
     */
    @Override
    public List<DockerRegistryMatcher> parse(
            final JsonNode profileNode)
            throws FailedExpectationException {

        // Get the matchers node
        JsonNode matchersNode = profileNode.get(MATCHERS_KEY);

        // Validate the matchers node
        if (matchersNode == null) {
            throw new FailedExpectationException(MATCHERS_KEY, "be defined");
        }

        if (!matchersNode.isArray()) {
            throw new FailedExpectationException(MATCHERS_KEY, "be an Array");
        }

        if (matchersNode.size() < 1) {
            throw new FailedExpectationException(MATCHERS_KEY, "contain at least 1 element");
        }

        // Parse the matchers
        List<DockerRegistryMatcher> matchers = new ArrayList<>();
        Iterator<JsonNode> matcherIterator = matchersNode.elements();

        while (matcherIterator.hasNext()) {
            JsonNode matcherNode = matcherIterator.next();
            DockerRegistryMatcher matcher = matcherParser.parse(matcherNode.asText());
            matchers.add(matcher);
        }

        return matchers;
    }
}
