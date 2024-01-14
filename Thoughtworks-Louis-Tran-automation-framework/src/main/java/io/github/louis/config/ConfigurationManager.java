package io.github.louis.config;

import org.aeonbits.owner.ConfigCache;

/**
 * @author louis
 */
public final class ConfigurationManager {

    private ConfigurationManager() {}

    public static Configuration config() {
        return ConfigCache.getOrCreate(Configuration.class);
    }
}
