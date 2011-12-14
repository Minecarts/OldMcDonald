package com.minecarts.oldmcdonald.command;

import com.minecarts.oldmcdonald.CommandHandler;
import com.minecarts.oldmcdonald.OldMcDonald;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class AnimalCommand extends CommandHandler{
     private OldMcDonald plugin;
     private int reportTaskId = 0;
     public AnimalCommand(OldMcDonald plugin){
        super(plugin);
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length < 1){
            return false;
        }
        if(args[0].equals("reload")){
            if(!sender.hasPermission("oldmcdonald.reload")) return false;
            plugin.reloadConfig();
            sender.sendMessage("Animal spawning config reloaded");
            return true;
        }
        if(args[0].equals("report")){
            if(!sender.hasPermission("oldmcdonald.stats")) return false;
            if(args.length < 2) return false;
            if(args[1].equals("start")){
                if(reportTaskId != 0){
                    sender.sendMessage("Report is already displaying");
                }
                reportTaskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin,new Runnable() {
                    public void run() {
                        if(plugin.spawner != null){
                            plugin.spawner.displayReport();
                        }
                    }
                },20 * plugin.getConfig().getInt("report_delay"),20 * 60);
                sender.sendMessage("Animal spawning report will now display");
                return true;
            }
            if(args[1].equals("stop")){
                Bukkit.getScheduler().cancelTask(reportTaskId);
                sender.sendMessage("Animal spawning report has been canceled");
                return true;
            }
        }
        return false;
    }
}
