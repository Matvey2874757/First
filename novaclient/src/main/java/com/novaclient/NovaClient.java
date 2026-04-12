package com.novaclient;

import com.novaclient.config.ConfigManager;
import com.novaclient.module.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NovaClient implements ClientModInitializer {
    public static final String MOD_ID = "novaclient";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    private static NovaClient instance;
    private ModuleManager moduleManager;
    private ConfigManager configManager;

    @Override
    public void onInitializeClient() {
        instance = this;
        LOGGER.info("Initializing NovaClient...");
        
        // Initialize config manager
        configManager = new ConfigManager();
        configManager.loadConfig();
        
        // Initialize module manager
        moduleManager = new ModuleManager();
        moduleManager.initializeModules();
        
        LOGGER.info("NovaClient initialized successfully!");
    }

    public static NovaClient getInstance() {
        return instance;
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}
