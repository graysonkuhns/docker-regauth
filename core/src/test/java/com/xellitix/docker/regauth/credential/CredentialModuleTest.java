package com.xellitix.docker.regauth.credential;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

/**
 * {@link CredentialModule} test case.
 *
 * @author Grayson Kuhns
 */
public class CredentialModuleTest {

    // Fixtures
    private final Injector injector = Guice.createInjector(new CredentialModule());

    @Test
    public void getCredentialFactoryTest() {
        injector.getInstance(CredentialFactory.class);
    }
}
