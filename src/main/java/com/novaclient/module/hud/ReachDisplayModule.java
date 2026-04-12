package com.novaclient.module.hud;

import com.novaclient.module.Module;

public class ReachDisplayModule extends Module {
    public int positionX = 100;
    public int positionY = 120;
    
    public ReachDisplayModule() {
        super("reach_display", "Reach Display", "Show distance to target (visual only, doesn't change reach)", Category.HUD);
    }
}
