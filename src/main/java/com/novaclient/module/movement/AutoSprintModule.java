package com.novaclient.module.movement;

import com.novaclient.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffects;

public class AutoSprintModule extends Module {
    public AutoSprintModule() {
        super("auto_sprint", "Auto Sprint", "Automatically sprint when moving forward", Category.MOVEMENT);
    }
    
    @Override
    protected void onTick() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null && client.options.forwardKey.isPressed()) {
            if (!client.player.isSneaking() && !client.player.hasStatusEffect(StatusEffects.SLOWNESS)) {
                client.player.setSprinting(true);
            }
        }
    }
}
