package com.novaclient.mixin.client;

import com.novaclient.module.modules.movement.InventoryMove;
import com.novaclient.NovaClient;
import net.minecraft.client.input.KeyboardInput;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyboardInput.class)
public class MixinKeyboardInput {

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void onTick(boolean slowDown, CallbackInfo ci) {
        if (NovaClient.getInstance() == null) return;
        
        InventoryMove module = (InventoryMove) NovaClient.getInstance().getModuleManager().getModule("Inventory Move");
        if (module != null && module.isEnabled()) {
            Screen screen = net.minecraft.client.MinecraftClient.getInstance().currentScreen;
            if (screen instanceof GenericContainerScreen || screen instanceof InventoryScreen) {
                // Allow movement in inventory screens
                // Movement logic handled by not cancelling input
            }
        }
    }
}
