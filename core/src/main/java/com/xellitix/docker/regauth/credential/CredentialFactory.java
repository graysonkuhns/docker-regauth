package com.xellitix.docker.regauth.credential;

import com.google.inject.assistedinject.Assisted;

/**
 * {@link Credential} factory.
 *
 * @author Grayson Kuhns
 */
public interface CredentialFactory {

    /**
     * Creates a {@link Credential}.
     *
     * @param username The username.
     * @param password The password.
     * @return The {@link Credential}.
     */
    Credential create(
            @Assisted("username") final String username,
            @Assisted("password") final String password);
}
