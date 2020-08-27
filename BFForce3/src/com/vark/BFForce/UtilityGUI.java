package com.vark.BFForce;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;


public class UtilityGUI implements Listener
{

	
	
private final Inventory inv;
	
	private Plugin plugin = Main.getPlugin(Main.class);
	
	public UtilityGUI()
	{

		inv = Bukkit.createInventory(null,9,"ForceU");

	}
	
	
	
	public UtilityGUI(Plugin plugin, Player p)
	{
		

		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
		
		inv = Bukkit.createInventory(null,54,"ForceU");
		
		initializeItems(p);
		
		
		
	}
	
	
	
    public void initializeItems(Player p) {
    
    	
    	String s = ""+getSkillPoints(p);
    	
    	
        inv.setItem(0,createGuiItem(111,Material.MUSIC_DISC_FAR, "§1Force I",false));
        
        if(getPowerLevel(p, "forcepush") >= 1)
        {
        inv.setItem(9,createGuiItem(111,Material.MUSIC_DISC_FAR, "§1Force II",false));
        inv.setItem(0,createGuiItem(111,Material.MUSIC_DISC_FAR, "§1Force I",true));
        }
        
        
        
        if(getPowerLevel(p, "forcepush") == 2)
        {
        inv.setItem(18,createGuiItem(111,Material.MUSIC_DISC_FAR, "§1Force III",false));
        inv.setItem(9,createGuiItem(111,Material.MUSIC_DISC_FAR, "§1Force II",true));
        inv.setItem(0,createGuiItem(111,Material.MUSIC_DISC_FAR, "§1Force I",true));
        }
        
        if(getPowerLevel(p, "forcepush") >= 3)
        {
        inv.setItem(18,createGuiItem(111,Material.MUSIC_DISC_FAR, "§1Force III",true));
        inv.setItem(9,createGuiItem(111,Material.MUSIC_DISC_FAR, "§1Force II",true));
        inv.setItem(0,createGuiItem(111,Material.MUSIC_DISC_FAR, "§1Force I",true));
        }
        
        
        
        if(getPowerLevel(p, "forcepush") >= 1)
        inv.setItem(2,createGuiItem(121,Material.MUSIC_DISC_FAR, "§6Force Dash I",false));
        
        if(getPowerLevel(p, "forcedash") >= 1)
        {
        inv.setItem(11,createGuiItem(121,Material.MUSIC_DISC_FAR, "§6Force Dash II",false));
        inv.setItem(2,createGuiItem(121,Material.MUSIC_DISC_FAR, "§6Force Dash I",true));
        }
        
        if(getPowerLevel(p, "forcedash") == 2)
        {
        inv.setItem(20,createGuiItem(121,Material.MUSIC_DISC_FAR, "§6Force Dash III",false));
        inv.setItem(11,createGuiItem(121,Material.MUSIC_DISC_FAR, "§6Force Dash II",true));
        inv.setItem(2,createGuiItem(121,Material.MUSIC_DISC_FAR, "§6Force Dash I",true));
        
        }
        
        if(getPowerLevel(p, "forcedash") >= 3)
        {
        inv.setItem(20,createGuiItem(121,Material.MUSIC_DISC_FAR, "§6Force Dash III",true));
        inv.setItem(11,createGuiItem(121,Material.MUSIC_DISC_FAR, "§6Force Dash II",true));
        inv.setItem(2,createGuiItem(121,Material.MUSIC_DISC_FAR, "§6Force Dash I",true));
        
        }
    
        
  
        if(getPowerLevel(p, "forcepush") >= 1)
        inv.setItem(4,createGuiItem(191,Material.MUSIC_DISC_FAR, "§1Force Sense I",false));
        
        if(getPowerLevel(p, "forcesense") >= 1)
        {
        inv.setItem(13,createGuiItem(191,Material.MUSIC_DISC_FAR, "§1Force Sense II",false));
        inv.setItem(4,createGuiItem(191,Material.MUSIC_DISC_FAR, "§1Force Sense I",true));
        
        }
        if(getPowerLevel(p, "forcesense") >= 2)
        {
        inv.setItem(22,createGuiItem(191,Material.MUSIC_DISC_FAR, "§1Force Sense III",false));
        inv.setItem(13,createGuiItem(191,Material.MUSIC_DISC_FAR, "§1Force Sense II",true));
        inv.setItem(4,createGuiItem(191,Material.MUSIC_DISC_FAR, "§1Force Sense I",true));
        
        
        
        }
        
        
        if(getPowerLevel(p, "forcesense") >= 3)
        {
        inv.setItem(22,createGuiItem(191,Material.MUSIC_DISC_FAR, "§eForce Sense III",true));
        inv.setItem(13,createGuiItem(191,Material.MUSIC_DISC_FAR, "§eForce Sense II",true));
        inv.setItem(4,createGuiItem(191,Material.MUSIC_DISC_FAR, "§eForce Sense I",true));
        
        
        
        }
        
        
 
        if(getPowerLevel(p, "forcepush") >= 1)
        inv.setItem(6,createGuiItem(161,Material.RABBIT_FOOT, "§aForce Jump",false));
        
        if(getPowerLevel(p, "forcejump") >= 1)
        inv.setItem(6,createGuiItem(161,Material.RABBIT_FOOT, "§aForce Jump",true));
        
        
        if(getPowerLevel(p, "forcepush") >= 1)
        inv.setItem(8,createGuiItem(111,Material.STICK, "§bSaber Throw I",false));
        
        
        
        if(getPowerLevel(p, "saberthrow") >= 1)
        {
        inv.setItem(17,createGuiItem(111,Material.STICK, "§bSaber Throw II",false));
        inv.setItem(8,createGuiItem(111,Material.STICK, "§bSaber Throw I",true));
        }
        
        if(getPowerLevel(p, "saberthrow") >= 2)
        {
        	inv.setItem(26,createGuiItem(111,Material.STICK, "§bSaber Throw III",false));
            inv.setItem(17,createGuiItem(111,Material.STICK, "§bSaber Throw II",true));
            inv.setItem(8,createGuiItem(111,Material.STICK, "§bSaber Throw I",true));
        
        }
        
        if(getPowerLevel(p, "saberthrow") >= 3)
        {
        	inv.setItem(26,createGuiItem(111,Material.STICK, "§bSaber Throw III",true));
            inv.setItem(17,createGuiItem(111,Material.STICK, "§bSaber Throw II",true));
            inv.setItem(8,createGuiItem(111,Material.STICK, "§bSaber Throw I",true));
        
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
        if(e.getRawSlot() == 45 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	p.closeInventory();
        	Inventory i = new ForceGUI(plugin,p).getInv();
        	
        	p.openInventory(i);
        	
        	
        }
        
        //Force Push
        if(e.getRawSlot() == 0 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcepush") < 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcepush", 1);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
        if(e.getRawSlot() == 9 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcepush") == 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcepush", 2);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
        
        if(e.getRawSlot() == 18 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcepush") == 2 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcepush", 3);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
      
        //Force Dash
        if(e.getRawSlot() == 2 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcedash") < 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcedash", 1);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
        if(e.getRawSlot() == 11 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcedash") == 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcedash", 2);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
        
        if(e.getRawSlot() == 20 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcedash") == 2 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcedash", 3);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        //Force Sense
        if(e.getRawSlot() == 4 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcesense") < 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcesense", 1);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
        if(e.getRawSlot() == 13 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcesense") == 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcesense", 2);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
        
        if(e.getRawSlot() == 22 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcesense") == 2 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcesense", 3);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
        
        //Force Jump
        if(e.getRawSlot() == 6 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcejump") < 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcejump", 1);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
        //Saber Throw
        if(e.getRawSlot() == 8 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "saberthrow") < 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "saberthrow", 1);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded an Ability!");
        		
        	}
        	
        }
        
        
        if(e.getRawSlot() == 17 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "saberthrow") == 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "saberthrow", 2);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded an Ability!");
        		
        	}
        	
        }
        
        
        
        if(e.getRawSlot() == 26 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "saberthrow") == 2 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "saberthrow", 3);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded an Ability!");
        		
        	}
        	
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
