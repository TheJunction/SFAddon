/*
 * Copyright (c) 2016 CubeXMC. All Rights Reserved.
 * Created by PantherMan594.
 */

package net.cubexmc.sfaddon;

import me.konsolas.aac.api.HackType;
import me.konsolas.aac.api.PlayerViolationEvent;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by David on 11/24.
 *
 * @author David
 */
public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerViolation(PlayerViolationEvent e) {
        if (e.getHackType().equals(HackType.FASTBREAK) || e.getHackType().equals(HackType.IMPOSSIBLEINTERACT)) {
            if (e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getItemMeta() != null && e.getPlayer().getItemInHand().getItemMeta().getDisplayName() != null) {
                String name = e.getPlayer().getItemInHand().getItemMeta().getDisplayName();
                if (name.equals(ChatColor.GOLD + "Lumber Axe") || name.equals(ChatColor.YELLOW + "Explosive Pickaxe")
                        || name.equals(ChatColor.YELLOW + "Pickaxe of Vein Mining")) {
                    e.setCancelled(true);
                }
            }
        } else if (e.getHackType().equals(HackType.FLY)) {
            if (e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getItemMeta() != null && e.getPlayer().getItemInHand().getItemMeta().getDisplayName() != null) {
                String name = e.getPlayer().getItemInHand().getItemMeta().getDisplayName();
                if (name.equals(ChatColor.GOLD + "Elemental Staff " + ChatColor.GRAY + "- " + ChatColor.AQUA + ChatColor.ITALIC + "Wind")) {
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent e) {
        if (e.getReason().equals("Flying is not enabled on this server")) {
            if (e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getItemMeta() != null && e.getPlayer().getItemInHand().getItemMeta().getDisplayName() != null) {
                String name = e.getPlayer().getItemInHand().getItemMeta().getDisplayName();
                if (name.equals(ChatColor.GOLD + "Elemental Staff " + ChatColor.GRAY + "- " + ChatColor.AQUA + ChatColor.ITALIC + "Wind")) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
