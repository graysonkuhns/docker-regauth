package com.xellitix.docker.regauth.config.parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.xellitix.commons.docker.registry.DockerRegistryMatcher;
import com.xellitix.commons.parsing.FailedExpectationException;
import com.xellitix.docker.regauth.config.Profile;
import com.xellitix.docker.regauth.config.ProfileFactory;
import com.xellitix.docker.regauth.credentialstore.CredentialStore;

import java.util.List;

/**
 * Default {@link CredentialStoreProfileParser} implementation.
 *
 * <p>
 * Creates a basic {@link Profile}. This is the fallback parser and
 * does not support {@link CredentialStore} specific properties.
 * </p>
 *
 * @author Grayson Kuhns
 */
public class DefaultCredentialStoreProfileParser implements CredentialStoreProfileParser<Profile> {

    // Dependencies
    private final ProfileFactory profileFactory;

    /**
     * Constructor.
     *
     * @param profileFactory The {@link ProfileFactory}.
     */
    @Inject
    DefaultCredentialStoreProfileParser(final ProfileFactory profileFactory) {
        this.profileFactory = profileFactory;
    }

    /**
     * Gets the supported {@link CredentialStore} ID.
     *
     * @return The supported {@link CredentialStore} ID.
     */
    @Override
    public String getCredentialStoreId() {
        return "N/A";
    }

    /**
     * Parses a {@link Profile}.
     *
     * @param name The name.
     * @param credentialStoreId The {@link CredentialStore} ID.
     * @param registryMatchers The {@link DockerRegistryMatcher}s.
     * @param profileNode The {@link Profile} JSON data.
     * @return The {@link Profile}.
     * @throws FailedExpectationException If an error occurs while parsing.
     */
    @Override
    public Profile parse(
            final String name,
            final String credentialStoreId,
            final List<DockerRegistryMatcher> registryMatchers,
            final JsonNode profileNode)
            throws FailedExpectationException {

        // Create the profile
        return profileFactory.create(name, credentialStoreId, registryMatchers);
    }
}
