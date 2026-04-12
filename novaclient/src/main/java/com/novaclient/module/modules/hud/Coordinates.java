package com.novaclient.module.modules.hud;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class Coordinates extends Module {
    public boolean showDirection = true;
    public int posX = 10;
    public int posY = 50;
    public float scale = 1.0f;

    public Coordinates() {
        super("Coordinates", "Shows X, Y, Z coordinates and direction", ModuleCategory.HUD);
    }

    public boolean showDirection() { return showDirection; }
    public void setShowDirection(boolean show) { this.showDirection = show; }
    
    public int getPosX() { return posX; }
    public void setPosX(int x) { this.posX = x; }
    
    public int getPosY() { return posY; }
    public void setPosY(int y) { this.posY = y; }
    
    public float getScale() { return scale; }
    public void setScale(float s) { this.scale = s; }
}
