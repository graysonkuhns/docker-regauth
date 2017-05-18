package com.xellitix.docker.regauth.operation;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.xellitix.docker.regauth.credential.Credential;
import com.xellitix.docker.registry.DockerRegistry;

/**
 * Default {@link StoreCredentialRequest} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultStoreCredentialRequest
        extends AbstractOperationRequest
        implements StoreCredentialRequest {

    // Properties
    private final Credential credential;

    /**
     * Constructor.
     *
     * @param registry The {@link DockerRegistry} to store a {@link Credential} for.
     * @param credential The {@link Credential} to store.
     */
    @Inject
    public DefaultStoreCredentialRequest(
            @Assisted final DockerRegistry registry,
            @Assisted final Credential credential) {

        super(registry);
        this.credential = credential;
    }

    /**
     * Gets the {@link Operation} to perform.
     *
     * @return The {@link Operation} to perform.
     */
    @Override
    public Operation getOperation() {
        return Operation.STORE;
    }

    /**
     * Gets the {@link Credential} to store.
     *
     * @return The {@link Credential} to store.
     */
    @Override
    public Credential getCredential() {
        return credential;
    }
}
