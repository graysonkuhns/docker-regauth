package com.xellitix.commons.parsing;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * {@link FailedExpectationException} test case.
 *
 * @author Grayson Kuhns
 */
public class FailedExpectationExceptionTest {

    // Constants
    private static final String ELEMENT = "ENV_VAR";
    private static final String EXPECTATION = "defined";
    private static final String MESSAGE =
            "The element \"ENV_VAR\" failed the expectation \"defined\"";

    // Fixtures
    private FailedExpectationException exception;

    @Test
    public void getElementTest() {
        assertThat(exception
                .getElement())
                .isNotNull()
                .isEqualTo(ELEMENT);
    }

    @Test
    public void getExpectationTest() {
        assertThat(exception
                .getExpectation())
                .isNotNull()
                .isEqualTo(EXPECTATION);
    }

    @Test
    public void getMessageTest() {
        assertThat(exception
                .getMessage())
                .isNotNull()
                .isEqualTo(MESSAGE);
    }

    @Before
    public void setUp() {
        exception = new FailedExpectationException(ELEMENT, EXPECTATION);
    }
}
