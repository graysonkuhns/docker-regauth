package com.xellitix.docker.registry;

import java.util.regex.Pattern;

/**
 * {@link DockerRegistryMatcher} factory.
 *
 * @author Grayson Kuhns
 */
public interface DockerRegistryMatcherFactory {

    /**
     * Creates a {@link DockerRegistryMatcher}.
     *
     * @param endpointPattern The {@link DockerRegistry} endpoint matching pattern.
     * @return The {@link DockerRegistryMatcher}.
     */
    DockerRegistryMatcher create(Pattern endpointPattern);
}
