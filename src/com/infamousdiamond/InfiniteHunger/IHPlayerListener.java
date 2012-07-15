package com.infamousdiamond.InfiniteHunger;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class IHPlayerListener implements Listener{
	
	//Defines InfiniteHunger.JAVA 'plugin'.
	private InfiniteHunger plugin;

	
	//Hooks in with InfiniteHhunger.JAVA.
	public IHPlayerListener(InfiniteHunger plugin)
	{
		this.plugin = plugin;
	}
	
	
	//With lowest priority, on a player move event knows as 'event'.
	@EventHandler(priority = EventPriority.LOW)
	public void onPlayerMove(final PlayerMoveEvent event)
	{
		Player player = event.getPlayer();
		
		//If the player has the permission 'IH.Admin' or 'IH.IH' it carries on.
		if(player.hasPermission("IH.Admin") || player.hasPermission("IH.IH"))
		{
			//If the player's food level is lower that 15 (7 1/2 Bones).
			if(event.getPlayer().getFoodLevel() < 15)
			{
				//Sets the player's food level to 20 (Full hunger.)
				event.getPlayer().setFoodLevel(20);
				event.getPlayer().setSaturation(20F);
				
			}
			//But if the player does not have permission, just carry on without alerting them.
		}else if(!player.hasPermission("IH.Admin") || !player.hasPermission("IH.IH"))
		{
		}else{
			
			//If the player does have permission and their hunger is lower than 15 but for some reason it can't restore their hunger it sends the player a message.
			player.sendMessage(plugin.playerError("Failed to restore your hunger."));
			this.plugin.logger.severe("Failed to restore the hunger of " + event.getPlayer().getName() + "! Is the plugin up to date?");
		}
		
	}

}
