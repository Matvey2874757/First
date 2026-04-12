package com.novaclient.module.render;

import com.novaclient.module.Module;

public class HitColorModule extends Module {
    public int hitColor = 0xFFFF0000;
    public float hitDuration = 0.3f;
    
    public HitColorModule() {
        super("hit_color", "Hit Color", "Shows colored effect when hitting entities", Category.RENDER);
    }
}
