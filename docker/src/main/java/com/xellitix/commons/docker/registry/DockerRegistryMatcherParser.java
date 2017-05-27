package com.xellitix.commons.docker.registry;

/**
 * {@link DockerRegistryMatcher} parser.
 *
 * @author Grayson Kuhns
 */
public interface DockerRegistryMatcherParser {

    /**
     * Parses a {@link DockerRegistryMatcher}.
     *
     * @param endpointRegex The {@link DockerRegistry} endpoint matching RegEx.
     * @return The {@link DockerRegistryMatcher}.
     */
    DockerRegistryMatcher parse(String endpointRegex);
}
