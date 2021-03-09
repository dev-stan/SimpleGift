package dev.stan.plugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class HelpChatEvent extends JavaPlugin implements Listener{
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		
		Player player = event.getPlayer();	
		
		if (event.getMessage().contains("how") || event.getMessage().contains("gift")) {
			player.sendMessage("{stuff}");
		}
	}
}
