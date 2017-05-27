package com.xellitix.docker.registry;

/**
 * {@link DockerRegistry} parser.
 *
 * @author Grayson Kuhns
 */
public interface DockerRegistryParser {

    /**
     * Parses a {@link DockerRegistry}.
     *
     * @param endpointUrl The endpoint URL.
     * @return The parsed {@link DockerRegistry}.
     * @throws IllegalArgumentException If an error occurs while parsing.
     */
    DockerRegistry parse(String endpointUrl) throws IllegalArgumentException;
}
