package com.xellitix.commons.parsing;

/**
 * Malformed configuration exception.
 *
 * @author Grayson Kuhns
 */
public class MalformedConfigurationException extends Exception {

    // Constants
    private static final String FAILED_EXPECTATION_MSG_TEMPLATE =
            "Expected the configuration value \"%s\" to %s";

    /**
     * Constructor.
     *
     * @param message The exception message.
     */
    public MalformedConfigurationException(final String message) {
        super(message);
    }

    /**
     * Constructor.
     *
     * @param ex The {@link FailedExpectationException}.
     */
    public MalformedConfigurationException(final FailedExpectationException ex) {
        super(String.format(
                FAILED_EXPECTATION_MSG_TEMPLATE,
                ex.getElement(),
                ex.getExpectation()));
    }
}
