package com.MiracleSheep.HardCoreRevival.Items;

import com.MiracleSheep.HardCoreRevival.HardCoreRevival;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack Emblem;
    public static HardCoreRevival main;

    public ItemManager (HardCoreRevival hardcorerevival) {
        this.main = hardcorerevival;

    }




    public static void init() {
        createEmblem();
    }



    private static void createEmblem() {
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§4Revival Crystal");
        List<String> lore = new ArrayList<>();
        lore.add("§bBring back your friends!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 10, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        Emblem = item;


    //shaped recipe - the majority of recipes, any recipe with a defined shape that must me met ex: wood pic vs yellow dye
    ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("wand"),item);
        sr.shape("III","IDI","III");
        sr.setIngredient('I',Material.IRON_INGOT);
        sr.setIngredient('D', Material.DIAMOND);
        Bukkit.getServer().addRecipe(sr);

//    //Shapeless recipe - recipe without much shape
//    ShapelessRecipe s = new ShapelessRecipe(NamespacedKey.minecraft("shapeless_wand"), item);
//        s.addIngredient(2, Material.BLAZE_POWDER);
//        Bukkit.getServer().addRecipe(s);
//
//    //furnace recipe
//    FurnaceRecipe smelt = new FurnaceRecipe(NamespacedKey.minecraft("wand_smelt"), item , Material.EMERALD , 1.0f,1*20);
//        Bukkit.getServer().addRecipe(smelt);








    }





}
