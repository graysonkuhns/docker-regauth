package com.xellitix.commons.parsing.json.string;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.xellitix.commons.parsing.FailedExpectationException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * {@link DefaultJsonStringParser} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultJsonStringParserTest {

    // Constants
    private static final String KEY = "key";
    private static final String VALUE = "val";
    private static final String PROPERTY_UNDEFINED_MSG =
            "The element \"key\" failed the expectation \"be defined\"";
    private static final String PROPERTY_NON_STRING_MSG =
            "The element \"key\" failed the expectation \"be a String\"";

    // Rules
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // Fixtures
    private ObjectNode dataNode;
    private DefaultJsonStringParser parser;

    @Test
    public void parseStringTest() throws Exception {
        assertThat(parser
                .parse(KEY, dataNode))
                .isNotNull()
                .isEqualTo(VALUE);
    }

    @Test
    public void undefinedPropertyCausesExceptionTest() throws Exception {
        // Describe the exception to expect
        thrown.expect(FailedExpectationException.class);
        thrown.expectMessage(PROPERTY_UNDEFINED_MSG);

        // Prepare the data node
        dataNode.remove(KEY);

        // Attempt to parse a String property
        parser.parse(KEY, dataNode);
    }

    @Test
    public void nonStringPropertyCausesExceptionTest() throws Exception {
        // Describe the exception to expect
        thrown.expect(FailedExpectationException.class);
        thrown.expectMessage(PROPERTY_NON_STRING_MSG);

        // Prepare the data node
        dataNode.put(KEY, 5);

        // Attempt to parse a String property
        parser.parse(KEY, dataNode);
    }

    @Before
    public void setUp() {
        // Create the date node
        dataNode = new ObjectMapper()
                .getNodeFactory()
                .objectNode();
        dataNode.put(KEY, VALUE);

        // Create the JSON string parser
        parser = new DefaultJsonStringParser();
    }
}
