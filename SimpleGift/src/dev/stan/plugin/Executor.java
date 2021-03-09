package dev.stan.plugin;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import dev.stan.plugin.commands.GiftCMD;


public class Executor extends JavaPlugin implements Listener {


	// On enable method, execute as soon as plugin is enabled.
	@Override
	public void onEnable() {
		
		// getLogger() instead of sysout on enable
		getLogger().info("SimpleGift Plugin enabled.");

		// Create new instance of Commands class and point to executor
		getCommand("ping").setExecutor(new GiftCMD());

		// Create new instance of Events class and point to executor
		// getServer().getPluginManager().registerEvents(new ChatEventPing(), this);

	}

}