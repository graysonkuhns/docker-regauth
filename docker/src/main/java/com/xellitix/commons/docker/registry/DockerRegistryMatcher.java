package com.xellitix.commons.docker.registry;

import java.io.Serializable;

/**
 * {@link DockerRegistry} matcher.
 *
 * @author Grayson Kuhns
 */
public interface DockerRegistryMatcher extends Serializable {

    /**
     * Checks if a {@link DockerRegistry} matches.
     *
     * @param registry The {@link DockerRegistry}.
     * @return True if the {@link DockerRegistry} matches.
     */
    boolean matches(DockerRegistry registry);
}
