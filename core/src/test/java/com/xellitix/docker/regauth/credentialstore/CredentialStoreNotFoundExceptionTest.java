package com.xellitix.docker.regauth.credentialstore;

import com.xellitix.docker.regauth.credential.Credential;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * {@link CredentialStoreNotFoundException} test case.
 *
 * @author Grayson Kuhns
 */
public class CredentialStoreNotFoundExceptionTest {

    // Constants
    private static final String CREDENTIAL_STORE_ID = "credStore";
    private static final String ID_NOT_FOUND_MSG =
            "A credential store matching the ID \"credStore\" could not be found";

    private static final Class<? extends CredentialStore> CREDENTIAL_STORE_CLASS = CredentialStore.class;
    private static final String CLASS_NOT_FOUND_MSG =
            "A credential store matching the class \"com.xellitix.docker.regauth.credentialstore.CredentialStore\" could not be found";

    @Test
    public void getIdNotFoundMessageTest() {
        CredentialStoreNotFoundException exception = new CredentialStoreNotFoundException(CREDENTIAL_STORE_ID);

        assertThat(exception
                .getMessage())
                .isNotNull()
                .isEqualTo(ID_NOT_FOUND_MSG);
    }

    @Test
    public void getClassNotFoundMessageTest() {
        CredentialStoreNotFoundException exception = new CredentialStoreNotFoundException(CREDENTIAL_STORE_CLASS);

        assertThat(exception
                .getMessage())
                .isNotNull()
                .isEqualTo(CLASS_NOT_FOUND_MSG);
    }
}
