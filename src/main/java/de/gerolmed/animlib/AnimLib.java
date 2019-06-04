package de.gerolmed.animlib;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class AnimLib extends JavaPlugin {

    private Logger LOGGER;

    @Override
    public void onEnable() {

        // Get the logger
        LOGGER = getLogger();

        LOGGER.info(String.format("Booting %s...", getDescription().getFullName()));

        // Init plugin in here

        LOGGER.info(String.format("Finished booting %s! :D", getDescription().getFullName()));
    }

    @Override
    public void onDisable() {
        LOGGER.info(String.format("Starting to shutdown %s...", getDescription().getFullName()));

        // Shutdown everything here

        LOGGER.info(String.format("%s was successfully shutdown! :C", getDescription().getFullName()));
    }
}
