package com.novaclient.module;

import com.novaclient.module.category.ModuleCategory;
import com.novaclient.module.modules.combat.AimAssist;
import com.novaclient.module.modules.combat.HitDelayTimer;
import com.novaclient.module.modules.hud.*;
import com.novaclient.module.modules.misc.ScreenshotManager;
import com.novaclient.module.modules.movement.*;
import com.novaclient.module.modules.render.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModuleManager {
    private final Map<String, Module> modules = new HashMap<>();
    private final Map<ModuleCategory, List<Module>> modulesByCategory = new HashMap<>();

    public void initializeModules() {
        // Render modules
        registerModule(new Fullbright());
        registerModule(new CustomCrosshair());
        registerModule(new HitColor());
        registerModule(new ItemPhysics());
        registerModule(new BlockOutline());
        registerModule(new LowDurabilityWarning());
        registerModule(new PotionStatusIcons());
        registerModule(new ArmorStatus());

        // HUD modules
        registerModule(new Keystrokes());
        registerModule(new Coordinates());
        registerModule(new FPSDisplay());
        registerModule(new ComboCounter());
        registerModule(new ReachDisplay());
        registerModule(new TargetHUD());
        registerModule(new CustomChat());

        // Movement modules
        registerModule(new Sprint());
        registerModule(new InventoryMove());
        registerModule(new BetterSneak());

        // Combat modules
        registerModule(new AimAssist());
        registerModule(new HitDelayTimer());

        // Misc modules
        registerModule(new ScreenshotManager());

        // Initialize categories
        for (ModuleCategory category : ModuleCategory.values()) {
            modulesByCategory.put(category, new ArrayList<>());
        }
    }

    private void registerModule(Module module) {
        modules.put(module.getName().toLowerCase(), module);
        modulesByCategory.computeIfAbsent(module.getCategory(), k -> new ArrayList<>()).add(module);
    }

    public Module getModule(String name) {
        return modules.get(name.toLowerCase());
    }

    public List<Module> getModules() {
        return new ArrayList<>(modules.values());
    }

    public List<Module> getModulesByCategory(ModuleCategory category) {
        return modulesByCategory.getOrDefault(category, new ArrayList<>());
    }

    public void tick() {
        for (Module module : modules.values()) {
            if (module.isEnabled()) {
                module.tick();
            }
        }
    }

    public void render() {
        for (Module module : modules.values()) {
            if (module.isEnabled()) {
                module.render();
            }
        }
    }
}
