package com.xellitix.docker.regauth.operation;

import com.xellitix.commons.docker.registry.DockerRegistry;

/**
 * {@link DeleteCredentialRequest} factory.
 *
 * @author Grayson Kuhns
 */
public interface DeleteCredentialRequestFactory {

    /**
     * Creates a {@link DeleteCredentialRequest}.
     *
     * @param registry The {@link DockerRegistry} to delete credentials for.
     * @return The {@link DeleteCredentialRequest}.
     */
    DeleteCredentialRequest create(DockerRegistry registry);
}
