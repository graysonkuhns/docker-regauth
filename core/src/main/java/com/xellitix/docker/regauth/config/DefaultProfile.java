package com.xellitix.docker.regauth.config;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.xellitix.docker.regauth.credentialstore.CredentialStore;
import com.xellitix.commons.docker.registry.DockerRegistryMatcher;

import java.util.List;

/**
 * Default {@link Profile} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultProfile implements Profile {

    // Properties
    private final String name;
    private final String credentialStoreId;
    private final List<DockerRegistryMatcher> registryMatchers;

    /**
     * Constructor.
     *
     * @param name The name.
     * @param credentialStoreId The {@link CredentialStore} ID.
     * @param registryMatchers The {@link DockerRegistryMatcher}s.
     */
    @Inject
    DefaultProfile(
            @Assisted("name") final String name,
            @Assisted("credentialStoreId") final String credentialStoreId,
            @Assisted final List<DockerRegistryMatcher> registryMatchers) {

        this.name = name;
        this.credentialStoreId = credentialStoreId;
        this.registryMatchers = registryMatchers;
    }

    /**
     * Gets the name.
     *
     * @return The name.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the {@link CredentialStore} ID.
     *
     * @return The {@link CredentialStore} ID.
     */
    @Override
    public String getCredentialStoreId() {
        return credentialStoreId;
    }

    /**
     * Gets the {@link DockerRegistryMatcher}s.
     *
     * @return The {@link DockerRegistryMatcher}s.
     */
    @Override
    public List<DockerRegistryMatcher> getDockerRegistryMatchers() {
        return registryMatchers;
    }
}
