package com.xellitix.commons.docker.registry;

import java.io.Serializable;
import java.net.URL;

/**
 * Docker registry model.
 *
 * @author Grayson Kuhns
 */
public interface DockerRegistry extends Serializable {

    /**
     * Gets the endpoint {@link URL}.
     *
     * @return The endpoint {@link URL}.
     */
    URL getEndpoint();
}
