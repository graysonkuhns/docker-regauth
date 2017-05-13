package com.xellitix.commons.network.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * {@link URL} factory.
 *
 * <p>
 * Adapter for creating {@link URL} instances using the factory pattern.
 *
 * This allows for more controlled testing of classes which instantiate {@link URL}s.
 * </p>
 *
 * @author Grayson Kuhns
 */
public interface URLFactory {

    /**
     * Creates a {@link URL}.
     *
     * @param url The URL string.
     * @return The {@link URL}.
     * @throws MalformedURLException If the URL is malformed.
     */
    URL create(String url) throws MalformedURLException;
}
