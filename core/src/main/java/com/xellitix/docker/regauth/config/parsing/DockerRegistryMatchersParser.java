package com.xellitix.docker.regauth.config.parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.xellitix.commons.parsing.FailedExpectationException;
import com.xellitix.docker.registry.DockerRegistry;
import com.xellitix.docker.registry.DockerRegistryMatcher;

import java.util.List;
import java.util.Set;

/**
 * Docker Registries parser.
 *
 * @author Grayson Kuhns
 */
public interface DockerRegistryMatchersParser {

    /**
     * Parses {@link DockerRegistryMatcher}s.
     *
     * @param profileNode The profile data.
     * @return The {@link DockerRegistryMatcher}s.
     * @throws FailedExpectationException If an error occurs while parsing.
     */
    List<DockerRegistryMatcher> parse(JsonNode profileNode) throws FailedExpectationException;
}
