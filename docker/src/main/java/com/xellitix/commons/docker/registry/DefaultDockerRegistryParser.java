package com.xellitix.commons.docker.registry;

import com.google.inject.Inject;
import com.xellitix.commons.network.url.URLFactory;
import com.xellitix.commons.parsing.FailedExpectationException;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Default {@link DockerRegistryParser} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultDockerRegistryParser implements DockerRegistryParser {

    // Dependencies
    private final URLFactory urlFactory;
    private final DockerRegistryFactory registryFactory;

    /**
     * Constructor.
     *
     * @param urlFactory The {@link URLFactory}.
     * @param registryFactory The {@link DockerRegistryFactory}.
     */
    @Inject
    DefaultDockerRegistryParser(
            final URLFactory urlFactory,
            final DockerRegistryFactory registryFactory) {

        this.registryFactory = registryFactory;
        this.urlFactory = urlFactory;
    }

    /**
     * Parses a {@link DockerRegistry}.
     *
     * @param endpointUrl The endpoint URL.
     * @return The parsed {@link DockerRegistry}.
     * @throws FailedExpectationException If an error occurs while parsing.
     */
    @Override
    public DockerRegistry parse(final String endpointUrl) throws FailedExpectationException {
        // Create the URL
        URL url;
        try {
            url = urlFactory.create(endpointUrl);
        } catch (MalformedURLException ex) {
            throw new FailedExpectationException("endpointUrl", "a valid URL");
        }

        // Create the docker registry
        return registryFactory.create(url);
    }
}
