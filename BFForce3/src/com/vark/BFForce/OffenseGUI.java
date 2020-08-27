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


public class OffenseGUI implements Listener
{

	
	
private final Inventory inv;
	
	private Plugin plugin = Main.getPlugin(Main.class);
	
	public OffenseGUI()
	{

		inv = Bukkit.createInventory(null,9,"ForceO");

	}
	
	
	
	public OffenseGUI(Plugin plugin, Player p)
	{
		

		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
		
		inv = Bukkit.createInventory(null,54,"ForceO");
		
		initializeItems(p);
		
		
		
	}
	
	
	
    public void initializeItems(Player p) {
    
    	
    	String s = ""+getSkillPoints(p);
    	
    	
        inv.setItem(0,createGuiItem(131,Material.MUSIC_DISC_FAR, "§cForce Drain I",false));
        
        if(getPowerLevel(p, "forcedrain") >= 1)
        {
        inv.setItem(9,createGuiItem(131,Material.MUSIC_DISC_FAR, "§cForce Drain II",false));
        inv.setItem(0,createGuiItem(131,Material.MUSIC_DISC_FAR, "§cForce Drain III",true));
        }
        
        
        
        if(getPowerLevel(p, "forcedrain") == 2)
        {
        inv.setItem(18,createGuiItem(131,Material.MUSIC_DISC_FAR, "§cForce III",false));
        inv.setItem(9,createGuiItem(131,Material.MUSIC_DISC_FAR, "§cForce II",true));
        inv.setItem(0,createGuiItem(131,Material.MUSIC_DISC_FAR, "§cForce I",true));
        }
        
        if(getPowerLevel(p, "forcedrain") >= 3)
        {
        inv.setItem(18,createGuiItem(131,Material.MUSIC_DISC_FAR, "§cForce Drain III",true));
        inv.setItem(9,createGuiItem(131,Material.MUSIC_DISC_FAR, "§cForce Drain II",true));
        inv.setItem(0,createGuiItem(131,Material.MUSIC_DISC_FAR, "§cForce Drain I",true));
        }
        
        
        
        if(getPowerLevel(p, "forcepush") >= 1)
        inv.setItem(2,createGuiItem(151,Material.MUSIC_DISC_FAR, "§5Force Mindtrick I",false));
        
        if(getPowerLevel(p, "forcemindtrick") >= 1)
        {
        inv.setItem(11,createGuiItem(151,Material.MUSIC_DISC_FAR, "§5Force Mindtrick II",false));
        inv.setItem(2,createGuiItem(151,Material.MUSIC_DISC_FAR, "§5Force Mindtrick I",true));
        }
        
        if(getPowerLevel(p, "forcemindtrick") == 2)
        {
        inv.setItem(20,createGuiItem(151,Material.MUSIC_DISC_FAR, "§5Force Mindtrick III",false));
        inv.setItem(11,createGuiItem(151,Material.MUSIC_DISC_FAR, "§5Force Mindtrick II",true));
        inv.setItem(2,createGuiItem(151,Material.MUSIC_DISC_FAR, "§5Force Mindtrick I",true));
        
        }
        
        if(getPowerLevel(p, "forcemindtrick") >= 3)
        {
        inv.setItem(20,createGuiItem(151,Material.MUSIC_DISC_FAR, "§5Force Mindtrick III",true));
        inv.setItem(11,createGuiItem(151,Material.MUSIC_DISC_FAR, "§5Force Mindtrick II",true));
        inv.setItem(2,createGuiItem(151,Material.MUSIC_DISC_FAR, "§5Force Mindtrick I",true));
        
        }
    
        
  
        if(getPowerLevel(p, "forcepush") >= 1)
        inv.setItem(4,createGuiItem(161,Material.MUSIC_DISC_FAR, "§4Force Lightning I",false));
        
        if(getPowerLevel(p, "forcelightning") == 1)
        {
        inv.setItem(13,createGuiItem(161,Material.MUSIC_DISC_FAR, "§4Force Lightning II",false));
        inv.setItem(4,createGuiItem(161,Material.MUSIC_DISC_FAR, "§4Force Lightning I",true));
        
        }
        if(getPowerLevel(p, "forcelightning") == 2)
        {
        inv.setItem(22,createGuiItem(161,Material.MUSIC_DISC_FAR, "§4Force Storm I",false));
        inv.setItem(13,createGuiItem(161,Material.MUSIC_DISC_FAR, "§4Force Lightning II",true));
        inv.setItem(4,createGuiItem(161,Material.MUSIC_DISC_FAR, "§4Force Lightning I",true));
        
        
        
        }
        
        
        
        
        if(getPowerLevel(p, "forcelightning") == 3)
        {
        	
        inv.setItem(31,createGuiItem(161,Material.MUSIC_DISC_FAR, "§4Force Storm II",false));
        inv.setItem(22,createGuiItem(161,Material.MUSIC_DISC_FAR, "§4Force Storm I",true));
        inv.setItem(13,createGuiItem(161,Material.MUSIC_DISC_FAR, "§4Force Lightning II",true));
        inv.setItem(4,createGuiItem(161,Material.MUSIC_DISC_FAR, "§4Force Lightning I",true));
        
        
        
        }
        
        
        if(getPowerLevel(p, "forcelightning") > 3)
        {
        	
        inv.setItem(31,createGuiItem(161,Material.MUSIC_DISC_FAR, "§4Force Storm II",true));
        inv.setItem(22,createGuiItem(161,Material.MUSIC_DISC_FAR, "§4Force Storm I",true));
        inv.setItem(13,createGuiItem(161,Material.MUSIC_DISC_FAR, "§4Force Lightning II",true));
        inv.setItem(4,createGuiItem(161,Material.MUSIC_DISC_FAR, "§4Force Lightning I",true));
        
        
        
        }
        

        if(getPowerLevel(p, "forcepush") >= 1)
        inv.setItem(6,createGuiItem(171,Material.MUSIC_DISC_FAR, "§1Force Freeze I",false));
        
        
        
        if(getPowerLevel(p, "forcefreeze") >= 1)
        {
        inv.setItem(15,createGuiItem(171,Material.MUSIC_DISC_FAR, "§1Force Freeze II",false));
        inv.setItem(6,createGuiItem(171,Material.MUSIC_DISC_FAR, "§1Force Freeze I",true));
        }
        
        if(getPowerLevel(p, "forcefreeze") >= 2)
        {
        	inv.setItem(24,createGuiItem(111,Material.MUSIC_DISC_FAR, "§1Force Freeze III",false));
            inv.setItem(15,createGuiItem(111,Material.MUSIC_DISC_FAR, "§1Force Freeze II",true));
            inv.setItem(6,createGuiItem(111,Material.MUSIC_DISC_FAR, "§1Force Freeze I",true));
        
        }
        
        if(getPowerLevel(p, "forcefreeze") >= 3)
        {
        	inv.setItem(24,createGuiItem(111,Material.MUSIC_DISC_FAR, "§1Force Freeze III",true));
            inv.setItem(15,createGuiItem(111,Material.MUSIC_DISC_FAR, "§1Force Freeze II",true));
            inv.setItem(6,createGuiItem(111,Material.MUSIC_DISC_FAR, "§1Force Freeze I",true));
        
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
        
        
        //Force Drain
        if(e.getRawSlot() == 0 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcedrain") < 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcedrain", 1);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
        if(e.getRawSlot() == 9 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcedrain") == 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcedrain", 2);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
        
        if(e.getRawSlot() == 18 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcedrain") == 2 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcedrain", 3);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
      
        //Force Mindtrick
        if(e.getRawSlot() == 2 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcemindtrick") < 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcemindtrick", 1);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
        if(e.getRawSlot() == 11 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcemindtrick") == 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcemindtrick", 2);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
        
        if(e.getRawSlot() == 20 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcemindtrick") == 2 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcemindtrick", 3);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        //Force Lightning
        if(e.getRawSlot() == 4 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcelightning") < 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcelightning", 1);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
        if(e.getRawSlot() == 13 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcelightning") == 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcelightning", 2);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
        
        if(e.getRawSlot() == 22 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcelightning") == 2 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcelightning", 3);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        if(e.getRawSlot() == 31 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcelightning") == 3 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcelightning", 4);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded A Force Ability!");
        		
        	}
        	
        }
        
        
        

        
        
        //Force Freeze
        if(e.getRawSlot() == 6 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcefreeze") < 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcefreeze", 1);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded an Ability!");
        		
        	}
        	
        }
        
        
        if(e.getRawSlot() == 15 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcefreeze") == 1 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcefreeze", 2);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded an Ability!");
        		
        	}
        	
        }
        
        
        
        if(e.getRawSlot() == 24 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcefreeze") == 2 && Levels.getSkillpoints(p) >= 1)
        	{
        		setPowerLevel(p, "forcefreeze", 3);
        	
        		Levels.addSkillpoins(p, -1);
        	
        		initializeItems(p);
        		
        		
        		p.sendMessage(ChatColor.BLUE+"You Upgraded an Ability!");
        		
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
