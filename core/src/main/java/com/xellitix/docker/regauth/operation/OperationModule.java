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
        // Get credential request
        install(new FactoryModuleBuilder()
            .implement(GetCredentialRequest.class, DefaultGetCredentialRequest.class)
            .build(GetCredentialRequestFactory.class));

        // Store credential request
        install(new FactoryModuleBuilder()
            .implement(StoreCredentialRequest.class, DefaultStoreCredentialRequest.class)
            .build(StoreCredentialRequestFactory.class));

        // Delete credential request
        install(new FactoryModuleBuilder()
            .implement(DeleteCredentialRequest.class, DefaultDeleteCredentialRequest.class)
            .build(DeleteCredentialRequestFactory.class));
    }
}
