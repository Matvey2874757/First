package com.novaclient.module.hud;

import com.novaclient.module.Module;

public class KeystrokesModule extends Module {
    public boolean showWASD = true;
    public boolean showMouseButtons = true;
    public boolean showCPS = true;
    public int positionX = 10;
    public int positionY = 10;
    public float scale = 1.0f;
    
    public KeystrokesModule() {
        super("keystrokes", "Keystrokes", "Display WASD, mouse buttons and CPS on screen", Category.HUD);
    }
}
