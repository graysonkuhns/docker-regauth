package com.xellitix.commons.network.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Default {@link URLFactory} implementation.
 *
 * @author Grayson Kuhns
 */
public class DefaultURLFactory implements URLFactory {

    /**
     * Creates a {@link URL}.
     *
     * @param url The URL string.
     * @return The {@link URL}.
     * @throws MalformedURLException If the URL is malformed.
     */
    @Override
    public URL create(final String url) throws MalformedURLException {
        return new URL(url);
    }
}
