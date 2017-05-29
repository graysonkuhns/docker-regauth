package com.xellitix.docker.regauth.credentialstore;

/**
 * {@link CredentialStore} not found exception.
 *
 * @author Grayson Kuhns
 */
public class CredentialStoreNotFoundException extends Exception {

    // Constants
    private static final String ID_NOT_FOUND_MSG_TEMPLATE =
            "A credential store matching the ID \"%s\" could not be found";
    private static final String CLASS_NOT_FOUND_MSG_TEMPLATE =
            "A credential store matching the class \"%s\" could not be found";

    /**
     * Constructor.
     *
     * @param id The {@link CredentialStore} ID that was unable to be found.
     */
    public CredentialStoreNotFoundException(final String id) {
        super(String.format(ID_NOT_FOUND_MSG_TEMPLATE, id));
    }

    /**
     * Constructor.
     *
     * @param clazz The {@link CredentialStore} {@link Class} that was unable to be found.
     */
    public CredentialStoreNotFoundException(final Class<? extends CredentialStore> clazz) {
        super(String.format(CLASS_NOT_FOUND_MSG_TEMPLATE, clazz.getName()));
    }
}
