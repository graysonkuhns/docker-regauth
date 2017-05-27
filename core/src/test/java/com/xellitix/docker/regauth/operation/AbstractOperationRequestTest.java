package com.xellitix.docker.regauth.operation;

import com.xellitix.commons.docker.registry.DockerRegistry;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * {@link AbstractOperationRequest} test case.
 *
 * @author Grayson Kuhns
 */
public class AbstractOperationRequestTest {

    // Fixtures
    private DockerRegistry registry;
    private AbstractOperationRequest request;

    @Test
    public void getDockerRegistryTest() {
        assertThat(request
                .getDockerRegistry())
                .isNotNull()
                .isEqualTo(registry);
    }

    @Before
    public void setUp() {
        // Mock the docker registry
        registry = mock(DockerRegistry.class);

        // Create the get credential operation
        request = new AbstractOperationRequest(registry) {

            @Override
            public Operation getOperation() {
                return Operation.GET;
            }
        };
    }
}
