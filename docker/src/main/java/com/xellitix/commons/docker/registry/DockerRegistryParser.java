package com.xellitix.commons.docker.registry;

        import com.xellitix.commons.parsing.FailedExpectationException;

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
     * @throws FailedExpectationException If an error occurs while parsing.
     */
    DockerRegistry parse(String endpointUrl) throws FailedExpectationException;
}
