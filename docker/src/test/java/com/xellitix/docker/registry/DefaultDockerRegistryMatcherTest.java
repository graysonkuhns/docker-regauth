package com.xellitix.docker.registry;

import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;

/**
 * {@link DefaultDockerRegistryMatcher} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultDockerRegistryMatcherTest {

    // Constants
    private static final String NON_MATCHING_ENDPOINT_URL =
            "https://matchingRegistry.google.com";
    private static final String MATCHING_ENDPOINT_URL =
            "https://dockerhub.company.com";
    private static final String ENDPOINT_URL_REGEX =
            "https:\\/\\/dockerhub\\.company\\.com";

    // Fixtures
    private DockerRegistry nonMatchingRegistry;
    private DockerRegistry matchingRegistry;
    private DockerRegistryMatcher registryMatcher;

    @Test
    public void negativeMatchingTest() {
        assertThat(registryMatcher
                .matches(nonMatchingRegistry))
                .isFalse();
    }

    @Test
    public void positiveMatchingTest() {
        assertThat(registryMatcher
                .matches(matchingRegistry))
                .isTrue();
    }

    @Before
    public void setUp() throws Exception {
        // Mock the registries
        URL nonMatchingUrl = new URL(NON_MATCHING_ENDPOINT_URL);
        nonMatchingRegistry = mock(DockerRegistry.class);
        doReturn(nonMatchingUrl)
                .when(nonMatchingRegistry)
                .getEndpoint();

        URL matchingUrl = new URL(MATCHING_ENDPOINT_URL);
        matchingRegistry = mock(DockerRegistry.class);
        doReturn(matchingUrl)
                .when(matchingRegistry)
                .getEndpoint();

        // Create the registry matcher
        Pattern pattern = Pattern.compile(ENDPOINT_URL_REGEX);
        registryMatcher = new DefaultDockerRegistryMatcher(pattern);
    }
}
