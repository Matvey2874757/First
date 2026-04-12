package com.novaclient.module.modules.render;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class LowDurabilityWarning extends Module {
    public int warningThreshold = 20;
    public boolean playSound = true;
    public boolean showText = true;

    public LowDurabilityWarning() {
        super("Low Durability Warning", "Warns when item durability is low", ModuleCategory.RENDER);
    }

    public int getThreshold() {
        return warningThreshold;
    }

    public void setThreshold(int threshold) {
        this.warningThreshold = threshold;
    }

    public boolean shouldPlaySound() {
        return playSound;
    }

    public void setPlaySound(boolean play) {
        this.playSound = play;
    }

    public boolean shouldShowText() {
        return showText;
    }

    public void setShowText(boolean show) {
        this.showText = show;
    }
}
