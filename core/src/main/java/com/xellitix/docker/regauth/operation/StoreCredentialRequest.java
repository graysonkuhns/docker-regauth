package com.xellitix.docker.regauth.operation;

import com.xellitix.docker.regauth.credential.Credential;

/**
 * Store {@link Credential} {@link OperationRequest}.
 *
 * @author Grayson Kuhns
 */
public interface StoreCredentialRequest extends OperationRequest {

    /**
     * Gets the {@link Credential} to store.
     *
     * @return The {@link Credential} to store.
     */
    Credential getCredential();
}
