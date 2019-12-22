package me.Rex.LetsFly;

import org.bukkit.plugin.java.JavaPlugin;

import me.Rex.LetsFly.Commands.FlyCommand;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		new FlyCommand(this);
		
	}

}
