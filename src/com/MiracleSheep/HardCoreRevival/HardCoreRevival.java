package com.MiracleSheep.HardCoreRevival;


import com.MiracleSheep.HardCoreRevival.Commands.PluginCommands;
import com.MiracleSheep.HardCoreRevival.Events.PluginEvents;
import com.MiracleSheep.HardCoreRevival.Inventory.RevivalSelection;
import com.MiracleSheep.HardCoreRevival.Items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class HardCoreRevival extends JavaPlugin {


    public HardCoreRevival main;
    public ItemManager i = new ItemManager(this);
    public static RevivalSelection inventory;

    @Override
    public void onEnable() {


        saveDefaultConfig();
        if (getConfig().getBoolean("Enabled") == true) {
        PluginCommands command = new PluginCommands(this);
        ItemManager i = new ItemManager(this);
        ItemManager.init();
        getServer().getPluginManager().registerEvents(new PluginEvents(this,inventory),this);
        getCommand("test").setExecutor(command);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[MiracleSheepEssentials] plugin is enabled.");
        } else {
            return;
        }

    }


    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MiracleSheepEssentials] plugin is disabled.");
    }

    public RevivalSelection returnGui() {
        RevivalSelection gui = new RevivalSelection(this);
        return (gui);
    }


}