package com.xellitix.docker.regauth.config.parsing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.xellitix.commons.parsing.FailedExpectationException;
import com.xellitix.docker.regauth.credentialstore.CredentialStoreLocator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * {@link DefaultCredentialStoreIdParser} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultCredentialStoreIdParserTest {

    // Constants
    private static final String CREDENTIAL_STORE_ID_KEY = "backend";
    private static final String CREDENTIAL_STORE_ID = "credStore";
    private static final String CREDENTIAL_STORE_ID_UNDEFINED_MSG =
            "The element \"backend\" failed the expectation \"be defined\"";
    private static final String CREDENTIAL_STORE_ID_NON_STRING_MSG =
            "The element \"backend\" failed the expectation \"be a String\"";

    // Rules
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // Fixtures
    private ObjectNode profileNode;
    private DefaultCredentialStoreIdParser parser;

    @Test
    public void parseTest() throws Exception {
        assertThat(parser
                .parse(profileNode))
                .isNotNull()
                .isEqualTo(CREDENTIAL_STORE_ID);
    }

    @Test
    public void undefinedCredentialStoreIdCausesExceptionTest() throws Exception {
        // Describe the exception to expect
        thrown.expect(FailedExpectationException.class);
        thrown.expectMessage(CREDENTIAL_STORE_ID_UNDEFINED_MSG);

        // Prepare the profile node
        profileNode.remove(CREDENTIAL_STORE_ID_KEY);

        // Attempt to parse the credential store id
        parser.parse(profileNode);
    }

    @Test
    public void nonStringCredentialStoreIdCausesExceptionTest() throws Exception {
        // Describe the exception to expect
        thrown.expect(FailedExpectationException.class);
        thrown.expectMessage(CREDENTIAL_STORE_ID_NON_STRING_MSG);

        // Prepare the profile node
        profileNode.put(CREDENTIAL_STORE_ID_KEY, 5);

        // Attempt to parse the credential store id
        parser.parse(profileNode);
    }

    @Before
    public void setUp() {
        // Create the profile node
        profileNode = new ObjectMapper()
                .getNodeFactory()
                .objectNode();
        profileNode.put(CREDENTIAL_STORE_ID_KEY, CREDENTIAL_STORE_ID);

        // Create the credential store id parser
        parser = new DefaultCredentialStoreIdParser();
    }
}
