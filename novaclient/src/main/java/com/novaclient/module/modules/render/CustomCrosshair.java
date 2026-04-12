package com.novaclient.module.modules.render;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class CustomCrosshair extends Module {
    public int color = 0xFFFFFFFF;
    public float scale = 1.0f;
    public boolean animateOnAttack = true;

    public CustomCrosshair() {
        super("Custom Crosshair", "Customize crosshair appearance", ModuleCategory.RENDER);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public boolean shouldAnimate() {
        return animateOnAttack;
    }
}
