package com.xellitix.docker.regauth.operation;

import com.xellitix.docker.registry.DockerRegistry;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * {@link DefaultDeleteCredentialRequest} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultDeleteCredentialRequestTest {

    // Fixtures
    private DefaultDeleteCredentialRequest request;

    @Test
    public void getOperationTest() {
        assertThat(request
                .getOperation())
                .isNotNull()
                .isEqualTo(Operation.DELETE);
    }

    @Before
    public void setUp() {
        // Mock the docker registry
        DockerRegistry registry = mock(DockerRegistry.class);

        // Create the request
        request = new DefaultDeleteCredentialRequest(registry);
    }
}
