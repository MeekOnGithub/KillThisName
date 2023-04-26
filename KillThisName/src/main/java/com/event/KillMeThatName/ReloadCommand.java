package com.event.KillMeThatName;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {
    private Main plugin;

    public ReloadCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("kmtpreload")) {
            plugin.reload();
            sender.sendMessage("[§l§6KillMeThatName§r] - Reloaded !");
            return true;
        }
        return false;
    }
}
