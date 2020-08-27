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


public class ItemGUI implements Listener
{

	
	
private final Inventory inv;
	
	private Plugin plugin = Main.getPlugin(Main.class);
	
	public ItemGUI()
	{

		inv = Bukkit.createInventory(null,9,"ForceI");

	}
	
	
	
	public ItemGUI(Plugin plugin, Player p)
	{
		

		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
		
		inv = Bukkit.createInventory(null,54,"ForceI");
		
		initializeItems(p);
		
		
		
	}
	
	
	
    public void initializeItems(Player p) {
    
    	
    	String s = ""+getSkillPoints(p);
    	
    	
        inv.setItem(0,createGuiItem(111,Material.MUSIC_DISC_FAR, "§1Force Push/Pull",false));
        
        if(getPowerLevel(p, "forcedash") >= 1)
        {
        inv.setItem(1,createGuiItem(121,Material.MUSIC_DISC_FAR, "§6Force Dash",false));

        }
        if(getPowerLevel(p, "forcedrain") >= 1)
        {
        inv.setItem(2,createGuiItem(131,Material.MUSIC_DISC_FAR, "§cForce Drain",false));

        }
        if(getPowerLevel(p, "forceheal") >= 1)
        {
        inv.setItem(3,createGuiItem(141,Material.MUSIC_DISC_FAR, "§eForce Heal",false));

        }
        if(getPowerLevel(p, "forcemindtrick") >= 1)
        {
        inv.setItem(4,createGuiItem(151,Material.MUSIC_DISC_FAR, "§5Force Mindtrick",false));

        }
        if(getPowerLevel(p, "forcelightning") >= 1)
        {
        inv.setItem(5,createGuiItem(161,Material.MUSIC_DISC_FAR, "§4Force Lightning",false));

        }
        if(getPowerLevel(p, "forcefreeze") >= 1)
        {
        inv.setItem(6,createGuiItem(171,Material.MUSIC_DISC_FAR, "§bForce Freeze",false));

        }
        if(getPowerLevel(p, "forcerepulse") >= 1)
        {
        inv.setItem(7,createGuiItem(181,Material.MUSIC_DISC_FAR, "§9Force Repulse",false));

        }
        if(getPowerLevel(p, "forcesense") >= 1)
        {
        inv.setItem(8,createGuiItem(191,Material.MUSIC_DISC_FAR, "§1Force Sense",false));

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
        
        
        //Force 
        if(e.getRawSlot() == 0 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcepush") >= 1 && p.getInventory().firstEmpty() != -1)
        	{
        		
        		ItemStack is = new ItemStack(Material.MUSIC_DISC_FAR);
        		ItemMeta im = is.getItemMeta();	
        
        		im.setCustomModelData(111);
    			is.setItemMeta(im);
    			p.getInventory().addItem(is);		
        		
        		
        		p.sendMessage(ChatColor.BLUE+"Your Force Power disc was added to your inventory");
        		
        	}
        	else {
        		p.sendMessage(ChatColor.RED+"Please empty your inventory!");
        	}
        	
        }
        
        
        if(e.getRawSlot() == 1 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcedash") >= 1 && p.getInventory().firstEmpty() != -1)
        	{
        		
        		ItemStack is = new ItemStack(Material.MUSIC_DISC_FAR);
        		ItemMeta im = is.getItemMeta();	
        
        		im.setCustomModelData(121);
    			is.setItemMeta(im);
    			p.getInventory().addItem(is);		
        		
        		
        		p.sendMessage(ChatColor.BLUE+"Your Force Power disc was added to your inventory");
        		
        	}
        	else {
        		p.sendMessage(ChatColor.RED+"Please empty your inventory!");
        	}
        	
        }
        
        if(e.getRawSlot() == 2 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcedrain") >= 1 && p.getInventory().firstEmpty() != -1)
        	{
        		
        		ItemStack is = new ItemStack(Material.MUSIC_DISC_FAR);
        		ItemMeta im = is.getItemMeta();	
        
        		im.setCustomModelData(131);
    			is.setItemMeta(im);
    			p.getInventory().addItem(is);		
        		
        		
        		p.sendMessage(ChatColor.BLUE+"Your Force Power disc was added to your inventory");
        		
        	}
        	else {
        		p.sendMessage(ChatColor.RED+"Please empty your inventory!");
        	}
        	
        }
        
        
        if(e.getRawSlot() == 3 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forceheal") >= 1 && p.getInventory().firstEmpty() != -1)
        	{
        		
        		ItemStack is = new ItemStack(Material.MUSIC_DISC_FAR);
        		ItemMeta im = is.getItemMeta();	
        
        		im.setCustomModelData(141);
    			is.setItemMeta(im);
    			p.getInventory().addItem(is);		
        		
        		
        		p.sendMessage(ChatColor.BLUE+"Your Force Power disc was added to your inventory");
        		
        	}
        	else {
        		p.sendMessage(ChatColor.RED+"Please empty your inventory!");
        	}
        	
        }
        
       
        if(e.getRawSlot() == 4 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcemindtrick") >= 1 && p.getInventory().firstEmpty() != -1)
        	{
        		
        		ItemStack is = new ItemStack(Material.MUSIC_DISC_FAR);
        		ItemMeta im = is.getItemMeta();	
        
        		im.setCustomModelData(151);
    			is.setItemMeta(im);
    			p.getInventory().addItem(is);		
        		
        		
        		p.sendMessage(ChatColor.BLUE+"Your Force Power disc was added to your inventory");
        		
        	}
        	else {
        		p.sendMessage(ChatColor.RED+"Please empty your inventory!");
        	}
        	
        }
        
        if(e.getRawSlot() == 5 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcelightning") >= 1 && p.getInventory().firstEmpty() != -1)
        	{
        		
        		ItemStack is = new ItemStack(Material.MUSIC_DISC_FAR);
        		ItemMeta im = is.getItemMeta();	
        
        		im.setCustomModelData(161);
    			is.setItemMeta(im);
    			p.getInventory().addItem(is);		
        		
        		
        		p.sendMessage(ChatColor.BLUE+"Your Force Power disc was added to your inventory");
        		
        	}
        	else {
        		p.sendMessage(ChatColor.RED+"Please empty your inventory!");
        	}
        	
        }
        
        
        if(e.getRawSlot() == 6 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcefreeze") >= 1 && p.getInventory().firstEmpty() != -1)
        	{
        		
        		ItemStack is = new ItemStack(Material.MUSIC_DISC_FAR);
        		ItemMeta im = is.getItemMeta();	
        
        		im.setCustomModelData(171);
    			is.setItemMeta(im);
    			p.getInventory().addItem(is);		
        		
        		
        		p.sendMessage(ChatColor.BLUE+"Your Force Power disc was added to your inventory");
        		
        	}
        	else {
        		p.sendMessage(ChatColor.RED+"Please empty your inventory!");
        	}
        	
        }
        
        if(e.getRawSlot() == 7 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcerepulse") >= 1 && p.getInventory().firstEmpty() != -1)
        	{
        		
        		ItemStack is = new ItemStack(Material.MUSIC_DISC_FAR);
        		ItemMeta im = is.getItemMeta();	
        
        		im.setCustomModelData(181);
    			is.setItemMeta(im);
    			p.getInventory().addItem(is);		
        		
        		
        		p.sendMessage(ChatColor.BLUE+"Your Force Power disc was added to your inventory");
        		
        	}
        	else {
        		p.sendMessage(ChatColor.RED+"Please empty your inventory!");
        	}
        	
        }
        
        if(e.getRawSlot() == 8 && (e.getInventory().getItem(e.getRawSlot()).getType() != Material.AIR && e.getInventory().getItem(e.getRawSlot()).getType() != null ))
        {
        	
        	if(getPowerLevel(p, "forcesense") >= 1 && p.getInventory().firstEmpty() != -1)
        	{
        		
        		ItemStack is = new ItemStack(Material.MUSIC_DISC_FAR);
        		ItemMeta im = is.getItemMeta();	
        
        		im.setCustomModelData(191);
    			is.setItemMeta(im);
    			p.getInventory().addItem(is);		
        		
        		
        		p.sendMessage(ChatColor.BLUE+"Your Force Power disc was added to your inventory");
        		
        	}
        	else {
        		p.sendMessage(ChatColor.RED+"Please empty your inventory!");
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
