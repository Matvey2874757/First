package com.novaclient.module.modules.movement;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class Sprint extends Module {
    public boolean alwaysSprint = true;
    public boolean directional = false;

    public Sprint() {
        super("Sprint", "Automatic sprinting without conflicts", ModuleCategory.MOVEMENT);
    }

    public boolean alwaysSprint() { return alwaysSprint; }
    public void setAlwaysSprint(boolean a) { this.alwaysSprint = a; }
    
    public boolean directional() { return directional; }
    public void setDirectional(boolean d) { this.directional = d; }
}
