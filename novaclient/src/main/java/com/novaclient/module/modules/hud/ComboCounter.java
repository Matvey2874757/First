package com.novaclient.module.modules.hud;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class ComboCounter extends Module {
    public int posX = 100;
    public int posY = 100;
    public float scale = 1.5f;

    public ComboCounter() {
        super("Combo Counter", "Shows consecutive hits counter", ModuleCategory.HUD);
    }

    public int getPosX() { return posX; }
    public void setPosX(int x) { this.posX = x; }
    
    public int getPosY() { return posY; }
    public void setPosY(int y) { this.posY = y; }
    
    public float getScale() { return scale; }
    public void setScale(float s) { this.scale = s; }
}
