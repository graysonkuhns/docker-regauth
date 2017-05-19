package com.xellitix.docker.regauth.config;

import com.xellitix.docker.regauth.credential.Credential;
import com.xellitix.docker.regauth.credentialstore.CredentialStore;
import com.xellitix.docker.registry.DockerRegistry;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * {@link DefaultProfile} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultProfileTest {

    // Constants
    private static final String NAME = "profileName";

    // Fixtures
    private CredentialStore credentialStore;
    private Set<DockerRegistry> dockerRegistries;
    private DefaultProfile profile;

    @Test
    public void getNameTest() {
        assertThat(profile
                .getName())
                .isNotNull()
                .isEqualTo(NAME);
    }

    @Test
    public void getCredentialStoreTest() {
        assertThat(profile
                .getCredentialStore())
                .isNotNull()
                .isEqualTo(credentialStore);
    }

    @Test
    public void getDockerRegistriesTest() {
        assertThat(profile
                .getDockerRegistries())
                .isNotNull()
                .isEqualTo(dockerRegistries);
    }

    @Before
    public void setUp() {
        // Mock the credential store
        credentialStore = mock(CredentialStore.class);

        // Create the docker registries
        dockerRegistries = new HashSet<>();

        // Create the profile
        profile = new DefaultProfile(NAME, credentialStore, dockerRegistries);
    }
}
