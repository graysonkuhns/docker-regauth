package com.xellitix.docker.regauth.config.parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.xellitix.commons.docker.registry.DockerRegistryMatcher;
import com.xellitix.commons.parsing.FailedExpectationException;
import com.xellitix.docker.regauth.config.Profile;
import com.xellitix.docker.regauth.credentialstore.CredentialStore;

import java.util.List;

/**
 * Parses the {@link CredentialStore} specific {@link Profile} properties.
 *
 * @author Grayson Kuhns
 *
 * @param <T> The {@link Profile} type.
 */
public interface CredentialStoreProfileParser<T extends Profile> {

    /**
     * Gets the supported {@link CredentialStore} ID.
     *
     * @return The supported {@link CredentialStore} ID.
     */
    String getCredentialStoreId();

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
    T parse(
            String name,
            String credentialStoreId,
            List<DockerRegistryMatcher> registryMatchers,
            JsonNode profileNode)
            throws FailedExpectationException;
}
