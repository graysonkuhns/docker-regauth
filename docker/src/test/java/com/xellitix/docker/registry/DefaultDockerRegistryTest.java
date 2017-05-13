package com.xellitix.docker.registry;

import org.junit.Before;
import org.junit.Test;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * {@link DefaultDockerRegistry} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultDockerRegistryTest {

    // Constants
    private static final String ENDPOINT_URL = "https://foo.bar";

    // Fixtures
    private URL endpointUrl;
    private DefaultDockerRegistry registry;

    @Test
    public void getEndpointTest() {
        assertThat(registry
                .getEndpoint())
                .isNotNull()
                .isEqualTo(endpointUrl);
    }

    @Before
    public void setUp() throws Exception {
        // Create the endpoint URL
        endpointUrl = new URL(ENDPOINT_URL);

        // Create the docker registry
        registry = new DefaultDockerRegistry(endpointUrl);
    }
}
