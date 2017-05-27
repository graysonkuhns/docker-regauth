package com.xellitix.docker.regauth.config.parsing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.xellitix.commons.parsing.FailedExpectationException;
import com.xellitix.commons.docker.registry.DockerRegistryMatcher;
import com.xellitix.commons.docker.registry.DockerRegistryMatcherParser;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * {@link DefaultDockerRegistryMatchersParser} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultDockerRegistryMatchersParserTest {

    // Constants
    private static final String MATCHERS_KEY = "registries";
    private static final String MATCHERS_UNDEFINED_MSG =
            "The element \"registries\" failed the expectation \"be defined\"";
    private static final String MATCHERS_NON_ARRAY_MSG =
            "The element \"registries\" failed the expectation \"be an Array\"";
    private static final String MATCHERS_EMPTY_MSG =
            "The element \"registries\" failed the expectation \"contain at least 1 element\"";

    private static final String MATCHER_PATTERN_ONE = "https:\\/\\/dockerhub\\.company\\.com";
    private static final String MATCHER_PATTERN_TWO = "https:\\/\\/registry\\.company\\.com";

    // Rules
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // Fixtures
    private ObjectNode profileNode;

    private DockerRegistryMatcher matcherOne;
    private DockerRegistryMatcher matcherTwo;
    private DockerRegistryMatcherParser matcherParser;

    private DefaultDockerRegistryMatchersParser matchersParser;

    @Test
    public void parseTest() throws Exception {
        assertThat(matchersParser
                .parse(profileNode))
                .isNotNull()
                .hasSize(2)
                .contains(matcherOne)
                .contains(matcherTwo);
    }

    @Test
    public void undefinedMatchersNodeCausesExceptionTest() throws Exception {
        // Describe the exception to expect
        thrown.expect(FailedExpectationException.class);
        thrown.expectMessage(MATCHERS_UNDEFINED_MSG);

        // Remove the registries node
        profileNode.remove(MATCHERS_KEY);

        // Attempt to parse the registries
        matchersParser.parse(profileNode);
    }

    @Test
    public void nonArrayMatchersNodeCausesExceptionTest() throws Exception {
        // Describe the exception to expect
        thrown.expect(FailedExpectationException.class);
        thrown.expectMessage(MATCHERS_NON_ARRAY_MSG);

        // Store an invalid data-type as the registries node
        profileNode.put(MATCHERS_KEY, 5);

        // Attempt to parse the registries
        matchersParser.parse(profileNode);
    }

    @Test
    public void emptyMatchersNodeCausesExceptionTest() throws Exception {
        // Describe the exception to expect
        thrown.expect(FailedExpectationException.class);
        thrown.expectMessage(MATCHERS_EMPTY_MSG);

        // Store an invalid data-type as the registries node
        profileNode.remove(MATCHERS_KEY);
        profileNode.withArray(MATCHERS_KEY);

        // Attempt to parse the registries
        matchersParser.parse(profileNode);
    }

    @Before
    public void setUp() {
        profileNode = new ObjectMapper()
                .getNodeFactory()
                .objectNode();
        ArrayNode matchersNode = profileNode.withArray(MATCHERS_KEY);
        matchersNode.add(MATCHER_PATTERN_ONE);
        matchersNode.add(MATCHER_PATTERN_TWO);

        // Matcher parser mocking
        matcherOne = mock(DockerRegistryMatcher.class);
        matcherTwo = mock(DockerRegistryMatcher.class);
        matcherParser = mock(DockerRegistryMatcherParser.class);
        doReturn(matcherOne)
                .when(matcherParser)
                .parse(eq(MATCHER_PATTERN_ONE));
        doReturn(matcherTwo)
                .when(matcherParser)
                .parse(eq(MATCHER_PATTERN_TWO));

        // Create the docker registries parser
        matchersParser = new DefaultDockerRegistryMatchersParser(matcherParser);
    }
}
