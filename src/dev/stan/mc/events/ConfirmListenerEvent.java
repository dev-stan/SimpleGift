package dev.stan.mc.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfirmListenerEvent extends JavaPlugin implements Listener {
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		
		// do stuff here later
	}

}
