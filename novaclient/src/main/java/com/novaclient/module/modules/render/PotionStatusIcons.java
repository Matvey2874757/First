package com.novaclient.module.modules.render;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class PotionStatusIcons extends Module {
    public boolean showLargeIcons = false;
    public int iconSize = 18;

    public PotionStatusIcons() {
        super("Potion Status Icons", "Shows potion effect icons on HUD", ModuleCategory.RENDER);
    }

    public boolean showLargeIcons() {
        return showLargeIcons;
    }

    public void setShowLargeIcons(boolean large) {
        this.showLargeIcons = large;
    }

    public int getIconSize() {
        return iconSize;
    }

    public void setIconSize(int size) {
        this.iconSize = size;
    }
}
