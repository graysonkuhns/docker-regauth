package com.xellitix.docker.regauth.config;

import com.google.inject.assistedinject.Assisted;
import com.xellitix.commons.docker.registry.DockerRegistryMatcher;

import java.util.List;
import com.xellitix.docker.regauth.credentialstore.CredentialStore;

/**
 * {@link Profile} factory.
 *
 * @author Grayson Kuhns
 */
public interface ProfileFactory {

    /**
     * Creates a {@link Profile}.
     *
     * @param name The name.
     * @param credentialStoreId The {@link CredentialStore} ID.
     * @param registryMatchers The {@link DockerRegistryMatcher}s.
     * @return The {@link Profile}.
     */
    Profile create(
            @Assisted("name") String name,
            @Assisted("credentialStoreId") String credentialStoreId,
            @Assisted List<DockerRegistryMatcher> registryMatchers);
}
