package com.novaclient.module.render;

import com.novaclient.module.Module;

public class ItemPhysicsModule extends Module {
    public boolean realisticRotation = true;
    public float rotationSpeed = 1.0f;
    
    public ItemPhysicsModule() {
        super("item_physics", "Item Physics", "Items fall and rotate realistically when dropped", Category.RENDER);
    }
}
