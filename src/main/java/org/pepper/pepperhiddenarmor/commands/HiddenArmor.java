package org.pepper.pepperhiddenarmor.commands;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.pepper.pepperhiddenarmor.configs.LoadConfig;

public class HiddenArmor implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(args.length < 1) return false;
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if(args[0].equals("toggle")) {
            player.sendMessage("現在狀態為: " + LoadConfig.toggle);
            return true;
        } else if (args[0].equals("hat")) {
            player.getInventory().setHelmet(new ItemStack(Material.OAK_BUTTON, 1));
        }
        return false;
    }
}
