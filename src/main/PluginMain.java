package main;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginMain extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		new PlayerListener(this);
		System.out.println("\n \n \n Successful \n \n");

	}

	@Override
	public void onDisable()
	{

	}
	
	public boolean onCommand(CommandSender theSender, Command cmd, String commandLabel, String [] args)
	{
		Player player = (Player) theSender;
		if(commandLabel.equalsIgnoreCase("apple"))
		{
			player.getInventory().clear();
			ItemStack apple = new ItemStack(Material.GOLDEN_APPLE,1);
			PlayerInventory inv = player.getInventory();
			inv.setItem(8, apple);
		}
		return false;
	}
}
