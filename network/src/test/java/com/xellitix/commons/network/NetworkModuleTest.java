package com.xellitix.commons.network;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.xellitix.commons.network.url.URLFactory;
import org.junit.Test;

/**
 * {@link NetworkModule} test case.
 *
 * @author Grayson Kuhns
 */
public class NetworkModuleTest {

    // Fixtures
    private final Injector injector = Guice.createInjector(new NetworkModule());

    @Test
    public void getURLFactoryTest() {
        injector.getInstance(URLFactory.class);
    }
}
