package com.novaclient.module.hud;

import com.novaclient.module.Module;

public class ComboCounterModule extends Module {
    public int positionX = 100;
    public int positionY = 100;
    public float scale = 1.5f;
    
    public ComboCounterModule() {
        super("combo_counter", "Combo Counter", "Display consecutive hits counter", Category.HUD);
    }
}
