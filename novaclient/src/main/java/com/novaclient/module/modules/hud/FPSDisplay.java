package com.novaclient.module.modules.hud;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class FPSDisplay extends Module {
    public boolean showPing = true;
    public int posX = 10;
    public int posY = 20;

    public FPSDisplay() {
        super("FPS/Ping Display", "Shows FPS and ping on screen", ModuleCategory.HUD);
    }

    public boolean showPing() { return showPing; }
    public void setShowPing(boolean show) { this.showPing = show; }
    
    public int getPosX() { return posX; }
    public void setPosX(int x) { this.posX = x; }
    
    public int getPosY() { return posY; }
    public void setPosY(int y) { this.posY = y; }
}
