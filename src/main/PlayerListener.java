package main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerListener implements Listener
{
	public PlayerListener(PluginMain plugin)
	{
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onConsume(PlayerItemConsumeEvent event)
	{
		// Granting invisibility for player when a GOLDEN APPLE is consumed
		Player player = event.getPlayer();
		if(player.getItemInHand().getType() == Material.GOLDEN_APPLE)
		{
			event.getPlayer().sendMessage(ChatColor.BLUE + "You are now invisible!");
			player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100, 1));
			player.removePotionEffect(PotionEffectType.ABSORPTION);
			player.removePotionEffect(PotionEffectType.REGENERATION);
		}
	}

	@EventHandler
	public void onLogin(PlayerJoinEvent event)
	{
		// Welcome message to players who join the server.
		Player player = event.getPlayer();
		event.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "Welcome " + ChatColor.DARK_AQUA + player.getName() + ChatColor.LIGHT_PURPLE +  "!");
	}

}

