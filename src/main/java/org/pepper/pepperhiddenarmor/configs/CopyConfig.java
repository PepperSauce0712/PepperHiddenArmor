package org.pepper.pepperhiddenarmor.configs;

import org.pepper.pepperhiddenarmor.PepperHiddenArmor;

public class CopyConfig {
    public static void copy(){
        PepperHiddenArmor.pepperHiddenArmor.saveResource("config.yml", false);
    }
}
