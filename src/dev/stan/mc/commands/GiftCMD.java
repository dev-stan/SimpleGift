package dev.stan.mc.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class GiftCMD implements CommandExecutor {
	
	public HashMap<String, Long> cooldowns = new HashMap<String, Long>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("gift")) {
			
			Player player = (Player) sender;
			
			if (player.hasPermission("gift.use")) {
				
				ItemStack inHand = player.getInventory().getItemInMainHand();
				Player receiver = Bukkit.getPlayer(args[0]);
				
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
