package com.novaclient.module.render;

import com.novaclient.module.Module;

public class LowDurabilityWarningModule extends Module {
    public int warningThreshold = 20;
    public boolean playSound = true;
    public boolean showText = true;
    
    public LowDurabilityWarningModule() {
        super("low_durability_warning", "Low Durability Warning", "Warns when tools/armor have low durability", Category.RENDER);
    }
}
