package dev.stan.mc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class HelpChatEvent extends JavaPlugin implements Listener{

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		
		Player player = event.getPlayer();
		
		if (event.getMessage().contains("how to gift")) {
			
			player.sendMessage(ChatColor.GOLD + "Use the /gift command in order to give an item to a player.");
		}
		
		
	}
}
