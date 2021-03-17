package com.MiracleSheep.HardCoreRevival.Events;

import com.MiracleSheep.HardCoreRevival.HardCoreRevival;
import com.MiracleSheep.HardCoreRevival.Inventory.RevivalSelection;
import com.MiracleSheep.HardCoreRevival.Items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class PluginEvents implements Listener {

    public static HardCoreRevival main;
    public static RevivalSelection inventory;



    public PluginEvents(HardCoreRevival hardcorerevival, RevivalSelection m) {
        this.main = hardcorerevival;
        this.inventory = m;

    }


    @EventHandler
    public static void onPlayerRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action a = e.getAction();

        if (p.getItemInHand().equals(ItemManager.Emblem)) {

            if(main.getConfig().getBoolean("Revive_All") == false) {
            p.openInventory(main.returnGui().getInventory());
            } else {

                int f = 0;
                Player[] pl = Bukkit.getServer().getOnlinePlayers().toArray(new Player[0]);
                for (int b = 0; b < pl.length; b++) {
                    if (pl[b].getGameMode() == GameMode.SPECTATOR) {
                        f++;
                    } else {
                    }
                }

                if (f == 0) {
                } else {
                    Player[] pc = new Player[f];
                    int slot = 0;
                    for (int b = 0; b < pl.length; b++) {
                        if (pl[b].getGameMode() == GameMode.SPECTATOR) {
                            pc[slot] = pl[b];
                            slot++;
                        } else {
                        }
                    }

                    for (int i = 0; i < pc.length; i++) {

                    pc[i].sendMessage(ChatColor.GOLD + "You have been selected to be revived!");
                    pc[i].teleport(p);
                    pc[i].setGameMode(GameMode.SURVIVAL);
                    pc[i].setFoodLevel(20);
                    pc[i].setHealth(20);
                    p.getItemInHand().setAmount(0);

                    }
                }


            }
    }

    }


    @EventHandler
    public void onClick(InventoryClickEvent e) throws ClassCastException {


        if (e.getClickedInventory() == null) {
            return;
        }
        try {
            if (e.getClickedInventory().getHolder() instanceof RevivalSelection) {
                e.setCancelled(true);
                Player player = (Player) e.getWhoClicked();
                int slotnum = e.getSlot();


                if (e.getCurrentItem() == null) {
                    return;
                }

                int f = 0;
                Player[] pl = Bukkit.getServer().getOnlinePlayers().toArray(new Player[0]);
                for (int b = 0; b < pl.length; b++) {
                    if (pl[b].getGameMode() == GameMode.SPECTATOR) {
                        f++;
                    } else {
                    }
                }

                if (slotnum >= 0 && slotnum < f) {


                    if (f == 0) {
                    } else {
                        Player[] pc = new Player[f];
                        int slot = 0;
                        for (int b = 0; b < pl.length; b++) {
                            if (pl[b].getGameMode() == GameMode.SPECTATOR) {
                                pc[slot] = pl[b];
                                slot++;
                            } else {
                            }
                        }

                        pc[0].sendMessage(String.valueOf(slotnum));

                        pc[slotnum].sendMessage(ChatColor.GOLD + "You have been selected to be revived!");
                        pc[slotnum].teleport(player);
                        pc[slotnum].setGameMode(GameMode.SURVIVAL);
                        pc[slotnum].setFoodLevel(20);
                        pc[slotnum].setHealth(20);
                        player.closeInventory();
                        player.getItemInHand().setAmount(0);
                    }





                    }  else if (slotnum >= f) {
                        player.sendMessage(ChatColor.DARK_RED + "That is not a valid kit");
                    }


                }

            } catch(ClassCastException d){
                d.getStackTrace();


        }
    }



//    @EventHandler
//    public static void onPlayerJoin(PlayerJoinEvent e) {
//        Player player = e.getPlayer();
//        if ( main.getConfig().getBoolean("Do_Server_Join_Message") == true) {
//            player.sendMessage(ChatColor.AQUA + main.getConfig().getString("Server_Join_Message"));
//        }
//
//        if (main.getConfig().getBoolean("Do_Plugin_Announce_Message") == true) {
//            player.sendMessage(ChatColor.DARK_PURPLE + "[Plugintemplate] plugin is enabled.");
//        }
//    }

}
