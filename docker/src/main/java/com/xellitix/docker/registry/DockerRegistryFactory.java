package com.xellitix.docker.registry;

import java.net.URL;

/**
 * {@link DockerRegistry} factory.
 *
 * @author Grayson Kuhns
 */
public interface DockerRegistryFactory {

    /**
     * Creates a {@link DockerRegistry}.
     *
     * @param endpoint The endpoint.
     * @return The {@link DockerRegistry}.
     */
    DockerRegistry create(URL endpoint);
}
