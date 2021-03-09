package dev.stan.plugin;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class Executor extends JavaPlugin implements Listener {

	public static String prefix = ChatColor.DARK_AQUA + "[" + ChatColor.GREEN + "Mention" + ChatColor.DARK_AQUA + "] ";
	public static String noperms = Executor.prefix + ChatColor.RED			+ "You do not have permission to perform this command.";
	public static Boolean update = (Boolean) false;

	// On enable method, execute as soon as plugin is enabled.
	@Override
	public void onEnable() {
		
		// getLogger() instead of sysout on enable
		getLogger().info("Mention Plugin enabled.");

		// Create new instance of Commands class and point to executor
		getCommand("ping").setExecutor(new PingToggleCMD());

		// Create new instance of Events class and point to executor
		getServer().getPluginManager().registerEvents(new ChatEventPing(), this);

	}

}