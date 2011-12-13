package com.minecarts.oldmcdonald;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public abstract class CommandHandler implements CommandExecutor {
    protected final OldMcDonald plugin;

    public CommandHandler(OldMcDonald plugin) {
        this.plugin = plugin;
    }

    public abstract boolean onCommand(CommandSender sender, Command command, String label, String[] args);
}
