package com.xellitix.docker.regauth.operation;

import com.xellitix.docker.regauth.credential.Credential;
import com.xellitix.commons.docker.registry.DockerRegistry;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * {@link DefaultStoreCredentialRequest} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultStoreCredentialRequestTest {

    // Fixtures
    private Credential credential;
    private DefaultStoreCredentialRequest request;

    @Test
    public void getOperationTest() {
        assertThat(request
                .getOperation())
                .isNotNull()
                .isEqualTo(Operation.STORE);
    }

    @Test
    public void getCredentialTest() {
        assertThat(request
                .getCredential())
                .isNotNull()
                .isEqualTo(credential);
    }

    @Before
    public void setUp() {
        // Create mocks
        DockerRegistry registry = mock(DockerRegistry.class);
        credential = mock(Credential.class);

        // Create the store credential request
        request = new DefaultStoreCredentialRequest(registry, credential);
    }
}
