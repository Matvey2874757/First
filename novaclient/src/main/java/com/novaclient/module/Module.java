package com.novaclient.module;

import com.novaclient.module.category.ModuleCategory;
import net.minecraft.client.MinecraftClient;

public abstract class Module {
    protected final MinecraftClient mc = MinecraftClient.getInstance();
    
    private final String name;
    private final String description;
    private final ModuleCategory category;
    private boolean enabled;
    
    public Module(String name, String description, ModuleCategory category) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.enabled = false;
    }
    
    public void toggle() {
        setEnabled(!enabled);
    }
    
    public void setEnabled(boolean enabled) {
        if (this.enabled != enabled) {
            this.enabled = enabled;
            if (enabled) {
                onEnable();
            } else {
                onDisable();
            }
        }
    }
    
    public boolean isEnabled() {
        return enabled;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public ModuleCategory getCategory() {
        return category;
    }
    
    protected void onEnable() {}
    protected void onDisable() {}
    
    public void tick() {}
    public void render() {}
}
