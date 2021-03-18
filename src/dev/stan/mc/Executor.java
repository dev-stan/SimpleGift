package dev.stan.mc;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import dev.stan.mc.commands.GiftCMD;
import dev.stan.mc.events.HelpChatEvent;

public class Executor extends JavaPlugin implements Listener {

	public FileConfiguration config = this.getConfig();
	
	
	// On enable method, execute as soon as plugin is enabled.
	@Override
	public void onEnable() {
		
		// Writing to the config
		config.addDefault("permissions.use", "gift.use");
		config.addDefault("permissions.admin", "gift.admin");
		
		config.addDefault("messages.general.prefix", "&6[&eGIFT&6] ");
		config.addDefault("messages.general.success-message", "&aGift sent succesfully!");
		
		config.addDefault("messages.error.no-permission-message", "&4You do not have permission to perform this command!");
		config.addDefault("messages.error.inventory-full-message", "&4Player inventory is full!");
		
		
		this.getConfig().options().copyDefaults(); // Copy config defaults
		saveDefaultConfig();

		// Create new instance of Commands class and point to executor
		getCommand("gift").setExecutor(new GiftCMD());

		// Create new instance of Events class and point to executor
		getServer().getPluginManager().registerEvents(new HelpChatEvent(), this);
	}
}