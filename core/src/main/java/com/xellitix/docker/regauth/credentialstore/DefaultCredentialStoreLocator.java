package com.xellitix.docker.regauth.credentialstore;

import com.google.inject.Inject;

import java.util.Set;

/**
 * Default {@link CredentialStoreLocator} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultCredentialStoreLocator implements CredentialStoreLocator {

    // Dependencies
    private final Set<CredentialStore> credentialStores;

    /**
     * Constructor.
     *
     * @param credentialStores The {@link CredentialStore}s.
     */
    @Inject
    DefaultCredentialStoreLocator(final Set<CredentialStore> credentialStores) {
        this.credentialStores = credentialStores;
    }

    /**
     * Locates a {@link CredentialStore} by ID.
     *
     * @param id The ID.
     * @return The {@link CredentialStore}.
     * @throws CredentialStoreNotFoundException If a {@link CredentialStore} cannot be located.
     */
    @Override
    public CredentialStore locate(
            final String id)
            throws CredentialStoreNotFoundException {

        return credentialStores
                .stream()
                .filter(store -> store
                        .getId()
                        .equals(id))
                .findFirst()
                .orElseThrow(() -> new CredentialStoreNotFoundException(id));
    }

    /**
     * Locates a {@link CredentialStore} by {@link Class}.
     *
     * @param clazz The {@link Class}.
     * @return The {@link CredentialStore}.
     * @throws CredentialStoreNotFoundException If a {@link CredentialStore} cannot be located.
     */
    @Override
    public CredentialStore locate(
            final Class<? extends CredentialStore> clazz)
            throws CredentialStoreNotFoundException {

        return credentialStores
                .stream()
                .filter(store -> clazz.isInstance(store))
                .findFirst()
                .orElseThrow(() -> new CredentialStoreNotFoundException(clazz));
    }
}
