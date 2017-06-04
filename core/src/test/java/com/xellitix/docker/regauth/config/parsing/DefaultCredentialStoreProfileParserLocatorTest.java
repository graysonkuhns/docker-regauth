package com.xellitix.docker.regauth.config.parsing;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;

/**
 * {@link DefaultCredentialStoreProfileParserLocator} test case.
 *
 * @author Grayson Kuhns
 */
public class DefaultCredentialStoreProfileParserLocatorTest {

    // Constants
    private static final String ID_ONE = "one";
    private static final String ID_TWO = "two";
    private static final String ID_MISSING = "fooBar";

    // Fixtures
    private CredentialStoreProfileParser defaultParser;
    private CredentialStoreProfileParser parserOne;
    private CredentialStoreProfileParser parserTwo;

    private CredentialStoreProfileParserLocator parserLocator;

    @Test
    public void getParserByIdTest() {
        assertThat(parserLocator
                .locate(ID_ONE))
                .isNotNull()
                .isEqualTo(parserOne);

        assertThat(parserLocator
                .locate(ID_TWO))
                .isNotNull()
                .isEqualTo(parserTwo);
    }

    @Test
    public void getDefaultParserForMissingIdTest() {
        assertThat(parserLocator
                .locate(ID_MISSING))
                .isNotNull()
                .isEqualTo(defaultParser);
    }

    @Before
    public void setUp() {
        // Parser mocking
        defaultParser = mock(CredentialStoreProfileParser.class);

        parserOne = mock(CredentialStoreProfileParser.class);
        doReturn(ID_ONE)
                .when(parserOne)
                .getCredentialStoreId();

        parserTwo = mock(CredentialStoreProfileParser.class);
        doReturn(ID_TWO)
                .when(parserTwo)
                .getCredentialStoreId();

        Set<CredentialStoreProfileParser> parsers = new HashSet<>();
        parsers.add(parserOne);
        parsers.add(parserTwo);

        // Create the parser locator
        parserLocator = new DefaultCredentialStoreProfileParserLocator(parsers, defaultParser);
    }
}
