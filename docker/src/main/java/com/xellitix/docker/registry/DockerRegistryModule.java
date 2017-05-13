package com.xellitix.docker.registry;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

/**
 * {@link DockerRegistry} Google Guice module.
 *
 * @author Grayson Kuhns
 */
public class DockerRegistryModule extends AbstractModule {

    /**
     * Configures the module.
     */
    @Override
    protected void configure() {
        // Docker registry factory
        install(new FactoryModuleBuilder()
            .implement(DockerRegistry.class, DefaultDockerRegistry.class)
            .build(DockerRegistryFactory.class));
    }
}
