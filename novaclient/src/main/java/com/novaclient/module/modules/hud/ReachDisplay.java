package com.novaclient.module.modules.hud;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class ReachDisplay extends Module {
    public int posX = 100;
    public int posY = 120;
    public boolean showNumeric = true;

    public ReachDisplay() {
        super("Reach Display", "Shows distance to target (visual only)", ModuleCategory.HUD);
    }

    public int getPosX() { return posX; }
    public void setPosX(int x) { this.posX = x; }
    
    public int getPosY() { return posY; }
    public void setPosY(int y) { this.posY = y; }
    
    public boolean showNumeric() { return showNumeric; }
    public void setShowNumeric(boolean show) { this.showNumeric = show; }
}
