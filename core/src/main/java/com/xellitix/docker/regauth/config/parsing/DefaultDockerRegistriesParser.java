package com.xellitix.docker.regauth.config.parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.xellitix.commons.parsing.FailedExpectationException;
import com.xellitix.docker.registry.DockerRegistry;
import com.xellitix.docker.registry.DockerRegistryParser;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Default {@link DockerRegistriesParser} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultDockerRegistriesParser implements DockerRegistriesParser {

    // Constants
    private static final String REGISTRIES_KEY = "registries";

    // Dependencies
    private final DockerRegistryParser registryParser;

    /**
     * Constructor.
     *
     * @param registryParser The {@link DockerRegistryParser}.
     */
    @Inject
    DefaultDockerRegistriesParser(final DockerRegistryParser registryParser) {
        this.registryParser = registryParser;
    }

    /**
     * Parses Docker Registries.
     *
     * @param profileNode The profile data.
     * @return The Docker Registries.
     * @throws FailedExpectationException If an error occurs while parsing.
     */
    @Override
    public Set<DockerRegistry> parse(
            final JsonNode profileNode)
            throws FailedExpectationException {

        // Get the registries node
        JsonNode registriesNode = profileNode.get(REGISTRIES_KEY);

        if (registriesNode == null) {
            throw new FailedExpectationException(REGISTRIES_KEY, "defined");
        }

        if (!registriesNode.isArray()) {
            throw new FailedExpectationException(REGISTRIES_KEY, "an Array");
        }



        // Parse the registries
        Set<DockerRegistry> registries = new HashSet<>();
        Iterator<JsonNode> registriesIterator = registriesNode.elements();

        while (registriesIterator.hasNext()) {
            JsonNode registryNode = registriesIterator.next();
            DockerRegistry registry = registryParser.parse(registryNode.asText());
            registries.add(registry);
        }

        return registries;
    }
}
