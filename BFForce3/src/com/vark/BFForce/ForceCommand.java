package com.vark.BFForce;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;



public class ForceCommand implements CommandExecutor
{
	
	private Plugin plugin = Main.getPlugin(Main.class);
	

	@Override
	public boolean onCommand(CommandSender cs, Command arg1,
			 String arg2, String[] arg3) {
		
		
		
			if(cs instanceof Player)
			{
				Player p = (Player) cs;
				Inventory i = new ForceGUI(plugin,p).getInv();
				p.openInventory(i);
				
				return true;
				
			}
		
		
			return false;
		
		
		

	}

}
