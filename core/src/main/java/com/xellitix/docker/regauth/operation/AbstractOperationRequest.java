package com.xellitix.docker.regauth.operation;

import com.xellitix.commons.docker.registry.DockerRegistry;

/**
 * Partial {@link OperationRequest} implementation..
 *
 * @author Grayson Kuhns
 */
public abstract class AbstractOperationRequest implements OperationRequest {

    // Properties
    private final DockerRegistry registry;

    /**
     * Constructor.
     *
     * @param registry The {@link DockerRegistry} to retrieve credentials for.
     */
    AbstractOperationRequest(final DockerRegistry registry) {
        this.registry = registry;
    }

    /**
     * Gets the {@link DockerRegistry} to retrieve credentials for.
     *
     * @return The {@link DockerRegistry} to retrieve credentials for.
     */
    @Override
    public DockerRegistry getDockerRegistry() {
        return registry;
    }
}
