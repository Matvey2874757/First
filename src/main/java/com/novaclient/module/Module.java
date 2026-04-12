package com.novaclient.module;

public abstract class Module {
    protected final String id;
    protected final String name;
    protected final String description;
    protected final Category category;
    protected boolean enabled;
    
    public Module(String id, String name, String description, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.enabled = false;
    }
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Category getCategory() {
        return category;
    }
    
    public boolean isEnabled() {
        return enabled;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        onToggle(enabled);
    }
    
    public void toggle() {
        setEnabled(!enabled);
    }
    
    protected void onEnable() {}
    protected void onDisable() {}
    protected void onTick() {}
    
    private void onToggle(boolean enabled) {
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }
    
    public enum Category {
        RENDER("Render", 0xff7c4dff),
        HUD("HUD", 0xff4dc4ff),
        MOVEMENT("Movement", 0xff4dff88),
        PVP("PvP", 0xffff6b6b),
        PERFORMANCE("Performance", 0xffffd93d);
        
        private final String displayName;
        private final int color;
        
        Category(String displayName, int color) {
            this.displayName = displayName;
            this.color = color;
        }
        
        public String getDisplayName() {
            return displayName;
        }
        
        public int getColor() {
            return color;
        }
    }
}
