package org.dsequeira.telegrambot.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author daniel.sequeira
 */
public class BotProperties {

    private final Properties botProperties = new Properties();

    private BotProperties() {
        InputStream input = this.getClass().getClassLoader().getResourceAsStream("bot.properties");

        try {
            botProperties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class SingletonHolder {
        private static final BotProperties INSTANCE = new BotProperties();
    }

    public static BotProperties getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String getProperty(final String key) {
        return botProperties.getProperty(key);
    }
}
