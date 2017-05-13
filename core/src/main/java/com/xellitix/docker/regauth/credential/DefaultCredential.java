package com.xellitix.docker.regauth.credential;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

/**
 * Default {@link Credential} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultCredential implements Credential {

    // Properties
    private final String username;
    private final String password;

    /**
     * Constructor.
     *
     * @param username The username.
     * @param password The password.
     */
    @Inject
    DefaultCredential(
            @Assisted("username") final String username,
            @Assisted("password") final String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the username.
     *
     * @return The username.
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password.
     *
     * @return The password.
     */
    @Override
    public String getPassword() {
        return password;
    }
}
