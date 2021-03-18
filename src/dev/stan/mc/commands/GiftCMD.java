package dev.stan.mc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class GiftCMD implements CommandExecutor {
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("gift")) {
			
			Player player = (Player) sender;
			Player receiver = Bukkit.getPlayer(args[0]);
			
			if (player.hasPermission("gift.use")) { // Reminder to implement custom config permission nodes
				
				ItemStack inHand = player.getInventory().getItemInMainHand();
				
				
				player.sendMessage(ChatColor.RED + "Are you sure you want to gif an item to" + receiver.getName() + "?");
				player.sendMessage(ChatColor.RED + "Type in \"/gift confirm \" to confirm or \"/gift cancel\" to cancel.");
				
				
				if (args[0].equalsIgnoreCase("confirm")) {
					
					if (hasAvaliableSlot(receiver)) {
						
						receiver.getInventory().addItem(inHand);
					} else {
						
						player.sendMessage(receiver.getName() + ChatColor.DARK_RED + " has a full inventory, the operation has been stopped.");
						receiver.sendMessage(player.getName() + ChatColor.DARK_RED + " has just sent you a gift but your inventory was full, the operation has been stopped.");
					}
				}
				
				if (args[0].equalsIgnoreCase("cancel")) {
					
					player.sendMessage(ChatColor.DARK_RED + "You've cancelled your gift to " + ChatColor.DARK_GREEN + receiver.getName() + ChatColor.DARK_RED + "!");
				}
			}
		}
		return false;
	}
	
	public boolean hasAvaliableSlot(Player player){
		
		Inventory inv = player.getInventory();
		Boolean check=false;
		for (ItemStack item: inv.getContents()) {
			if(item == null) {
				check = true;
				break;
			}
		}
		return check;
	}
}
