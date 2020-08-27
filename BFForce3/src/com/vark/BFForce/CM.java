
package com.vark.BFForce;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.entity.Player;

/**
 *
 * @Coding Legend Ritvik Varkhedkar
 */
class CM 

{
        public static HashMap<UUID, Double> cdl; //Force Lightning
        public static HashMap<UUID, Double> cdd; //Force Dash
        public static HashMap<UUID, Double> cdm; //Force Mind Trick
        public static HashMap<UUID, Double> cdf; //Force Freeze
        public static HashMap<UUID, Double> cdh; //Force Heal
        public static HashMap<UUID, Double> cdp; //Force Push
        public static HashMap<UUID, Double> cdr; //Force Repulse
        public static HashMap<UUID, Double> cds; //Force Storm
        public static HashMap<UUID, Double> cdc; //Force Choke
        public static HashMap<UUID, Double> cddr; //Force Drain
        public static HashMap<UUID, Double> cdfs;//Force Sense
        
    
    
    public static void setupCooldown()
    {
        cdl = new HashMap<>();
        cdd = new HashMap<>();
        cdm = new HashMap<>();
        cdf = new HashMap<>();
        cdh = new HashMap<>();
        cdp = new HashMap<>();
        cdr = new HashMap<>();
        cds = new HashMap<>();
        cdc = new HashMap<>();
        cddr = new HashMap<>();
        cdfs = new HashMap<>();
    }
    
    
    
    //setCooldown
    public static void setCooldown(Player player, int seconds)
    {
        double delay = System.currentTimeMillis() + (seconds*1000);
        cdl.put(player.getUniqueId(),delay);
    }
    
    public static void setCdd(Player player, int seconds)
    {
        double delay = System.currentTimeMillis() + (seconds*1000);
        cdd.put(player.getUniqueId(),delay);
    }
    
    public static void setCddr(Player player, int seconds)
    {
        double delay = System.currentTimeMillis() + (seconds*1000);
        cddr.put(player.getUniqueId(),delay);
    }
    public static void setCdc(Player player, int seconds)
    {
        double delay = System.currentTimeMillis() + (seconds*1000);
        cdc.put(player.getUniqueId(),delay);
    }
    
    public static void setCdp(Player player, int seconds)
    {
        double delay = System.currentTimeMillis() + (seconds*1000);
        cdp.put(player.getUniqueId(),delay);
    }
    
    public static void setCdm(Player player, int seconds)
    {
        double delay = System.currentTimeMillis() + (seconds*1000);
        cdm.put(player.getUniqueId(),delay);
    }
    
    public static void setCdf(Player player, int seconds)
    {
        double delay = System.currentTimeMillis() + (seconds*1000);
        cdf.put(player.getUniqueId(),delay);
    }
    
        public static void setCdh(Player player, int seconds)
    {
        double delay = System.currentTimeMillis() + (seconds*1000);
        cdh.put(player.getUniqueId(),delay);
    }
        
        public static void setCdr(Player player, int seconds)
    {
        double delay = System.currentTimeMillis() + (seconds*1000);
        cdr.put(player.getUniqueId(),delay);
    }
        
        public static void setCds(Player player, int seconds)
    {
        double delay = System.currentTimeMillis() + (seconds*1000);
        cds.put(player.getUniqueId(),delay);
    }
        
        public static void setCdfs(Player player, int seconds)
    {
        double delay = System.currentTimeMillis() + (seconds*1000);
        cdfs.put(player.getUniqueId(),delay);
    }
    
    
    //getCooldown
    
    public static int getCooldown(Player player)
    {
        return Math.toIntExact(Math.round((cdl.get(player.getUniqueId())- System.currentTimeMillis())/1000));
    }
    
    public static int getCdd(Player player)
    {
        return Math.toIntExact(Math.round((cdd.get(player.getUniqueId())- System.currentTimeMillis())/1000));
    }
    
    public static int getCdp(Player player)
    {
        return Math.toIntExact(Math.round((cdp.get(player.getUniqueId())- System.currentTimeMillis())/1000));
    }
    
    public static int getCdm(Player player)
    {
        return Math.toIntExact(Math.round((cdm.get(player.getUniqueId())- System.currentTimeMillis())/1000));
    }
    
    public static int getCdf(Player player)
    {
        return Math.toIntExact(Math.round((cdf.get(player.getUniqueId())- System.currentTimeMillis())/1000));
    }
    
        public static int getCdh(Player player)
    {
        return Math.toIntExact(Math.round((cdh.get(player.getUniqueId())- System.currentTimeMillis())/1000));
    }
        
        public static int getCdr(Player player)
    {
        return Math.toIntExact(Math.round((cdr.get(player.getUniqueId())- System.currentTimeMillis())/1000));
    }
        
        public static int getCds(Player player)
    {
        return Math.toIntExact(Math.round((cds.get(player.getUniqueId())- System.currentTimeMillis())/1000));
    }
        
        public static int getCdc(Player player)
    {
        return Math.toIntExact(Math.round((cdc.get(player.getUniqueId())- System.currentTimeMillis())/1000));
    }
        
        public static int getCddr(Player player)
    {
        return Math.toIntExact(Math.round((cddr.get(player.getUniqueId())- System.currentTimeMillis())/1000));
    }
        public static int getCdfs(Player player)
    {
        return Math.toIntExact(Math.round((cdfs.get(player.getUniqueId())- System.currentTimeMillis())/1000));
    }
    
    
    //check cooldown
    public static boolean checkCooldown(Player player)
    {
        if(!cdl.containsKey(player.getUniqueId()) || cdl.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }
    
    public static boolean checkCdd(Player player)
    {
        if(!cdd.containsKey(player.getUniqueId()) || cdd.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }
    
    public static boolean checkCdp(Player player)
    {
        if(!cdp.containsKey(player.getUniqueId()) || cdp.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }
    
    public static boolean checkCdm(Player player)
    {
        if(!cdm.containsKey(player.getUniqueId()) || cdm.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }
    
    public static boolean checkCdf(Player player)
    {
        if(!cdf.containsKey(player.getUniqueId()) || cdf.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }
    
        public static boolean checkCdh(Player player)
    {
        if(!cdh.containsKey(player.getUniqueId()) || cdh.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }
        
        public static boolean checkCdr(Player player)
    {
        if(!cdr.containsKey(player.getUniqueId()) || cdr.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }
        
        public static boolean checkCds(Player player)
    {
        if(!cds.containsKey(player.getUniqueId()) || cds.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }
        
        public static boolean checkCdc(Player player)
    {
        if(!cdc.containsKey(player.getUniqueId()) || cdc.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }
        
        public static boolean checkCddr(Player player)
    {
        if(!cddr.containsKey(player.getUniqueId()) || cddr.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }
        
        
        public static boolean checkCdfs(Player player)
    {
        if(!cdfs.containsKey(player.getUniqueId()) || cdfs.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }
    
    

    
    
    

}
