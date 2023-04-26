package com.event.KillMeThatName;


import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.List;

public class EntityListener implements Listener {

    private Main plugin;

    public EntityListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof Player) {
            return;
        }

        List<String> namesToKill = plugin.getConfig().getStringList("namestokill");

        for (String name : namesToKill) {
            if (entity.getName().equalsIgnoreCase(name)) {
                entity.remove();
                plugin.getServer().broadcastMessage("[§l§6KillMeThatName§r] - "+ entity.getName() " was killed by the plugin.");
                break;
            }
        }
    }
}
