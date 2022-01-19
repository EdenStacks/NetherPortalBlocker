package fr.edencraft.netherportalblocker;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class NetherPortalBlocker extends JavaPlugin{

	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new CreatePortal(), this);
	}

	@Override
	public void onDisable() {

	}
}
