package com.event.KillMeThatName;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private FileConfiguration config;

    @Override
    public void onEnable() {
        // Load configuration file
        getConfig().options().copyDefaults(true);
        saveConfig();
        config = getConfig();

        // Register commands
        getCommand("kmtpreload").setExecutor(new ReloadCommand(this));

        // Register listener
        getServer().getPluginManager().registerEvents(new EntityListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void reload() {
        reloadConfig();
        config = getConfig();
    }

    public void killEntity(Entity entity) {
        String namesToKill = getConfig().getString("namestokill");
        String[] names = namesToKill.split(",");

        for (String name : names) {
            if (entity.getName().equals(name)) {
                entity.setHealth(0);
                getLogger().info("Killed entity: " + entity.getName());
                break;
            }
        }
    }
}

