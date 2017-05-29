package com.xellitix.docker.regauth.config.parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.xellitix.commons.parsing.FailedExpectationException;
import com.xellitix.docker.regauth.credentialstore.CredentialStore;

/**
 * Default {@link CredentialStoreIdParser} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultCredentialStoreIdParser implements CredentialStoreIdParser {

    // Constants
    private static final String CREDENTIAL_STORE_KEY = "backend";

    /**
     * Parses a {@link CredentialStore} ID.
     *
     * @param profileNode The profile data.
     * @return The {@link CredentialStore} ID.
     * @throws FailedExpectationException If an error occurs while parsing.
     */
    @Override
    public String parse(
            final JsonNode profileNode)
            throws FailedExpectationException {

        // Get the credential store node
        JsonNode csNode = profileNode.get(CREDENTIAL_STORE_KEY);

        // Validate the credential store node
        if (csNode == null) {
            throw new FailedExpectationException(CREDENTIAL_STORE_KEY, "be defined");
        }

        if (!csNode.isTextual()) {
            throw new FailedExpectationException(CREDENTIAL_STORE_KEY, "be a String");
        }

        return csNode.asText();
    }
}
