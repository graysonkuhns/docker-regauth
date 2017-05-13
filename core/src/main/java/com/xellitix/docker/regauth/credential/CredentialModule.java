package com.xellitix.docker.regauth.credential;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

/**
 * {@link Credential} Google Guice module.
 *
 * @author Grayson Kuhns
 */
public class CredentialModule extends AbstractModule {

    /**
     * Configures the module.
     */
    @Override
    protected void configure() {
        // Credential factory
        install(new FactoryModuleBuilder()
            .implement(Credential.class, DefaultCredential.class)
            .build(CredentialFactory.class));
    }
}
