package com.minecarts.oldmcdonald.listener;

import com.minecarts.oldmcdonald.OldMcDonald;
import org.bukkit.entity.Animals;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class EntityListener extends org.bukkit.event.entity.EntityListener {
    private OldMcDonald plugin;
    public EntityListener(OldMcDonald plugin){
        this.plugin = plugin;
    }

    //We have to cancel the event becuase if we dont then chicken eggs don't spawn correctly
    //  Ideally we would handle the egg spawning ourselves so we can disable it
    //  but.. that will have to be done later. Spammy event is spammy
    @Override
    public void onCreatureSpawn(CreatureSpawnEvent e){
        if(e.isCancelled()) return;
        if(e.getSpawnReason() != CreatureSpawnEvent.SpawnReason.NATURAL) return;
        if(!(e.getEntity() instanceof Animals)) return;
        
        if(!plugin.getConfig().getBoolean("native_spawning")){
            e.setCancelled(true);
        }
    }
}
