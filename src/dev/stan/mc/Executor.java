package dev.stan.mc;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import dev.stan.mc.commands.GiftCMD;
import dev.stan.mc.events.ConfirmListenerEvent;
import dev.stan.mc.events.HelpChatEvent;

public class Executor extends JavaPlugin implements Listener {


	// On enable method, execute as soon as plugin is enabled.
	@Override
	public void onEnable() {
		
		
		// Create and save plugin config
		this.getConfig().options().copyDefaults();
		saveDefaultConfig();

		// Create new instance of Commands class and point to executor
		getCommand("gift").setExecutor(new GiftCMD());

		// Create new instance of Events class and point to executor
		getServer().getPluginManager().registerEvents(new HelpChatEvent(), this);
		getServer().getPluginManager().registerEvents(new ConfirmListenerEvent(), this);

	}

}