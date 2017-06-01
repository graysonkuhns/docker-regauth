package com.xellitix.commons.parsing.json.string;

import com.fasterxml.jackson.databind.JsonNode;
import com.xellitix.commons.parsing.FailedExpectationException;

/**
 * Default {@link JsonStringParser} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultJsonStringParser implements JsonStringParser {

    /**
     * Parses a {@link String} property of a {@link JsonNode}.
     *
     * @param key The property key.
     * @param parent The {@link JsonNode} containing the property.
     * @return The {@link String}.
     * @throws FailedExpectationException If an error occurs while parsing.
     */
    @Override
    public String parse(final String key, final JsonNode parent) throws FailedExpectationException {

        // Get the property node
        JsonNode property = parent.get(key);

        // Validate the property node
        if (property == null) {
            throw new FailedExpectationException(key, "be defined");
        }

        if (!property.isTextual()) {
            throw new FailedExpectationException(key, "be a String");
        }

        return property.asText();
    }
}
