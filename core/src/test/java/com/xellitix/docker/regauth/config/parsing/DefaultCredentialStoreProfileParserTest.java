package com.xellitix.docker.regauth.config.parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.xellitix.commons.docker.registry.DockerRegistryMatcher;
import com.xellitix.docker.regauth.config.Profile;
import com.xellitix.docker.regauth.config.ProfileFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * {@link DefaultCredentialStoreProfileParser} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultCredentialStoreProfileParserTest {

    // Constants
    private static final String NAME = "profileName";
    private static final String CREDENTIAL_STORE_ID = "aws-ecr";

    // Fixtures
    private List<DockerRegistryMatcher> registryMatchers;
    private JsonNode profileNode;

    private Profile profile;
    private ProfileFactory profileFactory;

    private DefaultCredentialStoreProfileParser parser;

    @Test
    public void getCredentialStoreIdTest() {
        assertThat(parser
                .getCredentialStoreId())
                .isNotNull()
                .isEqualTo("N/A");
    }

    @Test
    public void parseProfileTest() throws Exception {
        assertThat(parser
                .parse(NAME, CREDENTIAL_STORE_ID, registryMatchers, profileNode))
                .isNotNull()
                .isEqualTo(profile);

        verify(profileFactory).create(
                eq(NAME),
                eq(CREDENTIAL_STORE_ID),
                eq(registryMatchers));
    }

    @Before
    public void setUp() {
        // Create registry matchers
        registryMatchers = new ArrayList<>();

        // Create profile JSON node
        profileNode = new ObjectMapper()
                .getNodeFactory()
                .objectNode();

        // Profile factory mocking
        profile = mock(Profile.class);
        profileFactory = mock(ProfileFactory.class);
        doReturn(profile)
                .when(profileFactory)
                .create(eq(NAME), eq(CREDENTIAL_STORE_ID), eq(registryMatchers));

        // Create the profile parser
        parser = new DefaultCredentialStoreProfileParser(profileFactory);
    }
}
