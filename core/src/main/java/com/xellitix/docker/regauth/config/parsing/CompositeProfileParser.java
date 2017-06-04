package com.xellitix.docker.regauth.config.parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.xellitix.commons.parsing.FailedExpectationException;
import com.xellitix.docker.regauth.config.Profile;

/**
 * Composite {@link Profile} parser.
 *
 * @author Grayson Kuhns
 */
public interface CompositeProfileParser {

    /**
     * Parses a {@link Profile}.
     *
     * @param name The name.
     * @param profileNode The {@link Profile} JSON data.
     * @return The {@link Profile}.
     * @throws FailedExpectationException If an error occurs while parsing.
     */
    Profile parse(String name, JsonNode profileNode) throws FailedExpectationException;
}
