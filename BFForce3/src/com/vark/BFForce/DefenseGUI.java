package com.vark.BFForce;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;


public class DefenseGUI implements Listener
{

	
	
private final Inventory inv;
	
	private Plugin plugin = Main.getPlugin(Main.class);
	
	public DefenseGUI()
	{

		inv = Bukkit.createInventory(null,9,"ForceD");

	}
	
	
	
	public DefenseGUI(Plugin plugin, Player p)
	{
		

		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
		
		inv = Bukkit.createInventory(null,54,"ForceD");
		
		initializeItems(p);
		
		
		
	}
	
	
	
    public void initializeItems(Player p) {
    
    	
    	String s = ""+getSkillPoints(p);
    	
    	
        inv.setItem(0,createGuiItem(181,Material.MUSIC_DISC_FAR, "§9Force Repulse I",false));
        
        if(getPowerLevel(p, "forcerepulse") >= 1)
        {
        inv.setItem(9,createGuiItem(181,Material.MUSIC_DISC_FAR, "§9Force Repulse II",false));
        inv.setItem(0,createGuiItem(181,Material.MUSIC_DISC_FAR, "§9Force Repulse III",true));
        }
        
        
        
        if(getPowerLevel(p, "forcerepulse") == 2)
        {
        inv.setItem(18,createGuiItem(181,Material.MUSIC_DISC_FAR, "§9Force Repulse III",false));
        inv.setItem(9,createGuiItem(181,Material.MUSIC_DISC_FAR, "§9Force Repulse II",true));
        inv.setItem(0,createGuiItem(181,Material.MUSIC_DISC_FAR, "§9Force Repulse I",true));
        }
        
        if(getPowerLevel(p, "forcerepulse") >= 3)
        {
        inv.setItem(18,createGuiItem(181,Material.MUSIC_DISC_FAR, "§9Force Repulse III",true));
        inv.setItem(9,createGuiItem(181,Material.MUSIC_DISC_FAR, "§9Force Repulse II",true));
        inv.setItem(0,createGuiItem(181,Material.MUSIC_DISC_FAR, "§9Force Repulse I",true));
        }
        
        
        
        
        inv.setItem(2,createGuiItem(141,Material.MUSIC_DISC_FAR, "§eForce Heal I",false));
        
        if(getPowerLevel(p, "forceheal") >= 1)
        {
        inv.setItem(11,createGuiItem(141,Material.MUSIC_DISC_FAR, "§eForce Heal II",false));
        inv.setItem(2,createGuiItem(141,Material.MUSIC_DISC_FAR, "§eForce Heal I",true));
        }
        
        if(getPowerLevel(p, "forceheal") == 2)
        {
        inv.setItem(20,createGuiItem(141,Material.MUSIC_DISC_FAR, "§eForce Heal III",false));
        inv.setItem(11,createGuiItem(141,Material.MUSIC_DISC_FAR, "§eForce Heal II",true));
        inv.setItem(2,createGuiItem(141,Material.MUSIC_DISC_FAR, "§eForce Heal I",true));
        
        }
        
        if(getPowerLevel(p, "forceheal") >= 3)
        {
        inv.setItem(20,createGuiItem(141,Material.MUSIC_DISC_FAR, "§eForce Heal III",true));
        inv.setItem(11,createGuiItem(141,Material.MUSIC_DISC_FAR, "§eForce Heal II",true));
        inv.setItem(2,createGuiItem(141,Material.MUSIC_DISC_FAR, "§eForce Heal I",true));
        
        }
    
        
  
        
        
        boolean b = false;
        
        if(getSkillPoints(p) > 0)
        	b = true;
        
        inv.setItem(53, createGuiItem(0, Material.MAGENTA_GLAZED_TERRACOTTA, "§lSkill Points "+s , b) );
        inv.setItem(45, createGuiItem(0, Material.BARRIER, "§cBack", false) );

    }
	
	
	
	
	
	public Inventory getInv()
	{
		return inv;
	}
	
	
	public int getSkillPoints(Player p)
	{
		
		File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
		
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		int x = config.getInt("skillpoints");
		
		
		return x;
		
	}
	
	

	
	
    private ItemStack createGuiItem(int n,final Material material, final String name, boolean enchanted) {
        ItemStack item = new ItemStack(material, 1);
         ItemMeta meta = item.getItemMeta();

        if(n != 0)
        {
        	
        	meta.setCustomModelData(n);
        }
        // Set the name of the item
        meta.setDisplayName(name);

        // Set the lore of the item
        item.setItemMeta(meta);
       if(enchanted)
       {
    	   
    	   item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
       }

        
       

        return item;
    }
	
	
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory() != inv) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        final Player p = (Player) e.getWhoClicked();

        // Using slots click is a best option for your inventory click's
       // p.sendMessage("You clicked at slot " + e.getRawSlot());
        
        
        //Force Repulse
        if(e.getRawSlot() == 0 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcerepulse") < 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcerepulse", 1);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
        if(e.getRawSlot() == 9 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcerepulse") == 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcerepulse", 2);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
        
        if(e.getRawSlot() == 18 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcerepulse") == 2 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcerepulse", 3);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
      
        //Force Heal
        if(e.getRawSlot() == 2 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forceheal") < 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forceheal", 1);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
        if(e.getRawSlot() == 11 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forceheal") == 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forceheal", 2);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
        
        if(e.getRawSlot() == 20 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forceheal") == 2 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forceheal", 3);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        if(e.getRawSlot() == 45 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	p.closeInventory();
        	Inventory i = new ForceGUI(plugin,p).getInv();
        	
        	p.openInventory(i);
        	
        	
        }
        
      

        
        
        
 

        
    }
    
  

	@EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory() == inv) {
          e.setCancelled(true);
        }
    }
	
    
    
    
    
    
    
    
    
    
    
    
    public int getPowerLevel(Player p, String force)
    {
    	
    
    	
    	
    	File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
    	
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		int x = config.getInt(force);
    	
    	return x;
    	
    	
    	
    }
    
    
    
    public void setPowerLevel(Player p, String force,int x)
    {
    	
    
    	
    	
    	File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
    	
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		config.set(force, x);
    	
		try {
			config.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    

    
    
    
    
    
	
    

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
