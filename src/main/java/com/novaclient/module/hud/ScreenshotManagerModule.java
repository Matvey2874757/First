package com.novaclient.module.hud;

import com.novaclient.module.Module;

public class ScreenshotManagerModule extends Module {
    public String screenshotFolder = "screenshots";
    public boolean autoOrganize = true;
    
    public ScreenshotManagerModule() {
        super("screenshot_manager", "Screenshot Manager", "View and manage screenshots in-game", Category.HUD);
    }
}
