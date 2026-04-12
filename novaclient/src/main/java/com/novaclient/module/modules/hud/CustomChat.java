package com.novaclient.module.modules.hud;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class CustomChat extends Module {
    public float opacity = 1.0f;
    public boolean customColors = false;
    public int backgroundColor = 0x80000000;

    public CustomChat() {
        super("Custom Chat", "Customize chat appearance", ModuleCategory.HUD);
    }

    public float getOpacity() { return opacity; }
    public void setOpacity(float o) { this.opacity = o; }
    
    public boolean customColors() { return customColors; }
    public void setCustomColors(boolean c) { this.customColors = c; }
    
    public int getBackgroundColor() { return backgroundColor; }
    public void setBackgroundColor(int c) { this.backgroundColor = c; }
}
