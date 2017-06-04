package com.xellitix.docker.regauth.config.parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.xellitix.commons.parsing.FailedExpectationException;
import com.xellitix.docker.regauth.config.Profile;
import com.xellitix.docker.regauth.credentialstore.CredentialStore;

import java.util.List;
import java.util.Set;

/**
 * Default {@link CredentialStoreProfileParserLocator} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultCredentialStoreProfileParserLocator implements CredentialStoreProfileParserLocator {

    // Dependencies
    private final Set<CredentialStoreProfileParser> profileParsers;
    private final CredentialStoreProfileParser defaultProfileParser;

    /**
     * Constructor.
     *
     * @param profileParsers The {@link CredentialStoreProfileParser}s.
     * @param defaultProfileParser The default {@link CredentialStoreProfileParser}.
     */
    @Inject
    DefaultCredentialStoreProfileParserLocator(
            final Set<CredentialStoreProfileParser> profileParsers,
            final CredentialStoreProfileParser defaultProfileParser) {

        this.profileParsers = profileParsers;
        this.defaultProfileParser = defaultProfileParser;
    }

    /**
     * Locates a {@link CredentialStoreProfileParser}.
     *
     * @param credentialStoreId The {@link CredentialStore} ID.
     * @return The {@link CredentialStoreProfileParser}.
     */
    @Override
    public CredentialStoreProfileParser locate(final String credentialStoreId) {
        return profileParsers
                .stream()
                .filter(parser -> parser
                        .getCredentialStoreId()
                        .equals(credentialStoreId))
                .findFirst()
                .orElse(defaultProfileParser);
    }
}
