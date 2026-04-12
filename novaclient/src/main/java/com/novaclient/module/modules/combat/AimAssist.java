package com.novaclient.module.modules.combat;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class AimAssist extends Module {
    public float strength = 0.1f; // 0-20% (0.0 - 0.2)
    public int fov = 90;
    public boolean requireClick = true;

    public AimAssist() {
        super("Aim Assist", "Very soft visual target following (0-20%)", ModuleCategory.COMBAT);
    }

    public float getStrength() { return strength; }
    public void setStrength(float s) { this.strength = Math.min(0.2f, Math.max(0.0f, s)); }
    
    public int getFov() { return fov; }
    public void setFov(int f) { this.fov = f; }
    
    public boolean requireClick() { return requireClick; }
    public void setRequireClick(boolean r) { this.requireClick = r; }
}
