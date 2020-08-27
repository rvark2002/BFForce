package com.vark.BFForce;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class getPower implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender cs, Command arg1,
			String arg2, String[] arg3) 
	{
		
		if(cs instanceof Player)
		{
			
			Player p = (Player) cs;
			
			if(p.hasPermission("force.get"))
			{
				
				
				if(arg3.length > 0)
				{
					
					getPower(p,arg3[0]);
					return true;

	
				}
				else
				{
					p.sendMessage(ChatColor.YELLOW+"/getforce [name]");
					return true;
				}
				

				
				
			}
			

		}
		

		
		return false;
	}

	
	
	public void getPower(Player p, String s)
	{
		
		ItemStack is = new ItemStack(Material.MUSIC_DISC_FAR);
		ItemMeta im = is.getItemMeta();
		
		if(s.equals("push"))
		{
			im.setCustomModelData(111);
			is.setItemMeta(im);
			p.getInventory().addItem(is);
		}
		else if(s.equals("dash"))
		{
			im.setCustomModelData(121);
			is.setItemMeta(im);
			p.getInventory().addItem(is);

		}
		else if(s.equals("drain"))
		{
			im.setCustomModelData(131);
			is.setItemMeta(im);
			p.getInventory().addItem(is);
		}
		else if(s.equals("heal"))
		{
			im.setCustomModelData(141);
			is.setItemMeta(im);
			p.getInventory().addItem(is);
		}
		else if(s.equals("mindtrick"))
		{
			im.setCustomModelData(151);
			is.setItemMeta(im);
			p.getInventory().addItem(is);
		}
		else if(s.equals("lightning"))
		{
			im.setCustomModelData(161);
			is.setItemMeta(im);
			p.getInventory().addItem(is);
		}
		else if(s.equals("freeze"))
		{
			im.setCustomModelData(171);
			is.setItemMeta(im);
			p.getInventory().addItem(is);
		}
		else if(s.equals("repulse"))
		{
			im.setCustomModelData(181);
			is.setItemMeta(im);
			p.getInventory().addItem(is);
		}
		else if(s.equals("sense"))
		{
			im.setCustomModelData(191);
			is.setItemMeta(im);
			p.getInventory().addItem(is);
		}
		else if(s.equals("choke"))
		{
			im.setCustomModelData(201);
			is.setItemMeta(im);
			p.getInventory().addItem(is);
		}
		
		else {
			p.sendMessage(ChatColor.RED+"Invalid Force Power!");
		}

		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
