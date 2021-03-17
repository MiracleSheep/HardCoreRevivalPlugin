package com.MiracleSheep.HardCoreRevival.Inventory;

import com.MiracleSheep.HardCoreRevival.HardCoreRevival;
import org.bukkit.*;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

        import org.bukkit.Bukkit;
import org.bukkit.Material;
        import org.bukkit.configuration.file.FileConfiguration;
        import org.bukkit.configuration.file.YamlConfiguration;
        import org.bukkit.inventory.Inventory;
        import org.bukkit.inventory.InventoryHolder;
        import org.bukkit.inventory.ItemStack;
        import org.bukkit.inventory.meta.ItemMeta;
        import org.bukkit.plugin.java.JavaPlugin;

        import java.io.Console;
        import java.io.File;
        import java.io.ObjectInputFilter;
        import java.util.*;

import static org.bukkit.Bukkit.getOnlinePlayers;
import static org.bukkit.Bukkit.getPlayer;

public class RevivalSelection implements InventoryHolder {

    public Inventory inv;
    private final HardCoreRevival main;
    int inventorysize = 18;


    public RevivalSelection(HardCoreRevival main) {



        inv = Bukkit.createInventory(this,inventorysize,"Revival Selection");//max size 54
        this.main = main;
        init(this.main);

    }

    private void init(HardCoreRevival main) {

        ItemStack item;
        Player[] pl = Bukkit.getServer().getOnlinePlayers().toArray(new Player[0]);


        int num = 0;
        int f =0;

        for (int b = 0; b < pl.length; b++) {
            if (pl[b].getGameMode() == GameMode.SPECTATOR) { ;
                f++;
            } else {
            }
        }

        if (f == 0) {} else {
            Player[] pc = new Player[f];
            int slot = 0;
            for (int b = 0; b < pl.length; b++) {
                if (pl[b].getGameMode() == GameMode.SPECTATOR) {
                    pc[slot] = pl[b];
                    slot++;
                } else {
                }
            }

            pc[0].sendMessage(String.valueOf(pc.length));

            for (int g = 0; g < pc.length; g++) {
                inv.setItem(g,getHead(pc[g]));
                num = g + 1;

            }





        }





        for (int i = num; i < inventorysize ; i++) {
            item = createItem("None",Material.WHITE_STAINED_GLASS_PANE, Collections.singletonList("Not an option    "));
            inv.setItem(i,item);
        }


    }



    private ItemStack createItem(String name, Material mat, List<String> lore) {
        ItemStack item = new ItemStack(mat,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;

    }


//    public static ItemStack getHead(Player player) {
//        int lifePlayer = (int) player.getHealth();
//        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
//        SkullMeta skull = (SkullMeta) item.getItemMeta();
//        skull.setDisplayName(player.getName());
//        ArrayList<String> lore = new ArrayList<String>();
//        lore.add("Custom head");
//        skull.setLore(lore);
//        skull.setOwner(player.getName());
//        item.setItemMeta(skull);
//        return item;
//    }


    private static ItemStack getHead(Player player) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1 , (short) 3);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwner(player.getDisplayName());
        meta.setDisplayName(player.getDisplayName());
        item.setItemMeta(meta);
        return(item);
    }


    @Override
    public Inventory getInventory() {
        return inv;
    }
}

