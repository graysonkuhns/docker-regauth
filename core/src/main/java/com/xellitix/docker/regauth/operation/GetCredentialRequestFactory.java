package com.xellitix.docker.regauth.operation;

import com.xellitix.docker.registry.DockerRegistry;

/**
 * {@link GetCredentialRequest} factory.
 *
 * @author Grayson Kuhns
 */
public interface GetCredentialRequestFactory {

    /**
     * Creates a {@link GetCredentialRequest}.
     *
     * @param registry The {@link DockerRegistry} to retrieve credentials for.
     * @return The {@link GetCredentialRequest}.
     */
    GetCredentialRequest create(DockerRegistry registry);
}
