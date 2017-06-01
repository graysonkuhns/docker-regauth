package com.xellitix.commons.parsing.json.string;

import com.fasterxml.jackson.databind.JsonNode;
import com.xellitix.commons.parsing.FailedExpectationException;

/**
 * JSON String parser.
 *
 * @author Grayson Kuhns
 */
public interface JsonStringParser {

    /**
     * Parses a {@link String} property of a {@link JsonNode}.
     *
     * @param key The property key.
     * @param parent The {@link JsonNode} containing the property.
     *
     * @return The {@link String}.
     * @throws FailedExpectationException If an error occurs while parsing.
     */
    String parse(final String key, final JsonNode parent) throws FailedExpectationException;
}
