package com.novaclient.gui.menu;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

public class CustomMainMenuScreen extends Screen {
    private static final int BG_COLOR = 0xFF0a0a1a;
    private static final int BUTTON_COLOR = 0x602a2a5a;
    private static final int BUTTON_HOVER = 0x803a3a7a;
    private static final int BUTTON_BORDER = 0xFF4a4a8a;
    private static final int TEXT_COLOR = 0xFFFFFFFF;
    
    private float cometOffset = 0.0f;
    private long lastTime = 0;

    public CustomMainMenuScreen() {
        super(Text.literal("NovaClient Main Menu"));
    }

    @Override
    protected void init() {
        int buttonWidth = 200;
        int buttonHeight = 40;
        int centerX = width / 2;
        int startY = height / 4 + 40;
        
        // Single Player Button
        addDrawableChild(ButtonWidget.builder(
            Text.literal("Singleplayer"),
            btn -> {
                assert client != null;
                client.setScreen(new net.minecraft.client.gui.screen.SelectWorldScreen(this));
            }
        ).dimensions(centerX - buttonWidth / 2, startY, buttonWidth, buttonHeight).build());
        
        // Multiplayer Button
        addDrawableChild(ButtonWidget.builder(
            Text.literal("Multiplayer"),
            btn -> {
                assert client != null;
                client.setScreen(new net.minecraft.client.gui.screen.MultiplayerScreen(this));
            }
        ).dimensions(centerX - buttonWidth / 2, startY + 50, buttonWidth, buttonHeight).build());
        
        // Mods/Modules Button
        addDrawableChild(ButtonWidget.builder(
            Text.literal("Modules"),
            btn -> {
                assert client != null;
                client.setScreen(new ModuleScreen(this));
            }
        ).dimensions(centerX - buttonWidth / 2, startY + 100, buttonWidth, buttonHeight).build());
        
        // Options Button
        addDrawableChild(ButtonWidget.builder(
            Text.literal("Options"),
            btn -> {
                assert client != null;
                client.setScreen(new net.minecraft.client.gui.screen.options.OptionsScreen(this, client.options));
            }
        ).dimensions(centerX - buttonWidth / 2, startY + 150, buttonWidth, buttonHeight).build());
        
        // Quit Button
        addDrawableChild(ButtonWidget.builder(
            Text.literal("Quit"),
            btn -> {
                assert client != null;
                client.scheduleStop();
            }
        ).dimensions(centerX - buttonWidth / 2, startY + 220, buttonWidth, buttonHeight).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderSpaceBackground(context, mouseX, mouseY, delta);
        
        // Render title
        String title = "NovaClient";
        int titleY = height / 8;
        int titleWidth = textRenderer.getWidth(title);
        
        // Title shadow/glow effect
        for (int ox = -2; ox <= 2; ox++) {
            for (int oy = -2; oy <= 2; oy++) {
                if (ox != 0 || oy != 0) {
                    context.drawTextWithShadow(textRenderer, title, 
                        width / 2 - titleWidth / 2 + ox, titleY + oy, 0x4000ffff);
                }
            }
        }
        
        // Main title
        context.drawTextWithShadow(textRenderer, title, 
            width / 2 - titleWidth / 2, titleY, 0xFF00aaff);
        
        // Subtitle
        String subtitle = "Legitimate Client for Minecraft 1.21.1";
        int subtitleWidth = textRenderer.getWidth(subtitle);
        context.drawTextWithShadow(textRenderer, subtitle,
            width / 2 - subtitleWidth / 2, titleY + 30, 0xFFaaaaaa);
        
        // Render buttons with custom styling
        super.render(context, mouseX, mouseY, delta);
        
        // Version info
        String version = "v1.0.0 | Fabric 0.16.2";
        context.drawTextWithShadow(textRenderer, version, 10, height - 20, 0xFF666666);
    }

    private void renderSpaceBackground(DrawContext context, int mouseX, int mouseY, float delta) {
        long currentTime = System.currentTimeMillis();
        if (lastTime == 0) lastTime = currentTime;
        float deltaTime = (currentTime - lastTime) / 1000.0f;
        lastTime = currentTime;
        
        cometOffset += deltaTime * 50.0f;
        if (cometOffset > width + 200) {
            cometOffset = -200;
        }
        
        // Dark space gradient background
        for (int y = 0; y < height; y++) {
            float factor = y / (float)height;
            int color = interpolateColor(BG_COLOR, 0xFF1a1a3a, (int)(factor * 255));
            context.fill(0, y, width, y + 1, color);
        }
        
        // Animated stars
        long time = currentTime;
        for (int i = 0; i < 150; i++) {
            int starX = (int)((Math.sin(i * 123.456 + time * 0.0001) * 0.5 + 0.5) * width);
            int starY = (int)((Math.cos(i * 789.012 + time * 0.0002) * 0.5 + 0.5) * height);
            int brightness = (int)(100 + 155 * Math.sin(time * 0.003 + i * 0.1));
            int starColor = (255 << 24) | (brightness << 16) | (brightness << 8) | brightness;
            context.fill(starX, starY, starX + 2, starY + 2, starColor);
        }
        
        // Animated comets
        renderComet(context, cometOffset, height / 4, 150, 3);
        renderComet(context, cometOffset - 300, height * 3 / 4, 100, 2);
        renderComet(context, cometOffset - 600, height / 2, 180, 4);
    }

    private void renderComet(DrawContext context, float startX, float startY, float length, float thickness) {
        if (startX < -200 || startX > width + 200) return;
        
        // Comet tail gradient
        for (int i = 0; i < length; i++) {
            float alpha = 1.0f - (i / length);
            int color = (int)(alpha * 200) << 24 | 0x00aaff;
            float x = startX + i;
            float y = startY + (i * 0.3f);
            float t = thickness * alpha;
            
            context.fill((int)x, (int)(y - t), (int)(x + 3), (int)(y + t), color);
        }
        
        // Comet head (bright)
        context.fill((int)startX, (int)(startY - thickness), (int)(startX + 5), (int)(startY + thickness), 0xFFffffff);
    }

    private int interpolateColor(int color1, int color2, int factor) {
        int a1 = (color1 >> 24) & 0xFF, r1 = (color1 >> 16) & 0xFF, g1 = (color1 >> 8) & 0xFF, b1 = color1 & 0xFF;
        int a2 = (color2 >> 24) & 0xFF, r2 = (color2 >> 16) & 0xFF, g2 = (color2 >> 8) & 0xFF, b2 = color2 & 0xFF;
        
        int f = MathHelper.clamp(factor, 0, 255);
        int a = a1 + (a2 - a1) * f / 255;
        int r = r1 + (r2 - r1) * f / 255;
        int g = g1 + (g2 - g1) * f / 255;
        int b = b1 + (b2 - b1) * f / 255;
        
        return (a << 24) | (r << 16) | (g << 8) | b;
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    @Override
    public void close() {
        // Don't close on ESC, stay in menu
    }
}
