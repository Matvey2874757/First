package com.novaclient.module.modules.render;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class Fullbright extends Module {
    private float previousGamma = 1.0f;

    public Fullbright() {
        super("Fullbright", "Increases gamma for better visibility in dark areas", ModuleCategory.RENDER);
    }

    @Override
    protected void onEnable() {
        if (mc.options != null) {
            previousGamma = mc.options.getGamma().floatValue();
            mc.options.getGamma().setValue(16.0);
        }
    }

    @Override
    protected void onDisable() {
        if (mc.options != null) {
            mc.options.getGamma().setValue(previousGamma);
        }
    }
}
