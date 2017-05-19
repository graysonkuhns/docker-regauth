package com.xellitix.docker.regauth.config;

import java.util.Set;

/**
 * Configuration model.
 *
 * @author Grayson Kuhns
 */
public interface Configuration {

    /**
     * Gets the {@link Profile}s.
     *
     * @return The {@link Profile}s.
     */
    Set<Profile> getProfiles();
}
