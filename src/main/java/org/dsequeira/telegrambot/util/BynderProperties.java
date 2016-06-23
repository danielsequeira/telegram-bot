package org.dsequeira.telegrambot.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author daniel.sequeira
 */
public class BynderProperties {

    private final Properties bynderProperties = new Properties();

    private BynderProperties() {
        InputStream input = this.getClass().getClassLoader().getResourceAsStream("bynder.properties");

        try {
            bynderProperties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class SingletonHolder {
        private static final BynderProperties INSTANCE = new BynderProperties();
    }

    public static BynderProperties getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String getProperty(final String key) {
        return bynderProperties.getProperty(key);
    }
}
