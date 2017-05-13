package com.xellitix.commons.network.url;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * {@link DefaultURLFactory} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultURLFactoryTest {

    // Constants
    private static final String URL_VALID = "https://host.tld:443/memes.jpg";
    private static final String URL_MALFORMED = "ya98s6d98798a7d987asd7";
    private static final String URL_MALFORMED_MSG = "no protocol: ya98s6d98798a7d987asd7";

    // Rules
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // Fixtures
    private DefaultURLFactory urlFactory = new DefaultURLFactory();

    @Test
    public void createUrlTest() throws Exception {
        // Create the URL
        URL url = urlFactory.create(URL_VALID);

        assertThat(url).isNotNull();
        assertThat(url
                .toString())
                .isNotNull()
                .isEqualTo(URL_VALID);
    }

    @Test
    public void malformedUrlCausesExceptionTest() throws Exception {
        // Describe the exception to expect
        thrown.expect(MalformedURLException.class);
        thrown.expectMessage(URL_MALFORMED_MSG);

        // Attempt to create an invalid URL
        urlFactory.create(URL_MALFORMED);
    }
}
