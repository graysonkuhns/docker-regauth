package com.xellitix.commons.docker.registry;

import com.xellitix.commons.network.url.URLFactory;
import com.xellitix.commons.parsing.FailedExpectationException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * {@link DefaultDockerRegistryParser} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultDockerRegistryParserTest {

    // Constants
    private static final String ENDPOINT_URL = "https://dockerhub.company.com";
    private static final String MALFORMED_URL_MSG =
            "The element \"endpointUrl\" failed the expectation \"a valid URL\"";

    // Rules
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // Fixtures
    private URL endpointUrl;
    private URLFactory urlFactory;

    private DockerRegistry registry;
    private DockerRegistryFactory registryFactory;

    private DefaultDockerRegistryParser registryParser;

    @Test
    public void parseTest() throws Exception {
        assertThat(registryParser
                .parse(ENDPOINT_URL))
                .isNotNull()
                .isEqualTo(registry);

        verify(urlFactory).create(eq(ENDPOINT_URL));

        verify(registryFactory).create(eq(endpointUrl));
    }

    @Test
    public void malformedUrlCausesExceptionTest() throws Exception {
        // Describe the exception to expect
        thrown.expect(FailedExpectationException.class);
        thrown.expectMessage(MALFORMED_URL_MSG);

        // Prepare the url factory
        doThrow(new MalformedURLException())
                .when(urlFactory)
                .create(eq(ENDPOINT_URL));

        // Attempt to parse the docker registry
        registryParser.parse(ENDPOINT_URL);
    }

    @Before
    public void setUp() throws Exception {
        // Mock the URL factory
        endpointUrl = new URL(ENDPOINT_URL);
        urlFactory = mock(URLFactory.class);
        doReturn(endpointUrl)
                .when(urlFactory)
                .create(eq(ENDPOINT_URL));

        // Mock the registry factory
        registry = mock(DockerRegistry.class);
        registryFactory = mock(DockerRegistryFactory.class);
        doReturn(registry)
                .when(registryFactory)
                .create(eq(endpointUrl));

        // Create the docker registry parser
        registryParser = new DefaultDockerRegistryParser(urlFactory, registryFactory);
    }
}
