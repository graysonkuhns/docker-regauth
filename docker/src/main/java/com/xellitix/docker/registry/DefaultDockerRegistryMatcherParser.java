package com.xellitix.docker.registry;

import com.google.inject.Inject;

import java.util.regex.Pattern;

/**
 * Default {@link DockerRegistryMatcherParser} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultDockerRegistryMatcherParser implements DockerRegistryMatcherParser {

    // Dependencies
    private final DockerRegistryMatcherFactory matcherFactory;

    /**
     * Constructor.
     *
     * @param matcherFactory The {@link DockerRegistryMatcherFactory}.
     */
    @Inject
    DefaultDockerRegistryMatcherParser(final DockerRegistryMatcherFactory matcherFactory) {
        this.matcherFactory = matcherFactory;
    }

    /**
     * Parses a {@link DockerRegistryMatcher}.
     *
     * @param endpointRegex The {@link DockerRegistry} endpoint matching RegEx.
     * @return The {@link DockerRegistryMatcher}.
     */
    @Override
    public DockerRegistryMatcher parse(final String endpointRegex) {

        // Compile the matcher pattern
        Pattern endpointPattern = Pattern.compile(endpointRegex);

        // Create the matcher
        return matcherFactory.create(endpointPattern);
    }
}
