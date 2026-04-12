package com.novaclient.module.modules.render;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class BlockOutline extends Module {
    public int outlineColor = 0xFFFFFFFF;
    public float lineWidth = 2.0f;
    public boolean enableShaders = true;

    public BlockOutline() {
        super("Block Outline", "Customize block outline appearance", ModuleCategory.RENDER);
    }

    public int getOutlineColor() {
        return outlineColor;
    }

    public void setOutlineColor(int color) {
        this.outlineColor = color;
    }

    public float getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(float width) {
        this.lineWidth = width;
    }

    public boolean hasShaders() {
        return enableShaders;
    }

    public void setShaders(boolean shaders) {
        this.enableShaders = shaders;
    }
}
