package com.novaclient.module.render;

import com.novaclient.module.Module;
import net.minecraft.client.MinecraftClient;

public class FullbrightModule extends Module {
    private float previousGamma = 0.5f;
    
    public FullbrightModule() {
        super("fullbright", "Fullbright", "Maximum brightness for better visibility in dark areas", Category.RENDER);
    }
    
    @Override
    protected void onEnable() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null && client.options != null) {
            previousGamma = (float) client.options.getGamma().getValue();
            client.options.getGamma().setValue(16.0);
        }
    }
    
    @Override
    protected void onDisable() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null && client.options != null) {
            client.options.getGamma().setValue(previousGamma);
        }
    }
}
