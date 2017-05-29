package com.xellitix.docker.regauth.credentialstore;

/**
 * {@link CredentialStore} locator.
 *
 * @author Grayson Kuhns
 */
public interface CredentialStoreLocator {

    /**
     * Locates a {@link CredentialStore} by ID.
     *
     * @param id The ID.
     * @return The {@link CredentialStore}.
     * @throws CredentialStoreNotFoundException If a {@link CredentialStore} cannot be located.
     */
    CredentialStore locate(final String id) throws CredentialStoreNotFoundException;

    /**
     * Locates a {@link CredentialStore} by {@link Class}.
     *
     * @param clazz The {@link Class}.
     * @return The {@link CredentialStore}.
     * @throws CredentialStoreNotFoundException If a {@link CredentialStore} cannot be located.
     */
    CredentialStore locate(final Class<? extends CredentialStore> clazz) throws CredentialStoreNotFoundException;
}
