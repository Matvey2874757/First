package com.novaclient.module.modules.combat;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class HitDelayTimer extends Module {
    public int posX = 100;
    public int posY = 80;
    public boolean showNumeric = true;
    public float scale = 1.0f;

    public HitDelayTimer() {
        super("Hit Delay Timer", "Visual timer until next attack", ModuleCategory.COMBAT);
    }

    public int getPosX() { return posX; }
    public void setPosX(int x) { this.posX = x; }
    
    public int getPosY() { return posY; }
    public void setPosY(int y) { this.posY = y; }
    
    public boolean showNumeric() { return showNumeric; }
    public void setShowNumeric(boolean s) { this.showNumeric = s; }
    
    public float getScale() { return scale; }
    public void setScale(float s) { this.scale = s; }
}
