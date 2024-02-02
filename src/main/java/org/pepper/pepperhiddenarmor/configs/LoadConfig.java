package org.pepper.pepperhiddenarmor.configs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.pepper.pepperhiddenarmor.PepperHiddenArmor;

import java.io.File;

public class LoadConfig {
    public static boolean toggle;

    public static void load(){
        File file =  new File(PepperHiddenArmor.pepperHiddenArmor.getDataFolder(), "/config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        toggle = config.getBoolean("config.toggle");
    }
}
