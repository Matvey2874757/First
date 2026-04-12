package com.novaclient.module.hud;

import com.novaclient.module.Module;

public class FPSPingDisplayModule extends Module {
    public boolean showFPS = true;
    public boolean showPing = true;
    public int positionX = 10;
    public int positionY = 30;
    
    public FPSPingDisplayModule() {
        super("fps_ping_display", "FPS/Ping Display", "Show current FPS and network ping", Category.HUD);
    }
}
