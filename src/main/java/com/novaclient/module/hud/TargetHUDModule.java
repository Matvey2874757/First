package com.novaclient.module.hud;

import com.novaclient.module.Module;

public class TargetHUDModule extends Module {
    public int positionX = 300;
    public int positionY = 50;
    public boolean showHealth = true;
    public boolean showName = true;
    public boolean showArmor = true;
    
    public TargetHUDModule() {
        super("target_hud", "Target HUD", "Display target health, name and armor status", Category.HUD);
    }
}
