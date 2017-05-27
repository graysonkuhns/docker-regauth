package com.xellitix.docker.regauth.operation;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.xellitix.commons.docker.registry.DockerRegistry;

/**
 * Default {@link DeleteCredentialRequest} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultDeleteCredentialRequest
        extends AbstractOperationRequest
        implements DeleteCredentialRequest {

    /**
     * Constructor.
     *
     * @param registry The {@link DockerRegistry} to delete credentials for.
     */
    @Inject
    public DefaultDeleteCredentialRequest(@Assisted final DockerRegistry registry) {
        super(registry);
    }

    /**
     * Gets the {@link Operation} to perform.
     *
     * @return The {@link Operation} to perform.
     */
    @Override
    public Operation getOperation() {
        return Operation.DELETE;
    }
}
