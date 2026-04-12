package com.novaclient.module.hud;

import com.novaclient.module.Module;

public class CoordinatesModule extends Module {
    public boolean showDirection = true;
    public int positionX = 10;
    public int positionY = 50;
    public float scale = 1.0f;
    
    public CoordinatesModule() {
        super("coordinates", "Coordinates", "Display X, Y, Z coordinates and direction", Category.HUD);
    }
}
