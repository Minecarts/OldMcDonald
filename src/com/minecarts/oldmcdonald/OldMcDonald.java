package com.minecarts.oldmcdonald;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.minecarts.oldmcdonald.command.AnimalCommand;
import com.minecarts.oldmcdonald.command.StatsCommand;
import com.minecarts.oldmcdonald.thread.BasicSpawner;
import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;
import net.minecraft.server.NetServerHandler;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.craftbukkit.CraftServer;

/**
 * Created by IntelliJ IDEA.
 * User: stephen
 * Date: 12/12/11
 * Time: 10:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class OldMcDonald extends JavaPlugin {
    public final Logger log = Logger.getLogger("com.minecarts.oldmcdonald");
    public BasicSpawner spawner;

    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();

        getCommand("stats").setExecutor(new StatsCommand(this));
        getCommand("animal").setExecutor(new AnimalCommand(this));

        int spawn_delay = getConfig().getInt("spawn_delay");
        int spawn_interval = getConfig().getInt("spawn_interval");

        if(getConfig().getString("algorithm").equals("basic")){
            spawner = new BasicSpawner(this);
            getServer().getScheduler().scheduleSyncRepeatingTask(
                    this,
                    spawner,
                    20 * spawn_delay,
                    20 * spawn_interval);
        } else {
            log("No other spawning algorithms are yet supported.");
        }

        //Save the config
        getConfig().options().copyDefaults(true);
        this.saveConfig();

        this.log("Enabled! Mob spawning will occur every " + spawn_interval + " seconds starting in " + spawn_delay + " seconds");
    }

    public void onDisable(){
        this.log("Disabled");
    }

    public void log(String message, java.util.logging.Level level){
        this.log.log(level, "OldMcDonald> " + message);
    }
    public void log(String message){
        this.log(message, Level.INFO);
    }
}
