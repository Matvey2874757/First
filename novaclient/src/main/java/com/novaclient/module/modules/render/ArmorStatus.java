package com.novaclient.module.modules.render;

import com.novaclient.module.Module;
import com.novaclient.module.category.ModuleCategory;

public class ArmorStatus extends Module {
    public boolean showPercentage = true;
    public boolean showDurabilityBar = true;
    public int posX = 10;
    public int posY = 100;

    public ArmorStatus() {
        super("Armor Status", "Shows armor durability percentage on screen", ModuleCategory.RENDER);
    }

    public boolean showPercentage() {
        return showPercentage;
    }

    public void setShowPercentage(boolean show) {
        this.showPercentage = show;
    }

    public boolean showDurabilityBar() {
        return showDurabilityBar;
    }

    public void setShowDurabilityBar(boolean show) {
        this.showDurabilityBar = show;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int x) {
        this.posX = x;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int y) {
        this.posY = y;
    }
}
