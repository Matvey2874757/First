package com.novaclient;

import com.novaclient.config.ConfigManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class NovaClient implements ClientModInitializer {
    public static final String MOD_ID = "novaclient";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    private static ConfigManager configManager;
    private static NovaClient instance;
    
    @Override
    public void onInitializeClient() {
        instance = this;
        LOGGER.info("Initializing Nova Client - Space-themed legitimate client for Minecraft 1.21.1");
        
        // Initialize config manager
        configManager = new ConfigManager();
        configManager.loadConfig();
        
        LOGGER.info("Nova Client initialized successfully!");
    }
    
    public static NovaClient getInstance() {
        return instance;
    }
    
    public static ConfigManager getConfigManager() {
        return configManager;
    }
}
