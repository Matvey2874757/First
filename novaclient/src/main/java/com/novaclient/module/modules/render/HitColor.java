package com.novaclient.module.modules.render;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class HitColor extends Module {
    public int hitColor = 0xFFFF0000;
    public float duration = 200.0f;

    public HitColor() {
        super("Hit Color", "Shows colored effect when hitting entities", ModuleCategory.RENDER);
    }

    public int getHitColor() {
        return hitColor;
    }

    public void setHitColor(int color) {
        this.hitColor = color;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
}
