package com.xellitix.commons.docker.registry;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * {@link DefaultDockerRegistryMatcherParser} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultDockerRegistryMatcherParserTest {

    // Constants
    private static final String REGEX = "https:\\/\\/dockerhub\\.company\\.com";

    // Captors
    @Captor
    private ArgumentCaptor<Pattern> patternCaptor;

    // Fixtures
    private DockerRegistryMatcher matcher;
    private DockerRegistryMatcherFactory matcherFactory;
    private DefaultDockerRegistryMatcherParser matcherParser;

    @Test
    public void parseTest() {
        assertThat(matcherParser
                .parse(REGEX))
                .isNotNull()
                .isEqualTo(matcher);

        verify(matcherFactory).create(patternCaptor.capture());

        Pattern pattern = patternCaptor.getValue();
        assertThat(pattern).isNotNull();
        assertThat(pattern
                .pattern())
                .isNotNull()
                .isEqualTo(REGEX);
    }

    @Before
    public void setUp() {
        // Initialize argument captors
        MockitoAnnotations.initMocks(this);

        // Matcher mocking
        matcher = mock(DockerRegistryMatcher.class);
        matcherFactory = mock(DockerRegistryMatcherFactory.class);
        doReturn(matcher)
                .when(matcherFactory)
                .create(any(Pattern.class));

        // Create the matcher parser
        matcherParser = new DefaultDockerRegistryMatcherParser(matcherFactory);
    }
}
