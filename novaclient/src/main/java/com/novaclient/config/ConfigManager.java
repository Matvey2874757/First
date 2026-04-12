package com.novaclient.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.novaclient.NovaClient;
import com.novaclient.module.Module;
import com.novaclient.module.ModuleManager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private Path configDir;
    private Path configFile;

    public ConfigManager() {
        this.configDir = Path.of("config", "novaclient");
        this.configFile = configDir.resolve("config.json");
    }

    public void loadConfig() {
        try {
            Files.createDirectories(configDir);
            
            if (Files.exists(configFile)) {
                String json = Files.readString(configFile);
                ConfigData data = GSON.fromJson(json, ConfigData.class);
                applyConfig(data);
            } else {
                saveDefaultConfig();
            }
        } catch (Exception e) {
            NovaClient.LOGGER.error("Failed to load config", e);
            saveDefaultConfig();
        }
    }

    public void saveConfig() {
        try {
            Files.createDirectories(configDir);
            ConfigData data = getCurrentConfig();
            String json = GSON.toJson(data);
            Files.writeString(configFile, json);
        } catch (Exception e) {
            NovaClient.LOGGER.error("Failed to save config", e);
        }
    }

    private void saveDefaultConfig() {
        saveConfig();
    }

    private ConfigData getCurrentConfig() {
        ConfigData data = new ConfigData();
        ModuleManager manager = NovaClient.getInstance().getModuleManager();
        
        for (Module module : manager.getModules()) {
            data.enabledModules.put(module.getName(), module.isEnabled());
        }
        
        return data;
    }

    private void applyConfig(ConfigData data) {
        if (data == null || data.enabledModules == null) return;
        
        ModuleManager manager = NovaClient.getInstance().getModuleManager();
        
        for (Module module : manager.getModules()) {
            Boolean enabled = data.enabledModules.get(module.getName());
            if (enabled != null && enabled) {
                module.setEnabled(true);
            }
        }
    }

    private static class ConfigData {
        public java.util.Map<String, Boolean> enabledModules = new java.util.HashMap<>();
    }
}
