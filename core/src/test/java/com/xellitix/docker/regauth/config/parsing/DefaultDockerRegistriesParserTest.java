package com.xellitix.docker.regauth.config.parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.xellitix.commons.parsing.FailedExpectationException;
import com.xellitix.docker.registry.DockerRegistryParser;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * {@link DefaultDockerRegistriesParser} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultDockerRegistriesParserTest {

    // Constants
    private static final String REGISTRIES_KEY = "registries";
    private static final String REGISTRIES_UNDEFINED_MSG =
            "The element \"registries\" failed the expectation \"defined\"";
    private static final String REGISTRIES_NON_ARRAY_MSG =
            "The element \"registries\" failed the expectation \"an Array\"";

    // Rules
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // Fixtures
    private ObjectNode profileNode;

    private DockerRegistryParser registryParser;
    private DefaultDockerRegistriesParser registriesParser;

    @Test
    public void parseTest() {

    }

    @Test
    public void undefinedRegistriesNodeCausesExceptionTest() throws Exception {
        // Describe the exception to expect
        thrown.expect(FailedExpectationException.class);
        thrown.expectMessage(REGISTRIES_UNDEFINED_MSG);

        // Remove the registries node
        profileNode.remove(REGISTRIES_KEY);

        // Attempt to parse the registries
        registriesParser.parse(profileNode);
    }

    @Test
    public void nonArrayRegistriesNodeCausesExceptionTest() throws Exception {
        // Describe the exception to expect
        thrown.expect(FailedExpectationException.class);
        thrown.expectMessage(REGISTRIES_NON_ARRAY_MSG);

        // Store an invalid data-type as the registries node
        profileNode.put(REGISTRIES_KEY, 5);

        // Attempt to parse the registries
        registriesParser.parse(profileNode);
    }

    @Before
    public void setUp() {
        profileNode = new ObjectMapper()
                .getNodeFactory()
                .objectNode();

        // Mock the docker registry parser
        registryParser = mock(DockerRegistryParser.class);

        // Create the docker registries parser
        registriesParser = new DefaultDockerRegistriesParser(registryParser);
    }
}
