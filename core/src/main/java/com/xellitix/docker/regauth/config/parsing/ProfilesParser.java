package com.xellitix.docker.regauth.config.parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.xellitix.commons.parsing.FailedExpectationException;
import com.xellitix.docker.regauth.config.Profile;

import java.util.List;

/**
 * {@link com.xellitix.docker.regauth.config.Profile}
 */
public interface ProfilesParser {

    /**
     * Parses configuration {@link Profile}s.
     *
     * @param configNode The configuration JSON data.
     * @return The {@link Profile}s.
     * @throws FailedExpectationException If an error occurs while parsing.
     */
    List<Profile> parse(JsonNode configNode) throws FailedExpectationException;
}
