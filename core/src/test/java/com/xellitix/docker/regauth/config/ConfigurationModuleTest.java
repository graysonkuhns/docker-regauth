package com.xellitix.docker.regauth.config;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.xellitix.commons.docker.registry.DockerRegistryModule;
import com.xellitix.commons.network.NetworkModule;
import com.xellitix.commons.parsing.json.JsonParsingModule;
import com.xellitix.docker.regauth.config.parsing.*;
import org.junit.Test;

/**
 * {@link ConfigurationModule} test case.
 *
 * @author Grayson Kuhns
 */
public class ConfigurationModuleTest {

    private final Injector injector = Guice.createInjector(
            new ConfigurationModule(),
            new JsonParsingModule(),
            new DockerRegistryModule(),
            new NetworkModule());

    @Test
    public void getProfileFactoryTest() {
        injector.getInstance(ProfileFactory.class);
    }

    // Parsers
    @Test
    public void getDockerRegistryMatchersParserTest() {
        injector.getInstance(DockerRegistryMatchersParser.class);
    }

    @Test
    public void getCredentialStoreProfileParserTest() {
        injector.getInstance(CredentialStoreProfileParser.class);
    }

    @Test
    public void getCredentialStoreProfileParserLocatorTest() {
        injector.getInstance(CredentialStoreProfileParserLocator.class);
    }

    @Test
    public void getCompositeProfileParserTest() {
        injector.getInstance(CompositeProfileParser.class);
    }

    @Test
    public void getProfilesParserTest() {
        injector.getInstance(ProfilesParser.class);
    }
}
