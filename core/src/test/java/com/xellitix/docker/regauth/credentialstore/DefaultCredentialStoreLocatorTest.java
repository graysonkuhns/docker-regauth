package com.xellitix.docker.regauth.credentialstore;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;

/**
 * {@link DefaultCredentialStoreLocator} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultCredentialStoreLocatorTest {

    // Constants
    private static final String FOO_ID = "foo";
    private static final String BAR_ID = "bar";
    private static final String ABC_ID = "abc";

    private static final String CLASS_NOT_FOUND_MSG =
            "A credential store matching the class \"com.xellitix.docker.regauth.credentialstore.DefaultCredentialStoreLocatorTest$AbcCredentialStore\" could not be found";
    private static final String ID_NOT_FOUND_MSG =
            "A credential store matching the ID \"abc\" could not be found";

    // Rules
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // Fixtures
    private CredentialStore fooCredentialStore;
    private CredentialStore barCredentialStore;
    private DefaultCredentialStoreLocator locator;

    @Test
    public void locateCredentialStoreByIdTest() throws Exception {
        assertThat(locator
                .locate(FOO_ID))
                .isNotNull()
                .isEqualTo(fooCredentialStore);

        assertThat(locator
                .locate(BAR_ID))
                .isNotNull()
                .isEqualTo(barCredentialStore);
    }

    @Test
    public void locateCredentialStoreByClassTest() throws Exception {
        assertThat(locator
                .locate(FooCredentialStore.class))
                .isNotNull()
                .isEqualTo(fooCredentialStore);

        assertThat(locator
                .locate(BarCredentialStore.class))
                .isNotNull()
                .isEqualTo(barCredentialStore);
    }

    @Test
    public void locateMissingIdCausesExceptionTest() throws Exception {
        // Describe the exception to expect
        thrown.expect(CredentialStoreNotFoundException.class);
        thrown.expectMessage(ID_NOT_FOUND_MSG);

        // Attempt to locate a non-existent credential store
        locator.locate(ABC_ID);
    }

    @Test
    public void locateMissingClassCausesExceptionTest() throws Exception {
        // Describe the exception to expect
        thrown.expect(CredentialStoreNotFoundException.class);
        thrown.expectMessage(CLASS_NOT_FOUND_MSG);

        // Attempt to locate a non-existent credential store
        locator.locate(AbcCredentialStore.class);
    }

    @Before
    public void setUp() {
        // Mock the credential stores
        fooCredentialStore = mock(FooCredentialStore.class);
        doReturn(FOO_ID)
                .when(fooCredentialStore)
                .getId();

        barCredentialStore = mock(BarCredentialStore.class);
        doReturn(BAR_ID)
                .when(barCredentialStore)
                .getId();

        // Create the credential store locator
        Set<CredentialStore> credentialStores = new HashSet<>();
        credentialStores.add(fooCredentialStore);
        credentialStores.add(barCredentialStore);
        locator = new DefaultCredentialStoreLocator(credentialStores);
    }

    // Test data types
    private interface FooCredentialStore extends CredentialStore {
    }

    private interface BarCredentialStore extends CredentialStore {
    }

    private interface AbcCredentialStore extends CredentialStore {
    }
}
