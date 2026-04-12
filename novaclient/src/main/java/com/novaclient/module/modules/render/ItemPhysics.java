package com.novaclient.module.modules.render;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class ItemPhysics extends Module {
    public float rotationSpeed = 1.0f;
    public boolean realisticGravity = true;

    public ItemPhysics() {
        super("Item Physics", "Makes dropped items rotate and fall realistically", ModuleCategory.RENDER);
    }

    public float getRotationSpeed() {
        return rotationSpeed;
    }

    public void setRotationSpeed(float speed) {
        this.rotationSpeed = speed;
    }

    public boolean hasRealisticGravity() {
        return realisticGravity;
    }

    public void setRealisticGravity(boolean realistic) {
        this.realisticGravity = realistic;
    }
}
