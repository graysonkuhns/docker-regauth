package com.xellitix.commons.docker.registry;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.xellitix.commons.network.NetworkModule;
import org.junit.Test;

/**
 * {@link DockerRegistryModule} test case.
 *
 * @author Grayson Kuhns
 */
public class DockerRegistryModuleTest {

    // Fixtures
    private final Injector injector = Guice.createInjector(
            new NetworkModule(),
            new DockerRegistryModule());

    @Test
    public void getDockerRegistryFactoryTest() {
        injector.getInstance(DockerRegistryFactory.class);
    }

    @Test
    public void getDockerRegistryParserTest() {
        injector.getInstance(DockerRegistryParser.class);
    }

    @Test
    public void getDockerRegistryMatcherFactoryTest() {
        injector.getInstance(DockerRegistryMatcherFactory.class);
    }

    @Test
    public void getDockerRegistryMatcherParserTest() {
        injector.getInstance(DockerRegistryMatcherParser.class);
    }
}
