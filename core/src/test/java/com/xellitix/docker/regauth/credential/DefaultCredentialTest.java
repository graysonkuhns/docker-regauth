package com.xellitix.docker.regauth.credential;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * {@link DefaultCredential} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultCredentialTest {

    // Constants
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    // Fixtures
    private final DefaultCredential credential = new DefaultCredential(USERNAME, PASSWORD);

    @Test
    public void getUsernameTest() {
        assertThat(credential
                .getUsername())
                .isNotNull()
                .isEqualTo(USERNAME);
    }

    @Test
    public void getPasswordTest() {
        assertThat(credential
                .getPassword())
                .isNotNull()
                .isEqualTo(PASSWORD);
    }
}
