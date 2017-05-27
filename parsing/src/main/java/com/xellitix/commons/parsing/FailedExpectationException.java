package com.xellitix.commons.parsing;

/**
 * Failed parser expectation exception.
 *
 * <p>
 * Occurs when input does not conform to the expectations of a parser.
 * </p>
 *
 * @author Grayson Kuhns
 */
public class FailedExpectationException extends Exception {

    // Properties
    private String element;
    private String expectation;

    // Constants
    private static final String MSG_TEMPLATE =
            "The element \"%s\" failed the expectation \"%s\"";

    /**
     * Constructor.
     *
     * @param element The element that failed an expectation.
     * @param expectation The failed expectation.
     */
    public FailedExpectationException(
            final String element,
            final String expectation) {

        this.element = element;
        this.expectation = expectation;
    }

    /**
     * Gets the element that failed an expectation.
     *
     * @return The element that failed an expectation.
     */
    String getElement() {
        return element;
    }

    /**
     * Gets the failed expectation.
     *
     * @return The failed expectation.
     */
    String getExpectation() {
        return expectation;
    }

    /**
     * Gets the exception message.
     *
     * @return The exception message.
     */
    @Override
    public String getMessage() {
        return String.format(MSG_TEMPLATE, element, expectation);
    }
}
