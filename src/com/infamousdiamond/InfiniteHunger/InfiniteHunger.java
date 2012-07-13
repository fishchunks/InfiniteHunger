package com.infamousdiamond.InfiniteHunger;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class InfiniteHunger extends JavaPlugin{

	public final Logger logger = Logger.getLogger("Minecraft");
	public static InfiniteHunger plugin;
	
	public void onDisable()
	{
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled.");
	}
	
	public void onEnable()
	{
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Enabled." + pdfFile.getVersion());
		getServer().getPluginManager().registerEvents(new IHPlayerListener(this), this);	
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			
			
			if(commandLabel.equalsIgnoreCase("IH") || commandLabel.equalsIgnoreCase("InfiniteHunger"))
			{
				player.sendMessage(ChatColor.DARK_AQUA + "-----------Infinite Hunger-----------");
				player.sendMessage(ChatColor.AQUA + "/IH Info" + ChatColor.WHITE + " Shows Information");
				player.sendMessage(ChatColor.AQUA + "/IH Nodes" + ChatColor.WHITE + " Shows Permission Nodes");
				player.sendMessage(ChatColor.AQUA + "/IH Credits" + ChatColor.WHITE + " Shows Credits");
				player.sendMessage(ChatColor.DARK_AQUA + "-----------------------------------");
				player.sendMessage("");
			if(args.length == 1 && (args[0].equalsIgnoreCase("I") || args[0].equalsIgnoreCase("Info")))
			{
				player.sendMessage(ChatColor.DARK_AQUA + "-----------Infinite Hunger-----------");
				player.sendMessage(ChatColor.WHITE + "Infinite Hunger provides anyone with the specific permission node to have infinite hunger.");
				player.sendMessage(ChatColor.DARK_AQUA + "-----------------------------------");
				player.sendMessage("");
			}else if(args.length == 1 && (args[0].equalsIgnoreCase("N") || args[0].equalsIgnoreCase("Nodes")))
			{
				player.sendMessage(ChatColor.DARK_AQUA + "-----------Infinite Hunger----------");
				player.sendMessage(ChatColor.AQUA + "IH.Info" + ChatColor.WHITE + " Lets the player do /IH Info");
				player.sendMessage(ChatColor.AQUA + "IH.Nodes" + ChatColor.WHITE + " Lets the player do /IH Nodes");
				player.sendMessage(ChatColor.AQUA + "IH.Credits" + ChatColor.WHITE + " Lets the player do /IH Credits");
				player.sendMessage(ChatColor.AQUA + "IH.Admin" + ChatColor.WHITE + " Lets the player do everything related to Infinite Hunger");
				player.sendMessage(ChatColor.AQUA + "IH.IH" + ChatColor.WHITE + " Lets the player have infinite hunger");
				player.sendMessage(ChatColor.DARK_AQUA + "-----------------------------------");
				player.sendMessage("");
			}else if(args.length == 1 && (args[0].equalsIgnoreCase("C") || args[0].equalsIgnoreCase("Credits")))
			{
				player.sendMessage(ChatColor.DARK_AQUA + "-----------Infinite Hunger-----------");
				player.sendMessage(ChatColor.AQUA + "Head Programmer: " + ChatColor.WHITE + " Fishchunks");
				player.sendMessage(ChatColor.AQUA + "Website: " + ChatColor.WHITE + " www.infamousdiamond.com");
				player.sendMessage(ChatColor.AQUA + "Contact" + ChatColor.WHITE + " Contact me via Dev Bukkit");
				player.sendMessage(ChatColor.AQUA + "Source Code: " + ChatColor.WHITE + " Available upon request, see www.infamousdiamond.com/plugins.html for full conditions");
				player.sendMessage(ChatColor.AQUA + "Donate" + ChatColor.WHITE + " Donate via above site, please put your name in the 'additional information' box.");
				player.sendMessage(ChatColor.DARK_AQUA + "-----------------------------------");
			}
			}else
			{
				player.sendMessage(this.playerNopermError(""));
			}
			
			
		}
		
		return false;
	}
	
	public String playerError(String msg)
	{
		return ChatColor.DARK_AQUA + "[InfiniteHunger] " + ChatColor.DARK_RED + msg;
	}
	
	public String playerNopermError(String msg)
	{
		return ChatColor.DARK_AQUA + "[InfiniteHunger] " +ChatColor.DARK_RED + "You do not have permission to do this command.";
	}
	
	public String playerMsg(String msg)
	{
		return ChatColor.DARK_AQUA + "[InfiniteHunger] " + ChatColor.RED + "Error: " + ChatColor.WHITE + msg;
	}
	
	
	
}
