package com.xellitix.commons.parsing.json;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.xellitix.commons.parsing.json.string.JsonStringParser;
import org.junit.Test;

/**
 * {@link JsonParsingModule} test case.
 *
 * @author Grayson Kuhns
 */
public class JsonParsingModuleTest {

    // Fixtures
    private final Injector injector = Guice.createInjector(new JsonParsingModule());

    @Test
    public void getJsonStringParserTest() {
        injector.getInstance(JsonStringParser.class);
    }
}
