package com.xellitix.docker.regauth.operation;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

/**
 * {@link Operation} Google Guice module.
 *
 * @author Grayson Kuhns
 */
public class OperationModule extends AbstractModule {

    /**
     * Configures the module.
     */
    @Override
    protected void configure() {
        // Get credential request factory
        install(new FactoryModuleBuilder()
            .implement(GetCredentialRequest.class, DefaultGetCredentialRequest.class)
            .build(GetCredentialRequestFactory.class));
    }
}
