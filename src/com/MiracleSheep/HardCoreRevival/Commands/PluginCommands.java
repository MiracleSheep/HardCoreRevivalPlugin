package com.MiracleSheep.HardCoreRevival.Commands;


import com.MiracleSheep.HardCoreRevival.HardCoreRevival;
import org.bukkit.ChatColor;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class PluginCommands implements CommandExecutor {

    private final HardCoreRevival main;

    public PluginCommands(HardCoreRevival main) {
        this.main = main;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player) && !(sender instanceof BlockCommandSender)) {
            sender.sendMessage("Only Players And CommandBlocks can use that command");
            return true;
        }
        CommandSender s = sender;

        if (cmd.getName().equalsIgnoreCase("test")) {

            Player player = (Player) sender;

            if (main.getConfig().getBoolean("Do_Rules_Command") == false) {
                player.sendMessage(ChatColor.DARK_RED + "This command has been disabled");
                return true;
            }

            if (!sender.hasPermission("rules.all")) {
                player.sendMessage(ChatColor.DARK_RED + "You do not have permission to perform this command");
                return true;
            }

            player.sendMessage(ChatColor.GREEN + "Here are the rules:");

        }


        return true;
    }





}
