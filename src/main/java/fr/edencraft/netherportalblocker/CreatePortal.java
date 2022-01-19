package fr.edencraft.netherportalblocker;

import fr.edencraft.netherportalblocker.utils.ColoredText;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.inventory.ItemStack;

public class CreatePortal implements Listener {

	@EventHandler
	public void onPortalCreateEvent(PortalCreateEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof Player player) {
			player.sendMessage(new ColoredText(
					"&cLa création de portail du nether est désactivé."
			).treat());
		}
		event.getBlocks().forEach(blockState -> {
			Material material = blockState.getBlock().getBlockData().getMaterial();

			blockState.getBlock().setType(Material.AIR);

			if (material.equals(Material.AIR)) return;
			blockState.getWorld().dropItemNaturally(
					blockState.getLocation(),
					new ItemStack(material)
			);

			blockState.getWorld().playSound(
					blockState.getLocation(),
					Sound.BLOCK_STONE_BREAK,
					1,
					1
			);
		});

		event.setCancelled(true);
	}

}
