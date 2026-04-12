package com.novaclient.mixin.client;

import com.novaclient.gui.menu.CustomMainMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MixinMainMenuScreen {

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(CallbackInfo ci) {
        // Replace title screen with custom main menu when initialized
        Screen currentScreen = net.minecraft.client.MinecraftClient.getInstance().currentScreen;
        if (currentScreen instanceof TitleScreen) {
            net.minecraft.client.MinecraftClient.getInstance().setScreen(new CustomMainMenuScreen());
        }
    }
}
