package com.xellitix.docker.regauth.config;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.xellitix.docker.regauth.credentialstore.CredentialStore;
import com.xellitix.docker.registry.DockerRegistry;

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
    private final Set<DockerRegistry> dockerRegistries;

    /**
     * Constructor.
     *
     * @param name The name.
     * @param credentialStore The {@link CredentialStore}.
     * @param dockerRegistries The Docker Registries.
     */
    @Inject
    DefaultProfile(
            @Assisted final String name,
            @Assisted final CredentialStore credentialStore,
            @Assisted final Set<DockerRegistry> dockerRegistries) {

        this.name = name;
        this.credentialStore = credentialStore;
        this.dockerRegistries = dockerRegistries;
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
     * Gets the Docker registries.
     *
     * @return The Docker registries.
     */
    @Override
    public Set<DockerRegistry> getDockerRegistries() {
        return dockerRegistries;
    }
}