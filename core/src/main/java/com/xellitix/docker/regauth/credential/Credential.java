package com.xellitix.docker.regauth.credential;

import java.io.Serializable;

/**
 * Credential model.
 *
 * @author Grayson Kuhns
 */
public interface Credential extends Serializable {

    /**
     * Gets the username.
     *
     * @return The username.
     */
    String getUsername();

    /**
     * Gets the password.
     *
     * @return The password.
     */
    String getPassword();
}
