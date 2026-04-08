// File: src/main/java/com/example/zoommod/ZoomModClient.java
package com.example.zoommod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ZoomModClient implements ClientModInitializer {
    private static final String CATEGORY = "key.categories.zoommod";
    private static KeyBinding zoomKey;

    private static boolean zoomActive = false;
    private static double previousFov = -1.0;

    @Override
    public void onInitializeClient() {
        zoomKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.zoommod.zoom",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_C,
                CATEGORY
        ));

        ClientTickEvents.END_CLIENT_TICK.register(this::onClientTick);
    }

    private void onClientTick(MinecraftClient client) {
        if (client.options == null) {
            return;
        }

        boolean keyPressed = zoomKey.isPressed();

        if (keyPressed && !zoomActive) {
            previousFov = client.options.getFov().getValue();
            client.options.getFov().setValue(Math.max(10, previousFov / 4.0));
            zoomActive = true;
        } else if (!keyPressed && zoomActive) {
            client.options.getFov().setValue(previousFov);
            zoomActive = false;
        }
    }
}
