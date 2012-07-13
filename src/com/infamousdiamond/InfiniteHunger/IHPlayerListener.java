package com.infamousdiamond.InfiniteHunger;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class IHPlayerListener implements Listener{
	
	private InfiniteHunger plugin;

	public IHPlayerListener(InfiniteHunger plugin)
	{
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.LOW)
	public void onPlayerMove(final PlayerMoveEvent event)
	{
		Player player = event.getPlayer();
		
		if(player.hasPermission("IH.Admin") || player.hasPermission("IH.IH"))
		{
			
			if(event.getPlayer().getFoodLevel() < 15)
			{
				event.getPlayer().setFoodLevel(20);
				
			}
			
		}else if(!player.hasPermission("IH.Admin") || !player.hasPermission("IH.IH"))
		{
		}else{
			player.sendMessage(plugin.playerError("Failed to restore your hunger."));
		}
		
	}

}
