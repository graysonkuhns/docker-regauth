package com.xellitix.docker.regauth.credentialstore;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

/**
 * {@link CredentialStoreModule} test case.
 *
 * @author Grayson Kuhns
 */
public class CredentialStoreModuleTest {

    // Fixtures
    private final Injector injector = Guice.createInjector(new CredentialStoreModule());

    @Test
    public void getCredentialStoreLocatorTest() {
        injector.getInstance(CredentialStoreLocator.class);
    }
}
