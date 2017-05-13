package com.xellitix.commons.network;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.xellitix.commons.network.url.DefaultURLFactory;
import com.xellitix.commons.network.url.URLFactory;

/**
 * Networking Google Guice module.
 *
 * @author Grayson Kuhns
 */
public class NetworkModule extends AbstractModule {

    /**
     * Configures the module.
     */
    @Override
    protected void configure() {
        // URL factory
        bind(URLFactory.class).to(DefaultURLFactory.class);
    }
}