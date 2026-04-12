package com.novaclient.module.modules.hud;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class TargetHUD extends Module {
    public int posX = 200;
    public int posY = 50;
    public boolean showHealthBar = true;
    public boolean showArmor = true;

    public TargetHUD() {
        super("Target HUD", "Shows target health and name", ModuleCategory.HUD);
    }

    public int getPosX() { return posX; }
    public void setPosX(int x) { this.posX = x; }
    
    public int getPosY() { return posY; }
    public void setPosY(int y) { this.posY = y; }
    
    public boolean showHealthBar() { return showHealthBar; }
    public void setShowHealthBar(boolean show) { this.showHealthBar = show; }
    
    public boolean showArmor() { return showArmor; }
    public void setShowArmor(boolean show) { this.showArmor = show; }
}
