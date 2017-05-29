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
    private final Class<? extends CredentialStore> credentialStore;
    private final List<DockerRegistryMatcher> registryMatchers;

    /**
     * Constructor.
     *
     * @param name The name.
     * @param credentialStore The {@link CredentialStore} {@link Class}.
     * @param registryMatchers The {@link DockerRegistryMatcher}s.
     */
    @Inject
    DefaultProfile(
            @Assisted final String name,
            @Assisted final Class<? extends CredentialStore> credentialStore,
            @Assisted final List<DockerRegistryMatcher> registryMatchers) {

        this.name = name;
        this.credentialStore = credentialStore;
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
     * Gets the {@link CredentialStore} {@link Class}.
     *
     * @return The {@link CredentialStore} {@link Class}.
     */
    @Override
    public Class<? extends CredentialStore> getCredentialStoreClass() {
        return credentialStore;
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
