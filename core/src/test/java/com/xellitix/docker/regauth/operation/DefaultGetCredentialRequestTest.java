package com.xellitix.docker.regauth.operation;

import com.xellitix.commons.docker.registry.DockerRegistry;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * {@link DefaultGetCredentialRequest} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultGetCredentialRequestTest {

    // Fixtures
    private DefaultGetCredentialRequest request;

    @Test
    public void getOperationRequest() {
        assertThat(request
                .getOperation())
                .isNotNull()
                .isEqualTo(Operation.GET);
    }

    @Before
    public void setUp() {
        // Mock the docker registry
        DockerRegistry registry = mock(DockerRegistry.class);

        // Create the request
        request = new DefaultGetCredentialRequest(registry);
    }
}
