package dev.stan.mc.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class GiftCMD implements CommandExecutor {
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("gift")) {
			
			Player player = (Player) sender;
			Player receiver = Bukkit.getPlayer(args[0]);
			
			if (player.hasPermission("gift.use")) {
				
				ItemStack inHand = player.getInventory().getItemInMainHand();
				
				player.sendMessage(ChatColor.RED + "Are you sure you want to gif an item to" + receiver.getName() + "?");
				player.sendMessage(ChatColor.RED + "Type in \"/gift confirm \" to confirm or \"/gift cancel\" to cancel.");
				
				if (args[0].equalsIgnoreCase("confirm")) {
					
					// do stuff
				}
				
				if (args[0].equalsIgnoreCase("cancel")) {
					
					// do stuff
				}
				
				try {
					receiver.getInventory().addItem(inHand);
					player.sendMessage(ChatColor.GREEN + "Succesfully gifted an item to " + receiver.getName() + ChatColor.GREEN + "!");
					receiver.sendMessage(ChatColor.DARK_GREEN + player.getName() + "has given you an item!");
				}
				finally {
					player.sendMessage(ChatColor.DARK_RED + "Something went very wrong, please report this to the server administrator!");
				}
			}
		}
		return false;
	}
}
