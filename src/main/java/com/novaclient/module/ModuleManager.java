package com.novaclient.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModuleManager {
    private static final Map<String, Module> modules = new HashMap<>();
    private static final Map<Module.Category, List<Module>> modulesByCategory = new HashMap<>();
    
    public static void init() {
        // Initialize category lists
        for (Module.Category category : Module.Category.values()) {
            modulesByCategory.put(category, new ArrayList<>());
        }
        
        // Register all modules
        registerModules();
    }
    
    private static void registerModules() {
        // RENDER modules
        register(new com.novaclient.module.render.FullbrightModule());
        register(new com.novaclient.module.render.CustomCrosshairModule());
        register(new com.novaclient.module.render.HitColorModule());
        register(new com.novaclient.module.render.ItemPhysicsModule());
        register(new com.novaclient.module.render.BlockOutlineModule());
        register(new com.novaclient.module.render.LowDurabilityWarningModule());
        register(new com.novaclient.module.render.PotionStatusIconsModule());
        register(new com.novaclient.module.render.ArmorStatusModule());
        
        // HUD modules
        register(new com.novaclient.module.hud.KeystrokesModule());
        register(new com.novaclient.module.hud.CoordinatesModule());
        register(new com.novaclient.module.hud.FPSPingDisplayModule());
        register(new com.novaclient.module.hud.ComboCounterModule());
        register(new com.novaclient.module.hud.ReachDisplayModule());
        register(new com.novaclient.module.hud.TargetHUDModule());
        register(new com.novaclient.module.hud.CustomChatModule());
        register(new com.novaclient.module.hud.ScreenshotManagerModule());
        
        // MOVEMENT modules
        register(new com.novaclient.module.movement.AutoSprintModule());
        register(new com.novaclient.module.movement.InventoryMoveModule());
        register(new com.novaclient.module.movement.BetterSneakModule());
        
        // PVP modules
        register(new com.novaclient.module.pvp.AimAssistModule());
        register(new com.novaclient.module.pvp.HitDelayTimerModule());
        
        // PERFORMANCE modules
        register(new com.novaclient.module.performance.EntityCullingModule());
        register(new com.novaclient.module.performance.ParticleLimitsModule());
        register(new com.novaclient.module.performance.ChunkRenderDistanceModule());
    }
    
    private static void register(Module module) {
        modules.put(module.getId(), module);
        modulesByCategory.get(module.getCategory()).add(module);
    }
    
    public static Module getModule(String id) {
        return modules.get(id);
    }
    
    public static List<Module> getModules() {
        return new ArrayList<>(modules.values());
    }
    
    public static List<Module> getModulesByCategory(Module.Category category) {
        return modulesByCategory.get(category);
    }
    
    public static void tick() {
        for (Module module : modules.values()) {
            if (module.isEnabled()) {
                module.onTick();
            }
        }
    }
    
    public static boolean isModuleEnabled(String id) {
        Module module = modules.get(id);
        return module != null && module.isEnabled();
    }
}
