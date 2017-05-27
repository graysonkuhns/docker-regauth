package com.xellitix.commons.parsing;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * {@link MalformedConfigurationException} test case.
 *
 * @author Grayson Kuhns
 */
public class MalformedConfigurationExceptionTest {

    // Constants
    private static final String ELEMENT = "ENV_VAR";
    private static final String EXPECTATION = "defined";
    private static final String MESSAGE =
            "Expected the configuration value \"ENV_VAR\" to be defined";

    // Fixtures
    private FailedExpectationException failedExpectationException;
    private MalformedConfigurationException exception;

    @Test
    public void messageConstructionTest() {
        exception = new MalformedConfigurationException(MESSAGE);

        assertThat(exception
                .getMessage())
                .isNotNull()
                .isEqualTo(MESSAGE);
    }

    @Test
    public void failedExpectationConstructionTest() {
        exception = new MalformedConfigurationException(failedExpectationException);

        assertThat(exception
                .getMessage())
                .isNotNull()
                .isEqualTo(MESSAGE);
    }

    @Before
    public void setUp() {
        // Mock the failed expectation exception
        failedExpectationException = mock(FailedExpectationException.class);
        doReturn(ELEMENT)
                .when(failedExpectationException)
                .getElement();
        doReturn(EXPECTATION)
                .when(failedExpectationException)
                .getExpectation();
    }
}
