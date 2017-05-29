package com.xellitix.docker.regauth.config.parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.xellitix.commons.parsing.FailedExpectationException;
import com.xellitix.docker.regauth.credentialstore.CredentialStore;

/**
 * {@link com.xellitix.docker.regauth.credentialstore.CredentialStore}
 */
public interface CredentialStoreIdParser {

    /**
     * Parses a {@link CredentialStore} ID.
     *
     * @param profileNode The profile data.
     * @return The {@link CredentialStore} ID.
     * @throws FailedExpectationException If an error occurs while parsing.
     */
    String parse(JsonNode profileNode) throws FailedExpectationException;
}
