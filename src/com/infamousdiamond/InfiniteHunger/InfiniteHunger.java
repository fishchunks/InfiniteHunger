package com.infamousdiamond.InfiniteHunger;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class InfiniteHunger extends JavaPlugin{

	//Gets and declares the logger.
	public final Logger logger = Logger.getLogger("Minecraft");
	
	//Allows this class to be referenced as 'plugin'.
	public static InfiniteHunger plugin;
	
	public void onDisable()
	{
		//Happens when the server is turned off/ crashes; Gets the plugin.yml file and tells the console that it's now disabled.
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled.");
	}
	
	public void onEnable()
	{
		//Happens when the server starts up; Gets the plugin.yml file and alerts the console that it's now enabled.
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Enabled." + pdfFile.getVersion());
		//Registered the Player listener class with the Plugin Manager. 
		getServer().getPluginManager().registerEvents(new IHPlayerListener(this), this);	
	}
	
	//When a player does a command.
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		//If the person who did the command is a player.
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			
			//If the command ("/<Command>") is equal to "IH" then it shows the player this.
			if(commandLabel.equalsIgnoreCase("IH") || commandLabel.equalsIgnoreCase("InfiniteHunger"))
			{
				player.sendMessage(ChatColor.DARK_AQUA + "-----------Infinite Hunger-----------");
				player.sendMessage(ChatColor.AQUA + "/IH Info" + ChatColor.WHITE + " Shows Information");
				player.sendMessage(ChatColor.AQUA + "/IH Nodes" + ChatColor.WHITE + " Shows Permission Nodes");
				player.sendMessage(ChatColor.AQUA + "/IH Credits" + ChatColor.WHITE + " Shows Credits");
				player.sendMessage(ChatColor.DARK_AQUA + "-----------------------------------");
				player.sendMessage("");
				
			//If the word after the command is equal to 'I', 'N' or 'C' shows the player each on respectively.
			if(args.length == 1)
			{
				if(args[0].equalsIgnoreCase("I") || args[0].equalsIgnoreCase("Info"))
				{
					player.sendMessage(ChatColor.DARK_AQUA + "-----------Infinite Hunger-----------");
					player.sendMessage(ChatColor.WHITE + "Infinite Hunger provides anyone with the specific permission node to have infinite hunger.");
					player.sendMessage(ChatColor.DARK_AQUA + "-----------------------------------");
					player.sendMessage("");
				}
				else if(args[0].equalsIgnoreCase("N") || args[0].equalsIgnoreCase("Nodes"))
				{
					player.sendMessage(ChatColor.DARK_AQUA + "-----------Infinite Hunger----------");
					player.sendMessage(ChatColor.AQUA + "IH.IH" + ChatColor.WHITE + " Lets the player have infinite hunger");
					player.sendMessage(ChatColor.DARK_AQUA + "-----------------------------------");
					player.sendMessage("");
				}
				else if(args.length == 1 && (args[0].equalsIgnoreCase("C") || args[0].equalsIgnoreCase("Credits")))
				{
					player.sendMessage(ChatColor.DARK_AQUA + "-----------Infinite Hunger-----------");
					player.sendMessage(ChatColor.AQUA + "Head Programmer: " + ChatColor.WHITE + " Fishchunks");
					player.sendMessage(ChatColor.AQUA + "Website: " + ChatColor.WHITE + " www.infamousdiamond.com");
					player.sendMessage(ChatColor.AQUA + "Contact" + ChatColor.WHITE + " Contact me via Dev Bukkit");
					player.sendMessage(ChatColor.AQUA + "Source Code: " + ChatColor.WHITE + " Available upon request, see www.infamousdiamond.com/plugins.html for full conditions");
					player.sendMessage(ChatColor.AQUA + "Donate" + ChatColor.WHITE + " Donate via above site, please put your name in the 'additional information' box.");
					player.sendMessage(ChatColor.DARK_AQUA + "-----------------------------------");
				}
			}
			else
			{
				player.sendMessage(this.playerError("Something went wrong!"));
			}
			//If if does not equal /IH it sends the player a message saying they don't have permission to do the command. (99.9% of the time overridden by Bukkit.)
			}else
			{
				player.sendMessage(this.playerNopermError(""));
			}
			
			
		}
		
		return false;
	}
	//If the player makes an error it sends them this, plus what ever is in the message, used as a base.
	public String playerError(String msg)
	{
		return ChatColor.DARK_AQUA + "[InfiniteHunger] " + ChatColor.RED + msg;
	}
	
	//If the player does not have permission it sends this error.
	public String playerNopermError(String msg)
	{
		return ChatColor.DARK_AQUA + "[InfiniteHunger] " +ChatColor.RED + "You do not have permission to do this command.";
	}
	
	//If the plugin ever needs to send the player a message it prefixes the message with this.
	public String playerMsg(String msg)
	{
		return ChatColor.DARK_AQUA + "[InfiniteHunger] " + ChatColor.WHITE + msg;
	}
	
	
	
}
