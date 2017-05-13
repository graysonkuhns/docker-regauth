package com.xellitix.docker.regauth.operation;

import com.xellitix.docker.registry.DockerRegistry;

import java.io.Serializable;

/**
 * Operation operation.
 *
 * @author Grayson Kuhns
 */
public interface OperationRequest extends Serializable {

    /**
     * Gets the {@link Operation} to perform.
     *
     * @return The {@link Operation} to perform.
     */
    Operation getOperation();

    /**
     * Gets the {@link DockerRegistry} to retrieve credentials for.
     *
     * @return The {@link DockerRegistry} to retrieve credentials for.
     */
    DockerRegistry getDockerRegistry();
}
