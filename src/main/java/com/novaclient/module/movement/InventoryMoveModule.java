package com.novaclient.module.movement;

import com.novaclient.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;

public class InventoryMoveModule extends Module {
    public InventoryMoveModule() {
        super("inventory_move", "Inventory Move", "Allow movement while in inventory screens", Category.MOVEMENT);
    }
    
    @Override
    protected void onTick() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null && client.currentScreen instanceof InventoryScreen) {
            // Movement handling is done via mixin
        }
    }
}
