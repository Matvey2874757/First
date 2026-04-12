package com.novaclient.module.render;

import com.novaclient.module.Module;

public class ArmorStatusModule extends Module {
    public boolean showPercentage = true;
    public boolean showOnHUD = true;
    public int displayPosition = 0; // 0 = left, 1 = right
    
    public ArmorStatusModule() {
        super("armor_status", "Armor Status", "Display armor durability percentage on screen", Category.RENDER);
    }
}
