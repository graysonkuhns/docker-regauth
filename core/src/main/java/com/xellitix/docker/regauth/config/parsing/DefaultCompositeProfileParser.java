package com.xellitix.docker.regauth.config.parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.xellitix.commons.docker.registry.DockerRegistryMatcher;
import com.xellitix.commons.parsing.FailedExpectationException;
import com.xellitix.commons.parsing.json.string.JsonStringParser;
import com.xellitix.docker.regauth.config.Profile;

import java.util.List;

/**
 * Default {@link CompositeProfileParser} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultCompositeProfileParser implements CompositeProfileParser {

    // Constants
    private static final String CREDENTIAL_STORE_ID_KEY = "backend";

    // Dependencies
    private final JsonStringParser stringParser;
    private final DockerRegistryMatchersParser registryMatchersParser;
    private final CredentialStoreProfileParserLocator profileParserLocator;

    /**
     * Constructor.
     *
     * @param stringParser The {@link JsonStringParser}.
     * @param registryMatchersParser The {@link DockerRegistryMatchersParser}.
     * @param profileParserLocator The {@link DefaultCredentialStoreProfileParserLocator}.
     */
    @Inject
    DefaultCompositeProfileParser(
            final JsonStringParser stringParser,
            final DockerRegistryMatchersParser registryMatchersParser,
            final CredentialStoreProfileParserLocator profileParserLocator) {

        this.stringParser = stringParser;
        this.registryMatchersParser = registryMatchersParser;
        this.profileParserLocator = profileParserLocator;
    }

    /**
     * Parses a {@link Profile}.
     *
     * @param name The name.
     * @param profileNode The {@link Profile} JSON data.
     * @return The {@link Profile}.
     * @throws FailedExpectationException If an error occurs while parsing.
     */
    @Override
    public Profile parse(
            final String name,
            final JsonNode profileNode)
            throws FailedExpectationException {

        // Parse the credential store ID
        String credentialStoreId = stringParser.parse(CREDENTIAL_STORE_ID_KEY, profileNode);
        List<DockerRegistryMatcher> matchers = registryMatchersParser.parse(profileNode);

        // Parse the credential store specific profile properties
        return profileParserLocator
                .locate(credentialStoreId)
                .parse(name, credentialStoreId, matchers, profileNode);
    }
}
