package com.minecarts.oldmcdonald.helper;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.CreatureType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: stephen
 * Date: 12/13/11
 * Time: 10:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class SpawnReport {

    private Map<FailureReason,MutableInt> failureCounts = new HashMap<FailureReason,MutableInt>();
    private Map<CreatureType,MutableInt> successCounts = new HashMap<CreatureType,MutableInt>();

    public String getFailiureCountColor(FailureReason reason){
        int count = this.getFailureCount(reason);
        return (count > 0) ? ChatColor.RED + "" + count + ChatColor.GRAY : "0";
    }
    public int getFailureCount(FailureReason reason){
        if(!failureCounts.containsKey(reason)) return 0;
        return failureCounts.get(reason).get();
    }
     public String getSuccessCountColor(CreatureType type){
        int count = this.getSuccessCount(type);
        return (count > 0) ? ChatColor.GREEN + "" + count + ChatColor.GRAY : "0";
    }
    public int getSuccessCount(CreatureType type){
        if(!successCounts.containsKey(type)) return 0;
        return successCounts.get(type).get();
    }


    public void incrementFailure(FailureReason reason){
        MutableInt value = failureCounts.get(reason);
        if(value == null){
            failureCounts.put(reason, new MutableInt());
        } else {
            value.inc();
        }
    }

    public void incrementSuccess(CreatureType type){
        MutableInt value = successCounts.get(type);
        if(value == null){
            successCounts.put(type, new MutableInt());
        } else {
            value.inc();
        }
    }

   public void incrementSuccess(CreatureType type, int amt){
        MutableInt value = successCounts.get(type);
        if(value == null){
            successCounts.put(type, new MutableInt(amt));
        } else {
            value.inc(amt);
        }
    }

    public static enum FailureReason{
        CHANCE_FREQUENCY,
        CHANCE_BIOME,
        LEVEL_LIGHT,
        MAX_WORLD,
        MAX_NEARBY,
        TYPE_BIOME,
        TYPE_BLOCK,
    }

    public static class MutableInt {
        int value;
        public MutableInt(){
            value = 1;
        }
        public MutableInt(int amt){
            this.value =amt;
        }
        public void inc () { ++value; }
        public void inc (int amt) { value+=amt; }
        public int get () { return value; }
    }
}
