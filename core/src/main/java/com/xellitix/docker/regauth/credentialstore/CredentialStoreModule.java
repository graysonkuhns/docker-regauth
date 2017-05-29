package com.xellitix.docker.regauth.credentialstore;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

/**
 * {@link CredentialStore} Google Guice module.
 *
 * @author Grayson Kuhns
 */
public class CredentialStoreModule extends AbstractModule {

    /**
     * Configures the module.
     */
    @Override
    protected void configure() {
        // Bind the credential stores
        Multibinder<CredentialStore> credentialStoreMultibinder =
                Multibinder.newSetBinder(binder(), CredentialStore.class);

        // Credential store locator
        bind(CredentialStoreLocator.class).to(DefaultCredentialStoreLocator.class);
    }
}
