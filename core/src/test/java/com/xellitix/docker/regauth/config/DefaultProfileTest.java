package com.xellitix.docker.regauth.config;

import com.xellitix.docker.regauth.credentialstore.CredentialStore;
import com.xellitix.commons.docker.registry.DockerRegistryMatcher;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    private static final String CREDENTIAL_STORE_ID = "credStore";

    // Fixtures
    private List<DockerRegistryMatcher> registryMatchers;
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
                .getCredentialStoreId())
                .isNotNull()
                .isEqualTo(CREDENTIAL_STORE_ID);
    }

    @Test
    public void getDockerRegistryMatchersTest() {
        assertThat(profile
                .getDockerRegistryMatchers())
                .isNotNull()
                .isEqualTo(registryMatchers);
    }

    @Before
    public void setUp() {
        // Create the docker registries
        registryMatchers = new ArrayList<>();

        // Create the profile
        profile = new DefaultProfile(NAME, CREDENTIAL_STORE_ID, registryMatchers);
    }
}
