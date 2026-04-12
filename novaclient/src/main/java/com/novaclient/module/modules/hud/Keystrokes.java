package com.novaclient.module.modules.hud;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class Keystrokes extends Module {
    public boolean showWASD = true;
    public boolean showMouse = true;
    public boolean showCPS = true;
    public int posX = 10;
    public int posY = 10;
    public float scale = 1.0f;

    public Keystrokes() {
        super("Keystrokes", "Shows WASD, mouse buttons and CPS on screen", ModuleCategory.HUD);
    }

    public boolean showWASD() { return showWASD; }
    public void setShowWASD(boolean show) { this.showWASD = show; }
    
    public boolean showMouse() { return showMouse; }
    public void setShowMouse(boolean show) { this.showMouse = show; }
    
    public boolean showCPS() { return showCPS; }
    public void setShowCPS(boolean show) { this.showCPS = show; }
    
    public int getPosX() { return posX; }
    public void setPosX(int x) { this.posX = x; }
    
    public int getPosY() { return posY; }
    public void setPosY(int y) { this.posY = y; }
    
    public float getScale() { return scale; }
    public void setScale(float s) { this.scale = s; }
}
