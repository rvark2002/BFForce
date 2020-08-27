
package com.vark.BFForce;

import java.io.File;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

/**
 *
 * @Coding Legend Ritvik Varkhedkar
 */
public class PlayerListener implements Listener 
{
	private Plugin plugin = Main.getPlugin(Main.class);

	public PlayerListener(Main plugin) {

		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	
	

	@EventHandler
	public void onPlayerInteractBlock(PlayerInteractEvent event) 
	{
		if (event.getAction().equals(Action.LEFT_CLICK_AIR)
				|| event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			return;
		}
		Player player = event.getPlayer();
	
		if(canUseForce(player))
		{

		// Force Lightning
		// ======================================================================================
		if (getPowerLevel(player, "forcelightning") >= 1) {

			if ((player.getInventory().getItemInMainHand()
					.getType() == Material.MUSIC_DISC_FAR)
					&& (!player.isSneaking())) {

				if (player.getInventory().getItemInMainHand().getItemMeta()
						.hasCustomModelData()) {

					if (player.getInventory().getItemInMainHand().getItemMeta()
							.getCustomModelData() == 161) {

						if (CM.checkCooldown(player)) {
							int tier = 15;
							int cd = 20;
							if (getPowerLevel(player, "forcelightning") == 2) {
								tier = 45;
								cd = 10;
							}
							if (getPowerLevel(player, "forcelightning") >= 3) {
								tier = 60;
								cd = 5;
							}
							
							
							
							
							for (int i = 0; i < 5; i++) {
								player.getWorld()
										.strikeLightning(player
												.getTargetBlock(null, tier)
												.getLocation());
							}
							player.sendMessage(
									ChatColor.RED + "Force Lightning");
							CM.setCooldown(player, cd);
						} else {
							player.sendMessage(ChatColor.DARK_RED
									+ "You cannot use this for another "
									+ CM.getCooldown(player) + " seconds!");
						}
					}
				}
			}

			
			
		}
			
			
			
			
			if (getPowerLevel(player, "forcelightning") >= 1) 
			{

				if ((player.getInventory().getItemInOffHand()
						.getType() == Material.MUSIC_DISC_FAR)
						&& (!player.isSneaking())) {

					if (player.getInventory().getItemInOffHand().getItemMeta()
							.hasCustomModelData()) {

						if (player.getInventory().getItemInOffHand().getItemMeta()
								.getCustomModelData() == 161) {

							if (CM.checkCooldown(player)) {
								int tier = 15;
								int cd = 20;
								if (getPowerLevel(player, "forcelightning") == 2) {
									tier = 45;
									cd = 10;
								}
								if (getPowerLevel(player, "forcelightning") >= 3) {
									tier = 60;
									cd = 5;
								}
								
								
								
								
								for (int i = 0; i < 5; i++) {
									player.getWorld()
											.strikeLightning(player
													.getTargetBlock(null, tier)
													.getLocation());
								}
								player.sendMessage(
										ChatColor.RED + "Force Lightning");
								CM.setCooldown(player, cd);
							} else {
								player.sendMessage(ChatColor.DARK_RED
										+ "You cannot use this for another "
										+ CM.getCooldown(player) + " seconds!");
							}
						}
					}
				}
	
		}
			
			
			
			
			

		// Force Storm======================================================
		if (((player.getInventory().getItemInMainHand()
				.getType() == Material.MUSIC_DISC_FAR))
				&& (player.isSneaking())) {
			if (getPowerLevel(player, "forcelightning")>=3) {

				if (player.getInventory().getItemInMainHand().getItemMeta()
						.hasCustomModelData()) {

					if (player.getInventory().getItemInMainHand().getItemMeta()
							.getCustomModelData() == 161) {

						if (CM.checkCds(player)) {

							int tier = 10;
							int cd = 45;
							
							if(getPowerLevel(player, "forcelightning") == 4)
							{
								tier = 20;
								cd = 25;
							}
							
							
							
							for (Entity e : player.getNearbyEntities(tier, tier,
									tier)) {
								if (e instanceof LivingEntity) {
									Location l = e.getLocation();
									player.getWorld().strikeLightning(l);
								}
								player.sendMessage(
										ChatColor.DARK_RED + "Force Storm");
								CM.setCds(player, cd);
							}

						} else {
							player.sendMessage(ChatColor.DARK_RED
									+ "You cannot use this for another "
									+ CM.getCds(player) + " seconds!");
						}
					}
				}

			}

		}

		
		
		
		
		if (((player.getInventory().getItemInOffHand()
				.getType() == Material.MUSIC_DISC_FAR))
				&& (player.isSneaking())) {
			if (getPowerLevel(player, "forcelightning")>=3) {

				if (player.getInventory().getItemInOffHand().getItemMeta()
						.hasCustomModelData()) {

					if (player.getInventory().getItemInOffHand().getItemMeta()
							.getCustomModelData() == 161) {

						if (CM.checkCds(player)) {

							int tier = 10;
							int cd = 45;
							
							if(getPowerLevel(player, "forcelightning") == 4)
							{
								tier = 20;
								cd = 25;
							}
							
							
							
							for (Entity e : player.getNearbyEntities(tier, tier,
									tier)) {
								if (e instanceof LivingEntity) {
									Location l = e.getLocation();
									player.getWorld().strikeLightning(l);
								}
								player.sendMessage(
										ChatColor.DARK_RED + "Force Storm");
								CM.setCds(player, cd);
							}

						} else {
							player.sendMessage(ChatColor.DARK_RED
									+ "You cannot use this for another "
									+ CM.getCds(player) + " seconds!");
						}
					}
				}

			}

		}
		
		
		
		
		
		
		}
		
		
		
		
		
		
		

	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (p.hasPotionEffect(PotionEffectType.SLOW)) {
			return;
		}
		
		if(!(canUseForce(p)))
		{
			return;
		}
		
		if (getPowerLevel(p, "forcejump") >= 1) {
			if ((p.getGameMode() != GameMode.CREATIVE && p.getLocation()
					.subtract(0, 1, 0).getBlock().getType() != Material.AIR
					&& !p.isFlying() && p.getGameMode() != GameMode.ADVENTURE)) {

				p.setAllowFlight(true);
			}
		}
	}
	

	@EventHandler
	public void onPlayerFly(PlayerToggleFlightEvent e) {
		Player p = e.getPlayer();
		if (p.getGameMode() == GameMode.CREATIVE) {
			return;
		}

		e.setCancelled(true);
		p.setAllowFlight(false);
		p.setFlying(false);
		p.setVelocity(p.getLocation().getDirection().multiply(1.5).setY(1));

	}

	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e) {

		if (e.getEntity() instanceof Player) {
			if (e.getCause() == DamageCause.FALL) {
				Player p = (Player) e.getEntity();
				if (getPowerLevel(p, "forcejump") >= 1 && (!(p.getWorld().getName().equals("minigame")))) {
					e.setCancelled(true);
				}
			}

		}

	}

	@EventHandler
	public void forcePull(PlayerInteractEvent event) {

		if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {

			Player p = event.getPlayer();
			if (!(canUseForce(p)))
				return;
			
			if ((p.getInventory().getItemInMainHand()
					.getType() == Material.MUSIC_DISC_FAR)) {

				if (p.getInventory().getItemInMainHand().getItemMeta()
						.hasCustomModelData()) {

					if (p.getInventory().getItemInMainHand().getItemMeta()
							.getCustomModelData() == 111) {

						if (getPowerLevel(p, "forcepush") >= 1) {

							if (p.isSneaking()) {
								
								int strength = -4;
								int cd = 4;
								int range = 12;
								
								if (getPowerLevel(p, "forcepush") == 2) {
									
									strength = -6;
									cd = 3;
									range = 20;
									
								}
								
								if (getPowerLevel(p, "forcepush") == 3) {
									
									strength = -8;
									cd = 2;
									range = 30;
									
								}
								
								
								for (Entity e : getEntitys(p, range)) {
									if (CM.checkCdp(p)) {

										((LivingEntity) e).setVelocity(
												p.getLocation().getDirection()
														.multiply(strength));

										p.sendMessage(ChatColor.GREEN
												+ "Used Force Pulled A "
												+ e.getType());
										CM.setCdp(p, cd);
									} else
										p.sendMessage(ChatColor.GREEN
												+ "You cannot use the Force for another "
												+ CM.getCdp(p) + " seconds!");
								}
							}
						}

					}

				}
			}


			
			
			
			if ((p.getInventory().getItemInOffHand()
					.getType() == Material.MUSIC_DISC_FAR)) {

				if (p.getInventory().getItemInOffHand().getItemMeta()
						.hasCustomModelData()) {

					if (p.getInventory().getItemInOffHand().getItemMeta()
							.getCustomModelData() == 111) {

						if (getPowerLevel(p, "forcepush") >= 1) {

							if (p.isSneaking()) {
								
								int strength = -4;
								int cd = 4;
								int range = 12;
								
								if (getPowerLevel(p, "forcepush") == 2) {
									
									strength = -6;
									cd = 3;
									range = 20;
									
								}
								
								if (getPowerLevel(p, "forcepush") == 3) {
									
									strength = -8;
									cd = 2;
									range = 30;
									
								}
								
								
								for (Entity e : getEntitys(p, range)) {
									if (CM.checkCdp(p)) {

										((LivingEntity) e).setVelocity(
												p.getLocation().getDirection()
														.multiply(strength));

										p.sendMessage(ChatColor.GREEN
												+ "Used Force Pulled A "
												+ e.getType());
										CM.setCdp(p, cd);
									} else
										p.sendMessage(ChatColor.GREEN
												+ "You cannot use the Force for another "
												+ CM.getCdp(p) + " seconds!");
								}
							}
						}

					}

				}
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

		}

	}

	@EventHandler
	public void forcePush(PlayerInteractEvent event) {

		
		
		

		if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {

			Player p = event.getPlayer();
			if (!(canUseForce(p)))
				return;
			
			if ((p.getInventory().getItemInMainHand()
					.getType() == Material.MUSIC_DISC_FAR)) {

				if (p.getInventory().getItemInMainHand().getItemMeta()
						.hasCustomModelData()) {

					if (p.getInventory().getItemInMainHand().getItemMeta()
							.getCustomModelData() == 111) {

						if (getPowerLevel(p, "forcepush") >= 1) {

							if (!(p.isSneaking())) {
								
								int strength = 4;
								int cd = 4;
								int range = 12;
								
								if (getPowerLevel(p, "forcepush") == 2) {
									
									strength = 6;
									cd = 3;
									range = 20;
									
								}
								
								if (getPowerLevel(p, "forcepush") == 3) {
									
									strength = 8;
									cd = 2;
									range = 30;
									
								}
								
								
								for (Entity e : getEntitys(p, range)) {
									if (CM.checkCdp(p)) {

										((LivingEntity) e).setVelocity(
												p.getLocation().getDirection()
														.multiply(strength));

										p.sendMessage(ChatColor.GREEN
												+ "Used Force Pushed A "
												+ e.getType());
										CM.setCdp(p, cd);
									} else
										p.sendMessage(ChatColor.GREEN
												+ "You cannot use the Force for another "
												+ CM.getCdp(p) + " seconds!");
								}
							}
						}

					}

				}
			}


			
			
			
			if ((p.getInventory().getItemInOffHand()
					.getType() == Material.MUSIC_DISC_FAR)) {

				if (p.getInventory().getItemInOffHand().getItemMeta()
						.hasCustomModelData()) {

					if (p.getInventory().getItemInOffHand().getItemMeta()
							.getCustomModelData() == 111) {

						if (getPowerLevel(p, "forcepush") >= 1) {

							if (p.isSneaking()) {
								
								int strength = 4;
								int cd = 4;
								int range = 12;
								
								if (getPowerLevel(p, "forcepush") == 2) {
									
									strength = 6;
									cd = 3;
									range = 20;
									
								}
								
								if (getPowerLevel(p, "forcepush") == 3) {
									
									strength = 8;
									cd = 2;
									range = 30;
									
								}
								
								
								for (Entity e : getEntitys(p, range)) {
									if (CM.checkCdp(p)) {

										((LivingEntity) e).setVelocity(
												p.getLocation().getDirection()
														.multiply(strength));

										p.sendMessage(ChatColor.GREEN
												+ "Used Force Pushed A "
												+ e.getType());
										CM.setCdp(p, cd);
									} else
										p.sendMessage(ChatColor.GREEN
												+ "You cannot use the Force for another "
												+ CM.getCdp(p) + " seconds!");
								}
							}
						}

					}

				}
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

	@EventHandler
	public void forceDrain(PlayerInteractEvent event) {

		if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {

			Player player = event.getPlayer();
			if (!(canUseForce(player)))
				return;
			
			
			if (getPowerLevel(player,"forcedrain") >= 1) {

				if ((player.getInventory().getItemInMainHand()
						.getType() == Material.MUSIC_DISC_FAR)) {
					if (player.getInventory().getItemInMainHand().getItemMeta()
							.hasCustomModelData()) {

						if (player.getInventory().getItemInMainHand()
								.getItemMeta().getCustomModelData() == 131) {

							for (Entity ent : getEntitys(player, 7)) {

								if (ent instanceof LivingEntity) {
									double eh = 7.0;

									LivingEntity e = (LivingEntity) ent;

									int tier = 1;
									if (getPowerLevel(player, "forcedrain") == 2) {
										tier = 2;
									}
									
									if (getPowerLevel(player, "forcedrain") == 3) {
										tier = 3;
									}

									if (CM.checkCddr(player)) {
										player.sendMessage(
												ChatColor.RED + "Force Drain");
										e.sendMessage(ChatColor.RED
												+ "Force Drained by "
												+ player.getName());

										if (tier == 2) {
											eh = 14.0;
										}
										if (tier == 3) {
											eh = 17.0;
										}

										if (ent instanceof Player) {
											eh /= 2.0;
										}

										e.damage(eh);
										// ent.getWorld().spawnParticle(Particle.REDSTONE,
										// ent.getLocation(),100,1.2,1.2,1.2,1,new
										// Particle.DustOptions(Color.RED, 5));
										ent.getWorld().spawnParticle(
												Particle.CLOUD,
												ent.getLocation(), 20, 1, 1, 1,
												1);
										ent.getWorld().spawnParticle(
												Particle.CLOUD,
												player.getLocation(), 20, 1, 1,
												1, 1);

										double ph = player.getHealth() + eh;
										if (ph > 20.0) {
											player.setHealth(20.0);
										} else {
											player.setHealth(ph);

										}

										if (tier == 1) {
											CM.setCddr(player, 30);
										}

										if (tier == 2) {
											CM.setCddr(player, 20);
										}
										
										if (tier == 3) {
											CM.setCddr(player, 10);
										}

									} else {
										player.sendMessage(ChatColor.RED
												+ "You cannot use this for another "
												+ CM.getCddr(player)
												+ " seconds!");
									}
								}
							}
						}

					}

				}


				
				
				if ((player.getInventory().getItemInOffHand()
						.getType() == Material.MUSIC_DISC_FAR)) {
					if (player.getInventory().getItemInOffHand().getItemMeta()
							.hasCustomModelData()) {

						if (player.getInventory().getItemInOffHand()
								.getItemMeta().getCustomModelData() == 131) {

							for (Entity ent : getEntitys(player, 7)) {

								if (ent instanceof LivingEntity) {
									double eh = 7.0;

									LivingEntity e = (LivingEntity) ent;

									int tier = 1;
									if (getPowerLevel(player, "forcedrain") == 2) {
										tier = 2;
									}
									
									if (getPowerLevel(player, "forcedrain") == 3) {
										tier = 3;
									}

									if (CM.checkCddr(player)) {
										player.sendMessage(
												ChatColor.RED + "Force Drain");
										e.sendMessage(ChatColor.RED
												+ "Force Drained by "
												+ player.getName());

										if (tier == 2) {
											eh = 14.0;
										}
										if (tier == 3) {
											eh = 17.0;
										}

										if (ent instanceof Player) {
											eh /= 2.0;
										}

										e.damage(eh);
										// ent.getWorld().spawnParticle(Particle.REDSTONE,
										// ent.getLocation(),100,1.2,1.2,1.2,1,new
										// Particle.DustOptions(Color.RED, 5));
										ent.getWorld().spawnParticle(
												Particle.CLOUD,
												ent.getLocation(), 20, 1, 1, 1,
												1);
										ent.getWorld().spawnParticle(
												Particle.CLOUD,
												player.getLocation(), 20, 1, 1,
												1, 1);

										double ph = player.getHealth() + eh;
										if (ph > 20.0) {
											player.setHealth(20.0);
										} else {
											player.setHealth(ph);

										}

										if (tier == 1) {
											CM.setCddr(player, 30);
										}

										if (tier == 2) {
											CM.setCddr(player, 20);
										}
										
										if (tier == 3) {
											CM.setCddr(player, 10);
										}

									} else {
										player.sendMessage(ChatColor.RED
												+ "You cannot use this for another "
												+ CM.getCddr(player)
												+ " seconds!");
									}
								}
							}
						}

					}

				}
				
				
				
				
				

			}

		}

	}

	@EventHandler
	public void forceMindTrick(PlayerInteractEvent event) {
		if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
			Player player = event.getPlayer();
			
			if(!(canUseForce(player)))
				return;
			// Force
			// Mindtrick===========================================================================================
				if (getPowerLevel(player, "forcemindtrick") >= 1) {

				if ((player.getInventory().getItemInMainHand()
						.getType() == Material.MUSIC_DISC_FAR)) {

					if (player.getInventory().getItemInMainHand().getItemMeta()
							.hasCustomModelData()) {

						if (player.getInventory().getItemInMainHand()
								.getItemMeta().getCustomModelData() == 151) {

							for (Entity ent : getEntitys(player, 10))

								if (ent.getType() == EntityType.PLAYER) {
									Player e = (Player) ent;
									if (CM.checkCdm(player)) {
										int tier = 1;
										if (getPowerLevel(player, "forcemindtrick") == 2) {
											tier = 2;
										}
										if (getPowerLevel(player, "forcemindtrick") == 3) {
											tier = 3;
										}

										player.sendMessage(
												ChatColor.LIGHT_PURPLE
														+ "Force Mind Trick");
										if (tier == 1) {
											e.addPotionEffect(new PotionEffect(
													PotionEffectType.BLINDNESS,
													100, 50));
											e.addPotionEffect(new PotionEffect(
													PotionEffectType.CONFUSION,
													100, 50));
											e.getWorld().spawnParticle(
													Particle.REDSTONE,
													ent.getLocation(), 100, 1.2,
													1.2, 1.2, 1,
													new Particle.DustOptions(
															Color.PURPLE, 5));
											e.sendMessage(ChatColor.LIGHT_PURPLE
													+ player.getName()
													+ " used a Mind Trick on You!");
											CM.setCdm(player, 30);
										}

										if (tier == 2) {
											e.addPotionEffect(new PotionEffect(
													PotionEffectType.BLINDNESS,
													160, 100));
											e.addPotionEffect(new PotionEffect(
													PotionEffectType.CONFUSION,
													160, 50));
											e.sendMessage(ChatColor.LIGHT_PURPLE
													+ player.getName()
													+ " used a Mind Trick on You!");
											e.getWorld().spawnParticle(
													Particle.REDSTONE,
													ent.getLocation(), 100, 1.2,
													1.2, 1.2, 1,
													new Particle.DustOptions(
															Color.PURPLE, 5));
											CM.setCdm(player, 25);
										}
										
										
										if (tier == 3) {
											e.addPotionEffect(new PotionEffect(
													PotionEffectType.BLINDNESS,
													220, 100));
											e.addPotionEffect(new PotionEffect(
													PotionEffectType.CONFUSION,
													220, 50));
											e.sendMessage(ChatColor.LIGHT_PURPLE
													+ player.getName()
													+ " used a Mind Trick on You!");
											e.getWorld().spawnParticle(
													Particle.REDSTONE,
													ent.getLocation(), 100, 1.2,
													1.2, 1.2, 1,
													new Particle.DustOptions(
															Color.PURPLE, 5));
											CM.setCdm(player, 20);
										}
										

									} else {
										player.sendMessage(
												ChatColor.LIGHT_PURPLE
														+ "You cannot use this for another "
														+ CM.getCdm(player)
														+ " seconds!");
									}
								}
						}
					}

				}


				
				
				if ((player.getInventory().getItemInOffHand()
						.getType() == Material.MUSIC_DISC_FAR)) {

					if (player.getInventory().getItemInOffHand().getItemMeta()
							.hasCustomModelData()) {

						if (player.getInventory().getItemInOffHand()
								.getItemMeta().getCustomModelData() == 151) {

							for (Entity ent : getEntitys(player, 10))

								if (ent.getType() == EntityType.PLAYER) {
									Player e = (Player) ent;
									if (CM.checkCdm(player)) {
										int tier = 1;
										if (getPowerLevel(player, "forcemindtrick") == 2) {
											tier = 2;
										}
										if (getPowerLevel(player, "forcemindtrick") == 3) {
											tier = 3;
										}

										player.sendMessage(
												ChatColor.LIGHT_PURPLE
														+ "Force Mind Trick");
										if (tier == 1) {
											e.addPotionEffect(new PotionEffect(
													PotionEffectType.BLINDNESS,
													100, 50));
											e.addPotionEffect(new PotionEffect(
													PotionEffectType.CONFUSION,
													100, 50));
											e.getWorld().spawnParticle(
													Particle.REDSTONE,
													ent.getLocation(), 100, 1.2,
													1.2, 1.2, 1,
													new Particle.DustOptions(
															Color.PURPLE, 5));
											e.sendMessage(ChatColor.LIGHT_PURPLE
													+ player.getName()
													+ " used a Mind Trick on You!");
											CM.setCdm(player, 30);
										}

										if (tier == 2) {
											e.addPotionEffect(new PotionEffect(
													PotionEffectType.BLINDNESS,
													160, 100));
											e.addPotionEffect(new PotionEffect(
													PotionEffectType.CONFUSION,
													160, 50));
											e.sendMessage(ChatColor.LIGHT_PURPLE
													+ player.getName()
													+ " used a Mind Trick on You!");
											e.getWorld().spawnParticle(
													Particle.REDSTONE,
													ent.getLocation(), 100, 1.2,
													1.2, 1.2, 1,
													new Particle.DustOptions(
															Color.PURPLE, 5));
											CM.setCdm(player, 25);
										}
										
										
										if (tier == 3) {
											e.addPotionEffect(new PotionEffect(
													PotionEffectType.BLINDNESS,
													220, 100));
											e.addPotionEffect(new PotionEffect(
													PotionEffectType.CONFUSION,
													220, 50));
											e.sendMessage(ChatColor.LIGHT_PURPLE
													+ player.getName()
													+ " used a Mind Trick on You!");
											e.getWorld().spawnParticle(
													Particle.REDSTONE,
													ent.getLocation(), 100, 1.2,
													1.2, 1.2, 1,
													new Particle.DustOptions(
															Color.PURPLE, 5));
											CM.setCdm(player, 20);
										}
										

									} else {
										player.sendMessage(
												ChatColor.LIGHT_PURPLE
														+ "You cannot use this for another "
														+ CM.getCdm(player)
														+ " seconds!");
									}
								}
						}
					}

				}

				
				


			}

		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@EventHandler
	public void forceFreeze(PlayerInteractEvent event) {
		if ((event.getAction().equals(Action.RIGHT_CLICK_AIR))) {
			// Force
			// Freeze======================================================================

			Player player = event.getPlayer();
			if (!(canUseForce(player)))
				return;
			
			
			if (getPowerLevel(player, "forcefreeze") >= 1) {

				if ((player.getInventory().getItemInMainHand()
						.getType() == Material.MUSIC_DISC_FAR)) {

					if (player.getInventory().getItemInMainHand().getItemMeta()
							.hasCustomModelData()) {

						if (player.getInventory().getItemInMainHand()
								.getItemMeta().getCustomModelData() == 171) {

							for (Entity ent : getEntitys(player, 10)) {

								int tier = 1;
								if (getPowerLevel(player, "forcefreeze") == 2) {
									tier = 2;
								}
								
								if (getPowerLevel(player, "forcefreeze") == 3) {
									tier = 3;
								}
								
								
								if (CM.checkCdf(player)) {
									player.sendMessage(
											ChatColor.BLUE + "Force Freeze");
									if (ent instanceof Player) {
										ent.sendMessage(ChatColor.BLUE
												+ "Force Frozen by "
												+ player.getName());
									}
									if (tier == 1) {
										((LivingEntity) ent).addPotionEffect(
												new PotionEffect(
														PotionEffectType.SLOW,
														100, 100));
										if(ent instanceof Player) {
						                ((LivingEntity) ent).addPotionEffect(new PotionEffect(PotionEffectType.JUMP,100,128));
						                ((LivingEntity) ent).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,100,128));
										}
										ent.getWorld().spawnParticle(
												Particle.REDSTONE,
												ent.getLocation(), 100, 1.2,
												1.2, 1.2, 1,
												new Particle.DustOptions(
														Color.BLUE, 5));

										CM.setCdf(player, 45);
									}
									if (tier == 2) {

										((LivingEntity) ent).addPotionEffect(
												new PotionEffect(
														PotionEffectType.SLOW,
														160, 100));
										if(ent instanceof Player) {
										((LivingEntity) ent).addPotionEffect(new PotionEffect(PotionEffectType.JUMP,100,128));
						                ((LivingEntity) ent).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,100,128));
										}
										ent.getWorld().spawnParticle(
												Particle.REDSTONE,
												ent.getLocation(), 100, 1.2,
												1.2, 1.2, 1,
												new Particle.DustOptions(
														Color.BLUE, 5));
										CM.setCdf(player, 30);
									}
									
									
									if (tier == 3) {

										((LivingEntity) ent).addPotionEffect(
												new PotionEffect(
														PotionEffectType.SLOW,
														200, 100));
										if(ent instanceof Player) {
										((LivingEntity) ent).addPotionEffect(new PotionEffect(PotionEffectType.JUMP,140,128));
						                ((LivingEntity) ent).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,140,128));
										}
										ent.getWorld().spawnParticle(
												Particle.REDSTONE,
												ent.getLocation(), 100, 1.2,
												1.2, 1.2, 1,
												new Particle.DustOptions(
														Color.BLUE, 5));
										CM.setCdf(player, 20);
									}
	
								} else {
									player.sendMessage(ChatColor.BLUE
											+ "You cannot use this for another "
											+ CM.getCdf(player) + " seconds!");
								}
							}

						}
					}
				}
				
				
				
				
				
				
				
				
				if (getPowerLevel(player, "forcefreeze") >= 1) {

					if ((player.getInventory().getItemInOffHand()
							.getType() == Material.MUSIC_DISC_FAR)) {

						if (player.getInventory().getItemInOffHand().getItemMeta()
								.hasCustomModelData()) {

							if (player.getInventory().getItemInOffHand()
									.getItemMeta().getCustomModelData() == 171) {

								for (Entity ent : getEntitys(player, 10)) {

									int tier = 1;
									if (getPowerLevel(player, "forcefreeze") == 2) {
										tier = 2;
									}
									
									if (getPowerLevel(player, "forcefreeze") == 3) {
										tier = 3;
									}
									
									
									if (CM.checkCdf(player)) {
										player.sendMessage(
												ChatColor.BLUE + "Force Freeze");
										if (ent instanceof Player) {
											ent.sendMessage(ChatColor.BLUE
													+ "Force Frozen by "
													+ player.getName());
										}
										if (tier == 1) {
											((LivingEntity) ent).addPotionEffect(
													new PotionEffect(
															PotionEffectType.SLOW,
															100, 100));
											if(ent instanceof Player) {
							                ((LivingEntity) ent).addPotionEffect(new PotionEffect(PotionEffectType.JUMP,100,128));
							                ((LivingEntity) ent).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,100,128));
											}
											ent.getWorld().spawnParticle(
													Particle.REDSTONE,
													ent.getLocation(), 100, 1.2,
													1.2, 1.2, 1,
													new Particle.DustOptions(
															Color.BLUE, 5));

											CM.setCdf(player, 45);
										}
										if (tier == 2) {

											((LivingEntity) ent).addPotionEffect(
													new PotionEffect(
															PotionEffectType.SLOW,
															160, 100));
											if(ent instanceof Player) {
											((LivingEntity) ent).addPotionEffect(new PotionEffect(PotionEffectType.JUMP,100,128));
							                ((LivingEntity) ent).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,100,128));
											}
											ent.getWorld().spawnParticle(
													Particle.REDSTONE,
													ent.getLocation(), 100, 1.2,
													1.2, 1.2, 1,
													new Particle.DustOptions(
															Color.BLUE, 5));
											CM.setCdf(player, 30);
										}
										
										
										if (tier == 3) {

											((LivingEntity) ent).addPotionEffect(
													new PotionEffect(
															PotionEffectType.SLOW,
															200, 100));
											if(ent instanceof Player) {
											((LivingEntity) ent).addPotionEffect(new PotionEffect(PotionEffectType.JUMP,140,128));
							                ((LivingEntity) ent).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,140,128));
											}
											ent.getWorld().spawnParticle(
													Particle.REDSTONE,
													ent.getLocation(), 100, 1.2,
													1.2, 1.2, 1,
													new Particle.DustOptions(
															Color.BLUE, 5));
											CM.setCdf(player, 20);
										}
		
									} else {
										player.sendMessage(ChatColor.BLUE
												+ "You cannot use this for another "
												+ CM.getCdf(player) + " seconds!");
									}
								}

							}
						}
					
				
				
				
					}
				}
				
				
				
				
				
				


			}
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@EventHandler
	public void forceHeal(PlayerInteractEvent event) {

		if (event.getAction().equals(Action.LEFT_CLICK_AIR)
				|| event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			return;
		}

		// Force
		// Heal================================================================================
		Player player = event.getPlayer();

		if (getPowerLevel(player, "forceheal") >= 1) {
			if ((player.getInventory().getItemInMainHand()
					.getType() == Material.MUSIC_DISC_FAR)) {

				if (player.getInventory().getItemInMainHand().getItemMeta()
						.hasCustomModelData()) {

					if (player.getInventory().getItemInMainHand().getItemMeta()
							.getCustomModelData() == 141) {

						int cd = 60;
						int range = 5;
						
						int regen = 100;
						if(getPowerLevel(player, "forceheal") == 2)
						{
							 cd = 40;
							range = 7;
							
							regen = 160;
							
						}
						
						if(getPowerLevel(player, "forceheal") == 3)
						{
							 cd = 20;
							range = 9;
							
							regen = 200;
							
						}
						
						
						
						if (CM.checkCdh(player)) {

							player.addPotionEffect(new PotionEffect(
									PotionEffectType.REGENERATION, regen, 2));
							CM.setCdh(player, cd);
							Location loc = player.getLocation();

							for (double i = 0; i < 2 * Math.PI; i += 0.1) {
								double x = Math.cos(i) * 5;
								double y = Math.sin(i) * 5;

								player.getWorld().spawnParticle(
										Particle.REDSTONE, loc.getX() + x,
										loc.getY(), loc.getZ() + y, 1,
										new Particle.DustOptions(Color.YELLOW,
												5));

							}

							for (Entity ent : player.getNearbyEntities(range, range,
									range)) {

								if (ent instanceof Player) {
									ent = (Player) ent;
									player.sendMessage(ChatColor.YELLOW
											+ "Force Healed " + ent.getName());
									ent.sendMessage(ChatColor.YELLOW
											+ "Force Healed by "
											+ player.getName());
									((LivingEntity) ent)
											.addPotionEffect(new PotionEffect(
													PotionEffectType.HEAL, 1,
													50));
								}

							}

						} else {
							player.sendMessage(ChatColor.YELLOW
									+ "You cannot use this for another "
									+ CM.getCdh(player) + " seconds!");
						}
					}
				}
			}

			
			
			
			
			if ((player.getInventory().getItemInOffHand()
					.getType() == Material.MUSIC_DISC_FAR)) {

				if (player.getInventory().getItemInOffHand().getItemMeta()
						.hasCustomModelData()) {

					if (player.getInventory().getItemInOffHand().getItemMeta()
							.getCustomModelData() == 141) {

						int cd = 60;
						int range = 5;
						
						int regen = 100;
						if(getPowerLevel(player, "forceheal") == 2)
						{
							 cd = 40;
							range = 7;
							
							regen = 160;
							
						}
						
						if(getPowerLevel(player, "forceheal") == 3)
						{
							 cd = 20;
							range = 9;
							
							regen = 200;
							
						}
						
						
						
						if (CM.checkCdh(player)) {

							player.addPotionEffect(new PotionEffect(
									PotionEffectType.REGENERATION, regen, 2));
							CM.setCdh(player, cd);
							Location loc = player.getLocation();

							for (double i = 0; i < 2 * Math.PI; i += 0.1) {
								double x = Math.cos(i) * 5;
								double y = Math.sin(i) * 5;

								player.getWorld().spawnParticle(
										Particle.REDSTONE, loc.getX() + x,
										loc.getY(), loc.getZ() + y, 1,
										new Particle.DustOptions(Color.YELLOW,
												5));

							}

							for (Entity ent : player.getNearbyEntities(range, range,
									range)) {

								if (ent instanceof Player) {
									ent = (Player) ent;
									player.sendMessage(ChatColor.YELLOW
											+ "Force Healed " + ent.getName());
									ent.sendMessage(ChatColor.YELLOW
											+ "Force Healed by "
											+ player.getName());
									((LivingEntity) ent)
											.addPotionEffect(new PotionEffect(
													PotionEffectType.HEAL, 1,
													50));
								}

							}

						} else {
							player.sendMessage(ChatColor.YELLOW
									+ "You cannot use this for another "
									+ CM.getCdh(player) + " seconds!");
						}
					}
				}
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

		}

	}

	@EventHandler
	public void forceDash(PlayerInteractEvent event) {

		if (event.getAction().equals(Action.LEFT_CLICK_AIR)
				|| event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			return;
		}

		Player player = event.getPlayer();
		// Force
		// Dash==================================================================================================
		if (getPowerLevel(player, "forcedash") >= 1) {
			if ((player.getInventory().getItemInMainHand()
					.getType() == Material.MUSIC_DISC_FAR)) {

				if (player.getInventory().getItemInMainHand().getItemMeta()
						.hasCustomModelData()) {

					if (player.getInventory().getItemInMainHand().getItemMeta()
							.getCustomModelData() == 121) {

						if (CM.checkCdd(player)) {
							player.sendMessage(ChatColor.GOLD + "Force Dash");

							int tier = 1;

							if (getPowerLevel(player, "forcedash") == 2) {
								tier = 2;
							}
							

							if (getPowerLevel(player, "forcedash") == 3) {
								tier = 3;
							}
							
							

							if (tier == 1) {
								player.addPotionEffect(new PotionEffect(
										PotionEffectType.SPEED, 80, 2));
								CM.setCdd(player, 36);
							}

							if (tier == 2) {
								player.addPotionEffect(new PotionEffect(
										PotionEffectType.SPEED, 160, 4));
								CM.setCdd(player, 24);
							}
							
							
							
							if (tier == 3) {
								player.addPotionEffect(new PotionEffect(
										PotionEffectType.SPEED, 200, 8));
								CM.setCdd(player, 16);
							}
							
							

						} else {
							player.sendMessage(ChatColor.GOLD
									+ "You cannot use this for another "
									+ CM.getCdd(player) + " seconds!");
						}
					}
				}
			}
			
			
			
			
			
			
			
			
			
			
			
			
			if ((player.getInventory().getItemInOffHand()
					.getType() == Material.MUSIC_DISC_FAR)) {

				if (player.getInventory().getItemInOffHand().getItemMeta()
						.hasCustomModelData()) {

					if (player.getInventory().getItemInOffHand().getItemMeta()
							.getCustomModelData() == 121) {

						if (CM.checkCdd(player)) {
							player.sendMessage(ChatColor.GOLD + "Force Dash");

							int tier = 1;

							if (getPowerLevel(player, "forcedash") == 2) {
								tier = 2;
							}
							

							if (getPowerLevel(player, "forcedash") == 3) {
								tier = 3;
							}
							
							

							if (tier == 1) {
								player.addPotionEffect(new PotionEffect(
										PotionEffectType.SPEED, 80, 2));
								CM.setCdd(player, 36);
							}

							if (tier == 2) {
								player.addPotionEffect(new PotionEffect(
										PotionEffectType.SPEED, 160, 4));
								CM.setCdd(player, 24);
							}
							
							
							
							if (tier == 3) {
								player.addPotionEffect(new PotionEffect(
										PotionEffectType.SPEED, 200, 8));
								CM.setCdd(player, 16);
							}
							
							

						} else {
							player.sendMessage(ChatColor.GOLD
									+ "You cannot use this for another "
									+ CM.getCdd(player) + " seconds!");
						}
					}
				}
			}

			

		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	@EventHandler
	public void forceRepulse(PlayerInteractEvent event) {
		if (event.getAction().equals(Action.LEFT_CLICK_AIR)
				|| event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			return;
		}

		Player player = event.getPlayer();
		if (canUseForce(player)) {
			if (getPowerLevel(player, "forcerepulse") >= 1) {

				if ((player.getInventory().getItemInMainHand()
						.getType() == Material.MUSIC_DISC_FAR)) {
					if (player.getInventory().getItemInMainHand().getItemMeta()
							.hasCustomModelData()) {

						if (player.getInventory().getItemInMainHand()
								.getItemMeta().getCustomModelData() == 181) {

							if (CM.checkCdr(player)) {
								player.sendMessage(ChatColor.DARK_AQUA
										+ "Used Force Repulse");

								int tier = 1;

								
								
								if(getPowerLevel(player, "forcerepulse") == 2)
								{
									tier = 2;
								}
								
								
								
								if(getPowerLevel(player, "forcerepulse") == 3)
								{
									tier = 3;
								}
								
								
								
								if (tier == 1) {
									Location loc = player.getLocation();
									// player.addPotionEffect(new
									// PotionEffect(PotionEffectType.SPEED,100,10));

									for (double i = 0; i < 2
											* Math.PI; i += 0.1) {

										double x = Math.cos(i) * 10;
										double y = Math.sin(i) * 10;

										player.getWorld().spawnParticle(
												Particle.REDSTONE,
												loc.getX() + x, loc.getY(),
												loc.getZ() + y, 1,
												new Particle.DustOptions(Color
														.fromRGB(255, 174, 251),
														5));

									}
									for (Entity e : player.getNearbyEntities(10,
											10, 10)) {
										double px = player.getLocation().getX();
										double pz = player.getLocation().getZ();
										double ex = e.getLocation().getX();
										double ez = e.getLocation().getZ();

										double z = 0;
										double x = 0;

										if (px < ex)
											x = Math.round(
													1 * Math.abs(px - ex) * 100)
													/ 100;
										if (px > ex)
											x = Math.round(-1
													* Math.abs(px - ex) * 100)
													/ 100;

										if (pz < ez)
											z = Math.round(
													1 * Math.abs(pz - ez) * 100)
													/ 100;
										if (pz > ez)
											z = Math.round(-1
													* Math.abs(pz - ez) * 100)
													/ 100;

										e.setVelocity(new Vector(x, 1.4, z));

									}

									CM.setCdr(player, 30);
								}
								
								
								
								
								if (tier == 2) {
									Location loc = player.getLocation();
									// player.addPotionEffect(new
									// PotionEffect(PotionEffectType.SPEED,100,10));

									for (double i = 0; i < 2
											* Math.PI; i += 0.1) {

										double x = Math.cos(i) * 10;
										double y = Math.sin(i) * 10;

										player.getWorld().spawnParticle(
												Particle.REDSTONE,
												loc.getX() + x, loc.getY(),
												loc.getZ() + y, 1,
												new Particle.DustOptions(Color
														.fromRGB(255, 174, 251),
														5));

									}
									for (Entity e : player.getNearbyEntities(14,
											12, 14)) {
										double px = player.getLocation().getX();
										double pz = player.getLocation().getZ();
										double ex = e.getLocation().getX();
										double ez = e.getLocation().getZ();

										double z = 0;
										double x = 0;

										if (px < ex)
											x = Math.round(
													1 * Math.abs(px - ex) * 100)
													/ 100;
										if (px > ex)
											x = Math.round(-1
													* Math.abs(px - ex) * 100)
													/ 100;

										if (pz < ez)
											z = Math.round(
													1 * Math.abs(pz - ez) * 100)
													/ 100;
										if (pz > ez)
											z = Math.round(-1
													* Math.abs(pz - ez) * 100)
													/ 100;

										e.setVelocity(new Vector(x, 1.5, z));

									}
									
									
									
									

									CM.setCdr(player, 20);
								}
								
								
								if (tier == 3) {
									Location loc = player.getLocation();
									// player.addPotionEffect(new
									// PotionEffect(PotionEffectType.SPEED,100,10));

									for (double i = 0; i < 2
											* Math.PI; i += 0.1) {

										double x = Math.cos(i) * 10;
										double y = Math.sin(i) * 10;

										player.getWorld().spawnParticle(
												Particle.REDSTONE,
												loc.getX() + x, loc.getY(),
												loc.getZ() + y, 1,
												new Particle.DustOptions(Color
														.fromRGB(255, 174, 251),
														5));

									}
									for (Entity e : player.getNearbyEntities(18,
											14, 18)) {
										double px = player.getLocation().getX();
										double pz = player.getLocation().getZ();
										double ex = e.getLocation().getX();
										double ez = e.getLocation().getZ();

										double z = 0;
										double x = 0;

										if (px < ex)
											x = Math.round(
													1 * Math.abs(px - ex) * 100)
													/ 100;
										if (px > ex)
											x = Math.round(-1
													* Math.abs(px - ex) * 100)
													/ 100;

										if (pz < ez)
											z = Math.round(
													1 * Math.abs(pz - ez) * 100)
													/ 100;
										if (pz > ez)
											z = Math.round(-1
													* Math.abs(pz - ez) * 100)
													/ 100;

										e.setVelocity(new Vector(x, 1.8, z));

									}

									CM.setCdr(player, 14);
								}
								
								
								
								
								
								
								
								
								
								
								
								
								

							} else {
								player.sendMessage(ChatColor.DARK_AQUA
										+ "You cannot use this for another "
										+ CM.getCdr(player) + " seconds!");
							}
						}
					}
				}

			
				if ((player.getInventory().getItemInOffHand()
						.getType() == Material.MUSIC_DISC_FAR)) {
					if (player.getInventory().getItemInOffHand().getItemMeta()
							.hasCustomModelData()) {

						if (player.getInventory().getItemInOffHand()
								.getItemMeta().getCustomModelData() == 181) {

							if (CM.checkCdr(player)) {
								player.sendMessage(ChatColor.DARK_AQUA
										+ "Used Force Repulse");

								int tier = 1;

								
								
								if(getPowerLevel(player, "forcerepulse") == 2)
								{
									tier = 2;
								}
								
								
								
								if(getPowerLevel(player, "forcerepulse") == 3)
								{
									tier = 3;
								}
								
								
								
								if (tier == 1) {
									Location loc = player.getLocation();
									// player.addPotionEffect(new
									// PotionEffect(PotionEffectType.SPEED,100,10));

									for (double i = 0; i < 2
											* Math.PI; i += 0.1) {

										double x = Math.cos(i) * 10;
										double y = Math.sin(i) * 10;

										player.getWorld().spawnParticle(
												Particle.REDSTONE,
												loc.getX() + x, loc.getY(),
												loc.getZ() + y, 1,
												new Particle.DustOptions(Color
														.fromRGB(255, 174, 251),
														5));

									}
									for (Entity e : player.getNearbyEntities(10,
											10, 10)) {
										double px = player.getLocation().getX();
										double pz = player.getLocation().getZ();
										double ex = e.getLocation().getX();
										double ez = e.getLocation().getZ();

										double z = 0;
										double x = 0;

										if (px < ex)
											x = Math.round(
													1 * Math.abs(px - ex) * 100)
													/ 100;
										if (px > ex)
											x = Math.round(-1
													* Math.abs(px - ex) * 100)
													/ 100;

										if (pz < ez)
											z = Math.round(
													1 * Math.abs(pz - ez) * 100)
													/ 100;
										if (pz > ez)
											z = Math.round(-1
													* Math.abs(pz - ez) * 100)
													/ 100;

										e.setVelocity(new Vector(x, 1.4, z));

									}

									CM.setCdr(player, 30);
								}
								
								
								
								
								if (tier == 2) {
									Location loc = player.getLocation();
									// player.addPotionEffect(new
									// PotionEffect(PotionEffectType.SPEED,100,10));

									for (double i = 0; i < 2
											* Math.PI; i += 0.1) {

										double x = Math.cos(i) * 10;
										double y = Math.sin(i) * 10;

										player.getWorld().spawnParticle(
												Particle.REDSTONE,
												loc.getX() + x, loc.getY(),
												loc.getZ() + y, 1,
												new Particle.DustOptions(Color
														.fromRGB(255, 174, 251),
														5));

									}
									for (Entity e : player.getNearbyEntities(14,
											12, 14)) {
										double px = player.getLocation().getX();
										double pz = player.getLocation().getZ();
										double ex = e.getLocation().getX();
										double ez = e.getLocation().getZ();

										double z = 0;
										double x = 0;

										if (px < ex)
											x = Math.round(
													1 * Math.abs(px - ex) * 100)
													/ 100;
										if (px > ex)
											x = Math.round(-1
													* Math.abs(px - ex) * 100)
													/ 100;

										if (pz < ez)
											z = Math.round(
													1 * Math.abs(pz - ez) * 100)
													/ 100;
										if (pz > ez)
											z = Math.round(-1
													* Math.abs(pz - ez) * 100)
													/ 100;

										e.setVelocity(new Vector(x, 1.5, z));

									}
									
									
									
									

									CM.setCdr(player, 20);
								}
								
								
								if (tier == 3) {
									Location loc = player.getLocation();
									// player.addPotionEffect(new
									// PotionEffect(PotionEffectType.SPEED,100,10));

									for (double i = 0; i < 2
											* Math.PI; i += 0.1) {

										double x = Math.cos(i) * 10;
										double y = Math.sin(i) * 10;

										player.getWorld().spawnParticle(
												Particle.REDSTONE,
												loc.getX() + x, loc.getY(),
												loc.getZ() + y, 1,
												new Particle.DustOptions(Color
														.fromRGB(255, 174, 251),
														5));

									}
									for (Entity e : player.getNearbyEntities(18,
											14, 18)) {
										double px = player.getLocation().getX();
										double pz = player.getLocation().getZ();
										double ex = e.getLocation().getX();
										double ez = e.getLocation().getZ();

										double z = 0;
										double x = 0;

										if (px < ex)
											x = Math.round(
													1 * Math.abs(px - ex) * 100)
													/ 100;
										if (px > ex)
											x = Math.round(-1
													* Math.abs(px - ex) * 100)
													/ 100;

										if (pz < ez)
											z = Math.round(
													1 * Math.abs(pz - ez) * 100)
													/ 100;
										if (pz > ez)
											z = Math.round(-1
													* Math.abs(pz - ez) * 100)
													/ 100;

										e.setVelocity(new Vector(x, 1.8, z));

									}

									CM.setCdr(player, 14);
								}
								
								
								
								
								
								
								
								
								
								
								
								
								

							} else {
								player.sendMessage(ChatColor.DARK_AQUA
										+ "You cannot use this for another "
										+ CM.getCdr(player) + " seconds!");
							}
						}
					}			
				}
		
			
			
			}
			
			
			
		}

	}

	@EventHandler
	public void forceSense(PlayerInteractEvent event) {

		// Force Sense

		if ((event.getAction().equals(Action.RIGHT_CLICK_AIR)
				|| event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {

			Player p = event.getPlayer();

			if (getPowerLevel(p, "forcesense") >= 1) {

				if (p.getInventory().getItemInMainHand().getType()
						.equals(Material.MUSIC_DISC_FAR)) {

					if ((p.getInventory().getItemInMainHand().getItemMeta()
							.hasCustomModelData()))
						if ((p.getInventory().getItemInMainHand().getItemMeta()
								.getCustomModelData() == 191)) {

							int range = 200;
							int cd = 360;
							
							if(getPowerLevel(p,"forcesense") == 2)
							{
								range = 500;
								cd = 240;
							}
							
							
							if(getPowerLevel(p,"forcesense") == 3)
							{
								range = 1000;
								
								cd = 160;
							}
							
							
							if (CM.checkCdfs(p)) {
								p.sendMessage(ChatColor.GREEN
										+ "You Meditated In Search Of Others...");
								p.addPotionEffect(new PotionEffect(
										PotionEffectType.BLINDNESS, 100, 5));
								for (Entity e : p.getNearbyEntities(range, range,
										range)) {
									if (e instanceof Player) {
										Player e1 = (Player)e;
										p.sendMessage(ChatColor.GREEN
												+ "You Felt The Presence of "
												+ e1.getName()+" "+getDistance(p,e1)+" Blocks Away");

									}
								}


								CM.setCdfs(p, cd);

							} else {
								p.sendMessage(ChatColor.GREEN + "You Must Wait "
										+ CM.getCdfs(p) + " more seconds!");
							}

						}
				}


				

			}

		}

	}

	// Side
	// Methods=======================================================================================

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

	
	
	
	public int getDistance(Player p, Player p2)
	{
		
		   int x1 = (int) p.getLocation().getX();
		   int x2 = (int) p2.getLocation().getX();
		   int y1 = (int) p.getLocation().getZ();
		   int y2 = (int) p2.getLocation().getZ();
		   
				   
		    double dis;
		    
		    dis=Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));	 	    
	          
		    int a = (int)dis;
		    return a;
		
		
		
	}
	
	
	
	
	
    public int getPowerLevel(Player p, String force)
    {
    	
    
    	
    	
    	File file = new File(plugin.getDataFolder().getParentFile()+"/BFLevels/data/"+p.getUniqueId() + ".yml");
    	
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
		
		int x = config.getInt(force);
    	
    	return x;
    	
    	
    	
    }
	
	
	
    
    public boolean canUseForce(Player p)
    {
    	
    	if(p.getGameMode() == GameMode.ADVENTURE)
    	{
    		return false;
    	}
    	
    	
    	
    	return true;
    }
	
	
	
	
	
	
	
	
}




