package com.xellitix.docker.regauth.config.parsing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.xellitix.commons.parsing.FailedExpectationException;
import com.xellitix.docker.regauth.config.Profile;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * {@link DefaultProfilesParser} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultProfilesParserTest {

    // Constants
    private static final String PROFILES_KEY = "profiles";
    private static final String PROFILE_NAME_ONE = "profileOne";
    private static final String PROFILE_NAME_TWO = "profileTwo";

    private static final String PROFILES_UNDEFINED_MSG =
            "The element \"profiles\" failed the expectation \"be defined\"";
    private static final String PROFILES_NON_OBJECT_MSG =
            "The element \"profiles\" failed the expectation \"be an Object\"";
    private static final String PROFILES_EMPTY_MSG =
            "The element \"profiles\" failed the expectation \"contain at least 1 element\"";

    // Rules
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // Fixtures
    private ObjectNode configNode;

    private ObjectNode profileOneNode;
    private ObjectNode profileTwoNode;

    private Profile profileOne;
    private Profile profileTwo;
    private CompositeProfileParser profileParser;

    private DefaultProfilesParser profilesParser;

    @Test
    public void parseProfilesTest() throws Exception {
        assertThat(profilesParser
                .parse(configNode))
                .isNotNull()
                .hasSize(2)
                .contains(profileOne)
                .contains(profileTwo);

        verify(profileParser).parse(eq(PROFILE_NAME_ONE), eq(profileOneNode));
        verify(profileParser).parse(eq(PROFILE_NAME_TWO), eq(profileTwoNode));
    }

    @Test
    public void undefinedProfilesCausesExceptionTest() throws Exception {
        // Describe the exception to expect
        thrown.expect(FailedExpectationException.class);
        thrown.expectMessage(PROFILES_UNDEFINED_MSG);

        // Prepare the configuration data
        configNode.remove(PROFILES_KEY);

        // Attempt to parse the profiles
        profilesParser.parse(configNode);
    }

    @Test
    public void nonObjectProfilesNodeCausesExceptionTest() throws Exception {
        // Describe the exception to expect
        thrown.expect(FailedExpectationException.class);
        thrown.expectMessage(PROFILES_NON_OBJECT_MSG);

        // Prepare the configuration data
        configNode.put(PROFILES_KEY, 5);

        // Attempt to parse the profiles
        profilesParser.parse(configNode);
    }

    @Test
    public void emptyProfilesNodeCausesExceptionTest() throws Exception {
        // Describe the exception to expect
        thrown.expect(FailedExpectationException.class);
        thrown.expectMessage(PROFILES_EMPTY_MSG);

        // Prepare the configuration data
        configNode.putObject(PROFILES_KEY);

        // Attempt to parse the profiles
        profilesParser.parse(configNode);
    }

    @Before
    public void setUp() throws Exception {
        // Create the JSON data
        configNode = new ObjectMapper()
                .getNodeFactory()
                .objectNode();
        ObjectNode profilesNode = configNode.putObject(PROFILES_KEY);
        profileOneNode = profilesNode.putObject(PROFILE_NAME_ONE);
        profileTwoNode = profilesNode.putObject(PROFILE_NAME_TWO);

        // Profile parser mocking
        profileOne = mock(Profile.class);
        profileTwo = mock(Profile.class);
        profileParser = mock(CompositeProfileParser.class);
        doReturn(profileOne)
                .when(profileParser)
                .parse(eq(PROFILE_NAME_ONE), eq(profileOneNode));
        doReturn(profileTwo)
                .when(profileParser)
                .parse(eq(PROFILE_NAME_TWO), eq(profileTwoNode));

        // Create the profiles parser
        profilesParser = new DefaultProfilesParser(profileParser);
    }
}
