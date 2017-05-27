package com.xellitix.docker.registry;

import com.google.inject.Inject;
import com.xellitix.commons.network.url.URLFactory;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Default {@link DockerRegistryParser} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultDockerRegistryParser implements DockerRegistryParser {

    // Dependencies
    private final DockerRegistryFactory registryFactory;
    private final URLFactory urlFactory;

    /**
     * Constructor.
     *
     * @param registryFactory The {@link DockerRegistryFactory}.
     * @param urlFactory The {@link URLFactory}.
     */
    @Inject
    DefaultDockerRegistryParser(
            final DockerRegistryFactory registryFactory,
            final URLFactory urlFactory) {

        this.registryFactory = registryFactory;
        this.urlFactory = urlFactory;
    }

    /**
     * Parses a {@link DockerRegistry}.
     *
     * @param endpointUrl The endpoint URL.
     * @return The parsed {@link DockerRegistry}.
     * @throws IllegalArgumentException If an error occurs while parsing.
     */
    @Override
    public DockerRegistry parse(final String endpointUrl) throws IllegalArgumentException {
        // Create the URL
        URL url;
        try {
            url = urlFactory.create(endpointUrl);
        } catch (MalformedURLException ex) {
            throw new IllegalArgumentException();
        }

        // Create the docker registry
        return null;
    }
}
