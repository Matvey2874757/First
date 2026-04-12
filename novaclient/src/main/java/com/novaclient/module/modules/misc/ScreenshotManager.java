package com.novaclient.module.modules.misc;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class ScreenshotManager extends Module {
    public boolean autoSave = true;
    public String saveDirectory = "screenshots/novaclient";

    public ScreenshotManager() {
        super("Screenshot Manager", "Manage and view screenshots in-game", ModuleCategory.MISC);
    }

    public boolean autoSave() { return autoSave; }
    public void setAutoSave(boolean a) { this.autoSave = a; }
    
    public String getSaveDirectory() { return saveDirectory; }
    public void setSaveDirectory(String d) { this.saveDirectory = d; }
}
