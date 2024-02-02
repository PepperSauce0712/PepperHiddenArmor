package org.pepper.pepperhiddenarmor.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import org.pepper.pepperhiddenarmor.configs.ItemDataStorage;

public class HiddenEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true) // 檢測玩家是否穿上裝備及替換成按鈕
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if(event.getClickedInventory() == player.getInventory() && event.getSlot() == 39){
            if(event.getCurrentItem() == null)return;
            // cursor 放下去在格子內 current是拿起來在手上
            final InventoryView view = event.getView();

            if(!(ItemDataStorage.helmetEqupied)){
                event.setCancelled(true);
                player.sendMessage("放下去");
                ItemDataStorage.helmet = event.getCurrentItem();
                view.setCursor(null);
                player.getInventory().setHelmet(new ItemStack(Material.OAK_BUTTON, 1));
                ItemDataStorage.helmetEqupied = true;
            }else{
                player.sendMessage("拿起來");
                view.setCursor(new ItemStack(Material.NETHERITE_HELMET));
                player.getInventory().setHelmet(null);
                ItemDataStorage.helmetEqupied = false;
            }
        }
    }
}

