package com.xellitix.docker.regauth.config.parsing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.xellitix.commons.docker.registry.DockerRegistryMatcher;
import com.xellitix.commons.parsing.json.string.JsonStringParser;
import com.xellitix.docker.regauth.config.Profile;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * {@link DefaultCompositeProfileParser} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultCompositeProfileParserTest {

    // Constants
    private static final String NAME = "profileName";
    private static final String CREDENTIAL_STORE_ID_KEY = "backend";
    private static final String CREDENTIAL_STORE_ID = "aws-ecr";

    // Fixtures
    private ObjectNode profileNode;

    private JsonStringParser stringParser;

    private List<DockerRegistryMatcher> matchers;
    private DockerRegistryMatchersParser matchersParser;

    private Profile profile;
    private CredentialStoreProfileParser credentialStoreProfileParser;
    private CredentialStoreProfileParserLocator profileParserLocator;

    private DefaultCompositeProfileParser compositeParser;

    @Test
    public void parseProfileTest() throws Exception {
        assertThat(compositeParser
                .parse(NAME, profileNode))
                .isNotNull()
                .isEqualTo(profile);

        verify(stringParser).parse(
                eq(CREDENTIAL_STORE_ID_KEY),
                eq(profileNode));

        verify(matchersParser).parse(
                eq(profileNode));

        verify(credentialStoreProfileParser).parse(
                eq(NAME),
                eq(CREDENTIAL_STORE_ID),
                eq(matchers),
                eq(profileNode));
    }

    @Before
    public void setUp() throws Exception {
        // Create the profile node
        profileNode = new ObjectMapper()
                .getNodeFactory()
                .objectNode();

        // String parser mocking
        stringParser = mock(JsonStringParser.class);
        doReturn(CREDENTIAL_STORE_ID)
                .when(stringParser)
                .parse(eq(CREDENTIAL_STORE_ID_KEY), eq(profileNode));

        // Registry matchers parser mocking
        matchers = new ArrayList<>();
        matchersParser = mock(DockerRegistryMatchersParser.class);
        doReturn(matchers)
                .when(matchersParser)
                .parse(eq(profileNode));

        // Profile parser mocking
        profile = mock(Profile.class);

        credentialStoreProfileParser = mock(CredentialStoreProfileParser.class);
        doReturn(profile)
                .when(credentialStoreProfileParser)
                .parse(eq(NAME), eq(CREDENTIAL_STORE_ID), eq(matchers), eq(profileNode));

        profileParserLocator = mock(CredentialStoreProfileParserLocator.class);
        doReturn(credentialStoreProfileParser)
                .when(profileParserLocator)
                .locate(eq(CREDENTIAL_STORE_ID));

        // Create the composite profile parser
        compositeParser = new DefaultCompositeProfileParser(
                stringParser, matchersParser, profileParserLocator);
    }
}
