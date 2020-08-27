
package com.vark.BFForce;


import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @Coding Legend Ritvik Varkhedkar
 */
public class Main extends JavaPlugin

{

    @Override
    public void onEnable(){
        CM.setupCooldown();
        new PlayerListener(this);
        new ForceChoke(this);
        
        
        getCommand("getforce").setExecutor(new getPower());
        getCommand("forcepow").setExecutor(new ForceCommand());
        
        
        
    }
    
    @Override
    public void onDisable(){
        //
    }

}
