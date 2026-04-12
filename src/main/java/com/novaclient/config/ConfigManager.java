package com.novaclient.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.novaclient.NovaClient;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ConfigManager {
    private static final Path CONFIG_DIR = FabricLoader.getInstance().getConfigDir().resolve("novaclient");
    private static final Path CONFIG_FILE = CONFIG_DIR.resolve("config.json");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    private Map<String, ModuleConfig> moduleConfigs;
    private ClientConfig clientConfig;
    
    public ConfigManager() {
        this.moduleConfigs = new HashMap<>();
        this.clientConfig = new ClientConfig();
    }
    
    public void loadConfig() {
        try {
            Files.createDirectories(CONFIG_DIR);
            
            if (Files.exists(CONFIG_FILE)) {
                String json = Files.readString(CONFIG_FILE);
                ConfigData data = GSON.fromJson(json, ConfigData.class);
                
                if (data != null) {
                    if (data.moduleConfigs != null) {
                        this.moduleConfigs = data.moduleConfigs;
                    }
                    if (data.clientConfig != null) {
                        this.clientConfig = data.clientConfig;
                    }
                }
            } else {
                saveConfig();
            }
        } catch (Exception e) {
            NovaClient.LOGGER.error("Failed to load config", e);
            // Create default config on error
            saveConfig();
        }
    }
    
    public void saveConfig() {
        try {
            Files.createDirectories(CONFIG_DIR);
            ConfigData data = new ConfigData(moduleConfigs, clientConfig);
            String json = GSON.toJson(data);
            Files.writeString(CONFIG_FILE, json);
        } catch (Exception e) {
            NovaClient.LOGGER.error("Failed to save config", e);
        }
    }
    
    public boolean isModuleEnabled(String moduleId) {
        return moduleConfigs.computeIfAbsent(moduleId, k -> new ModuleConfig(true)).enabled;
    }
    
    public void setModuleEnabled(String moduleId, boolean enabled) {
        moduleConfigs.computeIfAbsent(moduleId, k -> new ModuleConfig(true)).enabled = enabled;
        saveConfig();
    }
    
    public <T> T getModuleSetting(String moduleId, String settingName, T defaultValue) {
        ModuleConfig config = moduleConfigs.computeIfAbsent(moduleId, k -> new ModuleConfig(true));
        Object value = config.settings.get(settingName);
        if (value == null) {
            return defaultValue;
        }
        try {
            return (T) value;
        } catch (ClassCastException e) {
            return defaultValue;
        }
    }
    
    public void setModuleSetting(String moduleId, String settingName, Object value) {
        ModuleConfig config = moduleConfigs.computeIfAbsent(moduleId, k -> new ModuleConfig(true));
        config.settings.put(settingName, value);
        saveConfig();
    }
    
    public ClientConfig getClientConfig() {
        return clientConfig;
    }
    
    public void setClientConfig(ClientConfig config) {
        this.clientConfig = config;
        saveConfig();
    }
    
    private static class ConfigData {
        public Map<String, ModuleConfig> moduleConfigs;
        public ClientConfig clientConfig;
        
        public ConfigData(Map<String, ModuleConfig> moduleConfigs, ClientConfig clientConfig) {
            this.moduleConfigs = moduleConfigs;
            this.clientConfig = clientConfig;
        }
    }
    
    public static class ModuleConfig {
        public boolean enabled;
        public Map<String, Object> settings;
        
        public ModuleConfig(boolean enabled) {
            this.enabled = enabled;
            this.settings = new HashMap<>();
        }
    }
    
    public static class ClientConfig {
        public int menuBackgroundColor = 0x1a0f2e;
        public int menuAccentColor = 0x7c4dff;
        public float menuAnimationSpeed = 1.0f;
        public boolean showParticles = true;
        public int cometCount = 50;
        
        public ClientConfig() {}
    }
}
