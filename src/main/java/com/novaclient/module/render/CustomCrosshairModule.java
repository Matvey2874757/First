package com.novaclient.module.render;

import com.novaclient.module.Module;

public class CustomCrosshairModule extends Module {
    public int crosshairColor = 0xFFFFFFFF;
    public float crosshairScale = 1.0f;
    public String crosshairType = "default";
    public boolean animateOnHit = true;
    
    public CustomCrosshairModule() {
        super("custom_crosshair", "Custom Crosshair", "Customize crosshair appearance and animation", Category.RENDER);
    }
}
