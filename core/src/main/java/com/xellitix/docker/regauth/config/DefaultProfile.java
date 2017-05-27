package com.xellitix.docker.regauth.config;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.xellitix.docker.regauth.credentialstore.CredentialStore;
import com.xellitix.docker.registry.DockerRegistryMatcher;

import java.util.List;
import java.util.Set;

/**
 * Default {@link Profile} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultProfile implements Profile {

    // Properties
    private final String name;
    private final CredentialStore credentialStore;
    private final List<DockerRegistryMatcher> registryMatchers;

    /**
     * Constructor.
     *
     * @param name The name.
     * @param credentialStore The {@link CredentialStore}.
     * @param registryMatchers The {@link DockerRegistryMatcher}s.
     */
    @Inject
    DefaultProfile(
            @Assisted final String name,
            @Assisted final CredentialStore credentialStore,
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
     * Gets the {@link CredentialStore}.
     *
     * @return The {@link CredentialStore}.
     */
    @Override
    public CredentialStore getCredentialStore() {
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
