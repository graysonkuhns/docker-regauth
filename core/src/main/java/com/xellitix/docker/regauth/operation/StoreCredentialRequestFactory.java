package com.xellitix.docker.regauth.operation;

import com.xellitix.docker.regauth.credential.Credential;
import com.xellitix.docker.registry.DockerRegistry;

/**
 * {@link StoreCredentialRequest} factory.
 *
 * @author Grayson Kuhns
 */
public interface StoreCredentialRequestFactory {

    /**
     * Creates a {@link StoreCredentialRequest}.
     *
     * @param registry The {@link DockerRegistry} to store a {@link Credential} for.
     * @param credential The {@link Credential} to store.
     * @return The {@link StoreCredentialRequest}.
     */
    StoreCredentialRequest create(DockerRegistry registry, Credential credential);
}
