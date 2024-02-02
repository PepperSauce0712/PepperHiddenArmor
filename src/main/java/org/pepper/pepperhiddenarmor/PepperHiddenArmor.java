package org.pepper.pepperhiddenarmor;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.pepper.pepperhiddenarmor.commands.HiddenArmor;
import org.pepper.pepperhiddenarmor.commands.TabHiddenArmor;
import org.pepper.pepperhiddenarmor.configs.CopyConfig;
import org.pepper.pepperhiddenarmor.configs.LoadConfig;
import org.pepper.pepperhiddenarmor.events.HiddenEvent;

public final class PepperHiddenArmor extends JavaPlugin {

    public static PepperHiddenArmor pepperHiddenArmor;
    @Override
    public void onEnable() {
        // Plugin startup logic
        pepperHiddenArmor = this;
        this.getLogger().info("PepperHiddenArmor v1.0 已成功載入！");

        Bukkit.getPluginCommand("hiddenarmor").setExecutor(new HiddenArmor());
        Bukkit.getPluginCommand("hiddenarmor").setTabCompleter(new TabHiddenArmor());

        Bukkit.getPluginManager().registerEvents(new HiddenEvent(), pepperHiddenArmor);

        CopyConfig.copy();

        LoadConfig.load();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        pepperHiddenArmor = this;
        this.getLogger().info("PepperHiddenArmor v1.0 已成功卸載。");
    }
}
