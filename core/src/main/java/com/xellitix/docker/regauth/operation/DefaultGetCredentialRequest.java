package com.xellitix.docker.regauth.operation;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.xellitix.commons.docker.registry.DockerRegistry;

/**
 * Default {@link GetCredentialRequest} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultGetCredentialRequest
        extends AbstractOperationRequest
        implements GetCredentialRequest {

    /**
     * Constructor.
     *
     * @param registry The {@link DockerRegistry} to retrieve credentials for.
     */
    @Inject
    DefaultGetCredentialRequest(@Assisted final DockerRegistry registry) {
        super(registry);
    }

    /**
     * Gets the {@link Operation} to perform.
     *
     * @return The {@link Operation} to perform.
     */
    @Override
    public Operation getOperation() {
        return Operation.GET;
    }
}
