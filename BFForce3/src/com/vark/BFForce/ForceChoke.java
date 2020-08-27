package com.vark.BFForce;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class ForceChoke implements Listener {

	public ForceChoke(Main plugin) {

		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void forceChoke(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (player.hasPotionEffect(PotionEffectType.SLOW_DIGGING))
			return;

		// Force
		// Choke===========================================================================================
		if (player.hasPermission("force.choke")) {

			if ((player.getInventory().getItemInMainHand()
					.getType() == Material.MUSIC_DISC_FAR)) {

				if (player.getInventory().getItemInMainHand().getItemMeta()
						.hasCustomModelData()) {

					if (player.getInventory().getItemInMainHand().getItemMeta()
							.getCustomModelData() == 201) {

						if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
							// if (CM.checkCdc(player)) {

							for (Entity ent : getEntitys(player, 7)) {

								if (ent instanceof LivingEntity) {

									double y = 0;
									if (ent.getLocation().getY()
											- player.getLocation().getY() > 2) {
										y = player.getLocation().getY();
									} else {
										y = player.getLocation().getY() + 2;
									}

									Location loc = new Location(ent.getWorld(),
											ent.getLocation().getX(), y,
											ent.getLocation().getZ());

									ent.teleport(loc);
									ent.teleport(faceLocation(ent,
											player.getEyeLocation()));

									/*((LivingEntity) ent)
											.addPotionEffect(new PotionEffect(
													PotionEffectType.SLOW_FALLING,
													120, 120));
													*/
									// ent.setGravity(false);
									if (!(ent.isDead()))
										((Damageable) ent).damage(1);

								}
								player.sendMessage(
										ChatColor.RED + "Force Choke");
								
								
								

								// CM.setCdc(player, 30);

							}
							// }

							// else {
							// player.sendMessage(
							// "You cannot use this for another "
							// + CM.getCdc(player) + " seconds!");
							// }

						}

					}

				}

			}

		}

	}

	private boolean getLookingAt(Player player, LivingEntity livingEntity) {
		Location eye = player.getEyeLocation();
		Vector toEntity = livingEntity.getEyeLocation().toVector()
				.subtract(eye.toVector());
		double dot = toEntity.normalize().dot(eye.getDirection());

		return dot > 0.99D;
	}

	private List<Entity> getEntitys(Player player, int range) {
		List<Entity> entitys = new ArrayList<Entity>();
		for (Entity e : player.getNearbyEntities(range, range, range)) {
			if (e instanceof LivingEntity) {
				if (getLookingAt(player, (LivingEntity) e)) {
					entitys.add(e);
				}
			}
		}

		return entitys;
	}

	public static Location faceLocation(Entity entity, Location to) {
		if (entity.getWorld() != to.getWorld()) {
			return null;
		}
		Location fromLocation = entity.getLocation();

		double xDiff = to.getX() - fromLocation.getX();
		double yDiff = to.getY() - fromLocation.getY();
		double zDiff = to.getZ() - fromLocation.getZ();

		double distanceXZ = Math.sqrt(xDiff * xDiff + zDiff * zDiff);
		double distanceY = Math.sqrt(distanceXZ * distanceXZ + yDiff * yDiff);

		double yaw = Math.toDegrees(Math.acos(xDiff / distanceXZ));
		double pitch = Math.toDegrees(Math.acos(yDiff / distanceY)) - 90.0D;
		if (zDiff < 0.0D) {
			yaw += Math.abs(180.0D - yaw) * 2.0D;
		}
		Location loc = entity.getLocation();
		loc.setYaw((float) (yaw - 90.0F));
		loc.setPitch((float) (pitch - 90.0F));
		return loc;
	}

}
