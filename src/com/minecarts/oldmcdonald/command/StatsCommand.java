package com.minecarts.oldmcdonald.command;

import com.minecarts.oldmcdonald.CommandHandler;
import com.minecarts.oldmcdonald.OldMcDonald;
import net.minecraft.server.*;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.entity.Player;

import java.text.MessageFormat;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: stephen
 * Date: 12/12/11
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class StatsCommand extends CommandHandler {

    private static HashMap eligibleChunksForSpawning = new HashMap();

    public StatsCommand(OldMcDonald plugin){
        super(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("oldmcdonald.stats")) return true;
        plugin.spawner.displayReport();
        return true;
        /*sender.sendMessage("-Animal Spawning Stats-");
        World w = null;
        if(sender instanceof Player){
            w = ((Player)sender).getWorld();
        } else {
            if(args.length > 0){
                w = Bukkit.getWorld(args[0]);
            } else {
                sender.sendMessage("Please give a world name");
            }
        }

        net.minecraft.server.World notchWorld = ((CraftWorld)w).getHandle();
        //Determine the number of animals of each type
        int countPig = notchWorld.a(net.minecraft.server.EntityPig.class);
        int countSheep = notchWorld.a(net.minecraft.server.EntitySheep.class);
        int countCow = notchWorld.a(net.minecraft.server.EntityCow.class);
        int countWolf = notchWorld.a(net.minecraft.server.EntityWolf.class);
        int countSquid = notchWorld.a(net.minecraft.server.EntitySquid.class);
        
        //Simulate the number of eligible chunks for spawning
        eligibleChunksForSpawning.clear();
        int var3;
        int var6;
        for(var3 = 0; var3 < notchWorld.players.size(); ++var3)
        {
            EntityPlayer var4 = (EntityPlayer)notchWorld.players.get(var3);
            int var5 = MathHelper.floor(var4.locX / 16.0D);
            var6 = MathHelper.floor(var4.locZ / 16.0D);
            byte var7 = 8;

            for(int var8 = -var7; var8 <= var7; ++var8)
            {
                for(int var9 = -var7; var9 <= var7; ++var9)
                {
                    boolean var10 = var8 == -var7 || var8 == var7 || var9 == -var7 || var9 == var7;
                    ChunkCoordIntPair var11 = new ChunkCoordIntPair(var8 + var5, var9 + var6);
                    if(!var10)
                    {
                        eligibleChunksForSpawning.put(var11, Boolean.valueOf(false));
                    }
                    else if(!eligibleChunksForSpawning.containsKey(var11))
                    {
                        eligibleChunksForSpawning.put(var11, Boolean.valueOf(true));
                    }
                }
            }
        }

        boolean spawnPig = countPig <= EnumCreatureType.CREATURE.b() * eligibleChunksForSpawning.size() / 256;
        boolean spawnSheep  = countSheep <= EnumCreatureType.CREATURE.b() * eligibleChunksForSpawning.size() / 256;
        boolean spawnCow = countCow <= EnumCreatureType.CREATURE.b() * eligibleChunksForSpawning.size() / 256;
        boolean spawnWolf = countWolf <= EnumCreatureType.CREATURE.b() * eligibleChunksForSpawning.size() / 256;
        boolean spawnSquid = countSquid <= EnumCreatureType.CREATURE.b() * eligibleChunksForSpawning.size() / 256;


        sender.sendMessage("Total entities in world: " + notchWorld.entityList.size());
        sender.sendMessage("Total animals: " + notchWorld.a(net.minecraft.server.EntityAnimal.class));
        sender.sendMessage("Max Creature: " + EnumCreatureType.CREATURE.b());
        sender.sendMessage("# of chunks eligible: " + eligibleChunksForSpawning.size());
        sender.sendMessage(MessageFormat.format("Active: Pig: {0}, Sheep: {1}, Cow {2}, Wolf: {3}, Squid: {4}",countPig,countSheep,countCow,countWolf,countSquid));
        sender.sendMessage(MessageFormat.format("Possible: Pig: {0}, Sheep: {1}, Cow {2}, Wolf: {3}, Squid: {4}",spawnPig,spawnSheep,spawnCow,spawnWolf,spawnSquid));
        

        //

        return true;
*/
    }
}
