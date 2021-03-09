package dev.stan.plugin.commands;

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
				
				receiver.getInventory().addItem(inHand);
				player.sendMessage(ChatColor.GREEN + "Succesfully gifted an item to " + receiver.getName() + ChatColor.GREEN + "!");
			}
		}
		return false;
	}
}
