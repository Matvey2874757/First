package com.novaclient.module.category;

public enum ModuleCategory {
    RENDER("Render", "Visual enhancements"),
    MOVEMENT("Movement", "Movement improvements"),
    COMBAT("Combat", "PvP helpers"),
    HUD("HUD", "Heads-up display"),
    MISC("Misc", "Other utilities");

    private final String displayName;
    private final String description;

    ModuleCategory(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }
}
