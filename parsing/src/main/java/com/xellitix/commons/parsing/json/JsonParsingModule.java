package com.xellitix.commons.parsing.json;

import com.google.inject.AbstractModule;
import com.xellitix.commons.parsing.json.string.DefaultJsonStringParser;
import com.xellitix.commons.parsing.json.string.JsonStringParser;

/**
 * JSON parsing Guice module.
 *
 * @author Grayson Kuhns
 */
public class JsonParsingModule extends AbstractModule {

    /**
     * Configures the module.
     */
    @Override
    protected void configure() {
        // JSON String parser
        bind(JsonStringParser.class).to(DefaultJsonStringParser.class);
    }
}
