package com.novaclient.module.modules.movement;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class BetterSneak extends Module {
    public boolean toggleSneak = true;
    public boolean keepSneakOnDisconnect = false;

    public BetterSneak() {
        super("Better Sneak", "Toggle sneak without changing eye height", ModuleCategory.MOVEMENT);
    }

    public boolean toggleSneak() { return toggleSneak; }
    public void setToggleSneak(boolean t) { this.toggleSneak = t; }
    
    public boolean keepSneakOnDisconnect() { return keepSneakOnDisconnect; }
    public void setKeepSneakOnDisconnect(boolean k) { this.keepSneakOnDisconnect = k; }
}
