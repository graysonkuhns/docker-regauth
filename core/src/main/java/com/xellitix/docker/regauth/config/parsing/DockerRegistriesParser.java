package com.xellitix.docker.regauth.config.parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.xellitix.commons.parsing.FailedExpectationException;
import com.xellitix.docker.registry.DockerRegistry;

import java.util.Set;

/**
 * Docker Registries parser.
 *
 * @author Grayson Kuhns
 */
public interface DockerRegistriesParser {

    /**
     * Parses Docker Registries.
     *
     * @param profileNode The profile data.
     * @return The Docker Registries.
     * @throws FailedExpectationException If an error occurs while parsing.
     */
    Set<DockerRegistry> parse(JsonNode profileNode) throws FailedExpectationException;
}
