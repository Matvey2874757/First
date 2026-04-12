package com.novaclient.module.modules.movement;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class InventoryMove extends Module {
    public boolean allowRotation = false;
    public boolean allowSneak = true;

    public InventoryMove() {
        super("Inventory Move", "Allows movement while in inventory", ModuleCategory.MOVEMENT);
    }

    public boolean allowRotation() { return allowRotation; }
    public void setAllowRotation(boolean a) { this.allowRotation = a; }
    
    public boolean allowSneak() { return allowSneak; }
    public void setAllowSneak(boolean a) { this.allowSneak = a; }
}
