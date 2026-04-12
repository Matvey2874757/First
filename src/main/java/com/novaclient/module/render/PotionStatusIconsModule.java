package com.novaclient.module.render;

import com.novaclient.module.Module;

public class PotionStatusIconsModule extends Module {
    public boolean showIcons = true;
    public int iconSize = 32;
    public boolean showDuration = true;
    
    public PotionStatusIconsModule() {
        super("potion_status_icons", "Potion Status Icons", "Display potion effect icons on HUD", Category.RENDER);
    }
}
