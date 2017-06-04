package com.xellitix.docker.regauth.config.parsing;

import com.xellitix.docker.regauth.credentialstore.CredentialStore;

/**
 * {@link CredentialStoreProfileParser} locator.
 *
 * @author Grayson Kuhns
 */
public interface CredentialStoreProfileParserLocator {

    /**
     * Locates a {@link CredentialStoreProfileParser}.
     *
     * @param credentialStoreId The {@link CredentialStore} ID.
     * @return The {@link CredentialStoreProfileParser}.
     */
    CredentialStoreProfileParser locate(String credentialStoreId);
}
