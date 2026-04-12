package com.novaclient.module.render;

import com.novaclient.module.Module;

public class BlockOutlineModule extends Module {
    public int outlineColor = 0x407c4dff;
    public float outlineThickness = 2.0f;
    public boolean enableGlow = true;
    
    public BlockOutlineModule() {
        super("block_outline", "Block Outline", "Customize the block selection outline", Category.RENDER);
    }
}
