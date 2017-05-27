package com.xellitix.docker.regauth.config;

import com.xellitix.docker.regauth.credentialstore.CredentialStore;
import com.xellitix.commons.docker.registry.DockerRegistryMatcher;

import java.io.Serializable;
import java.util.List;

/**
 * Profile model.
 *
 * @author Grayson Kuhns
 */
public interface Profile extends Serializable {

    /**
     * Gets the name.
     *
     * @return The name.
     */
    String getName();

    /**
     * Gets the {@link CredentialStore}.
     *
     * @return The {@link CredentialStore}.
     */
    CredentialStore getCredentialStore();

    /**
     * Gets the {@link DockerRegistryMatcher}s.
     *
     * @return The {@link DockerRegistryMatcher}s.
     */
    List<DockerRegistryMatcher> getDockerRegistryMatchers();
}
