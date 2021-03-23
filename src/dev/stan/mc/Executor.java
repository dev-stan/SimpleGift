package dev.stan.mc;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import dev.stan.mc.commands.GiftCMD;
import dev.stan.mc.events.HelpChatEvent;

public class Executor extends JavaPlugin implements Listener {
	
	public static Core plugin;
	public FileConfiguration config = this.getConfig();
	
	
	// On enable method, execute as soon as plugin is enabled.
	@Override
	public void onEnable() {
		
		plugin = this;
		
		this.getConfig().options().copyDefaults(); // Copy config defaults
		saveDefaultConfig();

		// Create new instance of Commands class and point to executor
		getCommand("gift").setExecutor(new GiftCMD());

		// Create new instance of Events class and point to executor
		getServer().getPluginManager().registerEvents(new HelpChatEvent(), this);
	}
}
