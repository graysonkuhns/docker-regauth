package com.xellitix.docker.registry;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import java.util.regex.Pattern;

/**
 * Default {@link DockerRegistryMatcher} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultDockerRegistryMatcher implements DockerRegistryMatcher {

    // Properties
    private final Pattern endpointPattern;

    /**
     * Constructor.
     *
     * @param endpointPattern The {@link DockerRegistry} endpoint matching pattern.
     */
    @Inject
    DefaultDockerRegistryMatcher(@Assisted final Pattern endpointPattern) {
        this.endpointPattern = endpointPattern;
    }

    /**
     * Checks if a {@link DockerRegistry} matches.
     *
     * @param registry The {@link DockerRegistry}.
     * @return True if the {@link DockerRegistry} matches.
     */
    @Override
    public boolean matches(final DockerRegistry registry) {
        String endpointUrl = registry.getEndpoint().toString();
        return endpointPattern.matcher(endpointUrl).matches();
    }
}
