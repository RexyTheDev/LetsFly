package me.Rex.LetsFly.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Rex.LetsFly.Main;
import me.Rex.LetsFly.utils.Utils;

public class FlyCommand implements CommandExecutor {

	private Main plugin;

	public FlyCommand(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("fly").setExecutor(this);

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("console_error_message")));
			return true;

		}

		Player p = (Player) sender;

		if (p.hasPermission("letsfly.fly")) {
			if (p.isFlying()) {
				p.setAllowFlight(false);
				p.setFlying(false);
				p.sendMessage(Utils.chat(plugin.getConfig().getString("flying disabled")));
				return true;
			} else {
				p.setAllowFlight(true);
				p.setFlying(true);
				p.sendMessage(Utils.chat(plugin.getConfig().getString("flying enabled")));
			}
		} else {
			p.sendMessage(Utils.chat(plugin.getConfig().getString("no_perm")));
		}

		return false;
	}

}
