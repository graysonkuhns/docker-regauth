package com.xellitix.docker.regauth.operation;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

/**
 * {@link OperationModule} test case.
 *
 * @author Grayson Kuhns
 */
public class OperationModuleTest {

    // Fixtures
    private final Injector injector = Guice.createInjector(new OperationModule());

    @Test
    public void getGetCredentialRequestFactory() {
        injector.getInstance(GetCredentialRequestFactory.class);
    }

    @Test
    public void getStoreCredentialRequestFactoryTest() {
        injector.getInstance(StoreCredentialRequestFactory.class);
    }

    @Test
    public void getDeleteCredentialRequestFactoryTest() {
        injector.getInstance(DeleteCredentialRequestFactory.class);
    }
}
