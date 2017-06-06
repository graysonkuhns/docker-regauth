package com.xellitix.docker.regauth.config;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.multibindings.Multibinder;
import com.xellitix.docker.regauth.config.parsing.*;

/**
 * {@link Configuration} Google guice module.
 *
 * @author Grayson Kuhns
 */
public class ConfigurationModule extends AbstractModule {

    /**
     * Configures the module.
     */
    @Override
    protected void configure() {
        // Profile factory
        install(new FactoryModuleBuilder()
            .implement(Profile.class, DefaultProfile.class)
            .build(ProfileFactory.class));

        // Parsers
        bind(DockerRegistryMatchersParser.class).to(DefaultDockerRegistryMatchersParser.class);
        bind(CredentialStoreProfileParser.class).to(DefaultCredentialStoreProfileParser.class);

        Multibinder<CredentialStoreProfileParser> profileParserBinder =
                Multibinder.newSetBinder(binder(), CredentialStoreProfileParser.class);

        bind(CredentialStoreProfileParserLocator.class).to(DefaultCredentialStoreProfileParserLocator.class);
        bind(CompositeProfileParser.class).to(DefaultCompositeProfileParser.class);
        bind(ProfilesParser.class).to(DefaultProfilesParser.class);
    }
}
