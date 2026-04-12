package com.novaclient.gui.menu;

import com.novaclient.NovaClient;
import com.novaclient.module.Module;
import com.novaclient.module.ModuleManager;
import com.novaclient.module.category.ModuleCategory;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

import java.util.ArrayList;
import java.util.List;

public class ModuleScreen extends Screen {
    private final Screen parent;
    private ModuleCategory selectedCategory = ModuleCategory.RENDER;
    private int scrollOffset = 0;
    private final List<ModuleButton> moduleButtons = new ArrayList<>();
    private int categoryPanelWidth = 120;
    
    // Space theme colors
    private static final int BG_COLOR = 0xFF0a0a1a;
    private static final int PANEL_COLOR = 0x801a1a3a;
    private static final int BUTTON_COLOR = 0x602a2a5a;
    private static final int BUTTON_HOVER = 0x803a3a7a;
    private static final int ENABLED_COLOR = 0xFF00ff88;
    private static final int DISABLED_COLOR = 0xFF888888;
    private static final int CATEGORY_SELECTED = 0xFF4a4a8a;
    private static final int CATEGORY_NORMAL = 0x402a2a5a;

    public ModuleScreen(Screen parent) {
        super(Text.literal("NovaClient Modules"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        moduleButtons.clear();
        updateModuleButtons();
        
        // Category buttons on the left
        int y = 20;
        for (ModuleCategory category : ModuleCategory.values()) {
            addDrawableChild(new CategoryButton(
                10, y, categoryPanelWidth - 20, 30,
                category,
                btn -> {
                    selectedCategory = category;
                    scrollOffset = 0;
                    updateModuleButtons();
                },
                category == selectedCategory
            ));
            y += 35;
        }
    }

    private void updateModuleButtons() {
        moduleButtons.clear();
        ModuleManager manager = NovaClient.getInstance().getModuleManager();
        List<Module> modules = manager.getModulesByCategory(selectedCategory);
        
        int x = categoryPanelWidth + 20;
        int y = 20 - scrollOffset;
        
        for (Module module : modules) {
            ModuleButton button = new ModuleButton(
                x, y, width - categoryPanelWidth - 40, 40,
                module,
                btn -> module.toggle()
            );
            moduleButtons.add(button);
            y += 45;
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Render space background
        renderSpaceBackground(context, mouseX, mouseY, delta);
        
        // Render category panel
        context.fill(0, 0, categoryPanelWidth, height, PANEL_COLOR);
        
        // Render title
        context.drawTextWithShadow(textRenderer, "Categories", 20, 10, 0xFFFFFFFF);
        
        // Render module panel background
        context.fill(categoryPanelWidth, 0, width, height, PANEL_COLOR);
        
        // Render category title
        context.drawTextWithShadow(textRenderer, 
            selectedCategory.getDisplayName() + " Modules", 
            categoryPanelWidth + 20, 10, 0xFFFFFFFF);
        
        // Render category description
        context.drawTextWithShadow(textRenderer,
            selectedCategory.getDescription(),
            categoryPanelWidth + 20, 25, 0xFFAAAAAA);
        
        // Render module buttons
        for (ModuleButton button : moduleButtons) {
            if (button.y >= 60 && button.y < height - 20) {
                button.render(context, mouseX, mouseY, delta);
            }
        }
        
        // Render back button
        if (width > categoryPanelWidth + 100) {
            ButtonWidget backButton = ButtonWidget.builder(
                Text.literal("← Back"),
                btn -> {
                    NovaClient.getInstance().getConfigManager().saveConfig();
                    assert client != null;
                    client.setScreen(parent);
                }
            ).dimensions(width - 110, height - 40, 100, 30).build();
            backButton.render(context, mouseX, mouseY, delta);
        }
        
        super.render(context, mouseX, mouseY, delta);
    }

    private void renderSpaceBackground(DrawContext context, int mouseX, int mouseY, float delta) {
        // Dark space gradient
        for (int i = 0; i < height; i++) {
            int color = interpolateColor(BG_COLOR, 0xFF1a1a3a, i * 255 / height);
            context.fill(0, i, width, i + 1, color);
        }
        
        // Draw stars (simple dots)
        long time = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            int starX = (int)((Math.sin(i * 123.456 + time * 0.0001) * 0.5 + 0.5) * width);
            int starY = (int)((Math.cos(i * 789.012 + time * 0.0002) * 0.5 + 0.5) * height);
            int brightness = (int)(128 + 127 * Math.sin(time * 0.005 + i));
            int starColor = (255 << 24) | (brightness << 16) | (brightness << 8) | brightness;
            context.fill(starX, starY, starX + 2, starY + 2, starColor);
        }
    }

    private int interpolateColor(int color1, int color2, float factor) {
        int a1 = (color1 >> 24) & 0xFF, r1 = (color1 >> 16) & 0xFF, g1 = (color1 >> 8) & 0xFF, b1 = color1 & 0xFF;
        int a2 = (color2 >> 24) & 0xFF, r2 = (color2 >> 16) & 0xFF, g2 = (color2 >> 8) & 0xFF, b2 = color2 & 0xFF;
        
        int a = (int)(a1 + (a2 - a1) * factor / 255f);
        int r = (int)(r1 + (r2 - r1) * factor / 255f);
        int g = (int)(g1 + (g2 - g1) * factor / 255f);
        int b = (int)(b1 + (b2 - b1) * factor / 255f);
        
        return (a << 24) | (r << 16) | (g << 8) | b;
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        scrollOffset = Math.max(0, scrollOffset - (int)(verticalAmount * 20));
        updateModuleButtons();
        return true;
    }

    private class ModuleButton {
        public int x, y, width, height;
        public Module module;
        public Runnable onClick;
        
        public ModuleButton(int x, int y, int width, int height, Module module, Runnable onClick) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.module = module;
            this.onClick = onClick;
        }
        
        public void render(DrawContext context, int mouseX, int mouseY, float delta) {
            boolean hovered = mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
            int bgColor = hovered ? BUTTON_HOVER : BUTTON_COLOR;
            
            // Button background with rounded corners effect
            context.fill(x, y, x + width, y + height, bgColor);
            
            // Border
            context.drawHorizontalLine(x, x + width, y, 0xFF4a4a8a);
            context.drawHorizontalLine(x, x + width, y + height - 1, 0xFF4a4a8a);
            context.drawVerticalLine(x, y, y + height, 0xFF4a4a8a);
            context.drawVerticalLine(x + width - 1, y, y + height, 0xFF4a4a8a);
            
            // Module name
            context.drawTextWithShadow(textRenderer, module.getName(), x + 10, y + 8, 0xFFFFFF);
            
            // Enabled/Disabled status
            String status = module.isEnabled() ? "ON" : "OFF";
            int statusColor = module.isEnabled() ? ENABLED_COLOR : DISABLED_COLOR;
            context.drawTextWithShadow(textRenderer, status, x + width - 50, y + 12, statusColor);
            
            // Description
            context.drawText(textRenderer, module.getDescription(), x + 10, y + 24, 0xFFAAAAAA);
        }
        
        public boolean mouseClicked(double mouseX, double mouseY, int button) {
            if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
                onClick.run();
                return true;
            }
            return false;
        }
    }
    
    private class CategoryButton extends ButtonWidget {
        private final ModuleCategory category;
        private final boolean isSelected;
        
        public CategoryButton(int x, int y, int width, int height, ModuleCategory category, PressAction action, boolean isSelected) {
            super(x, y, width, height, Text.literal(category.getDisplayName()), action, DEFAULT_NARRATION_SUPPLIER);
            this.category = category;
            this.isSelected = isSelected;
        }
        
        @Override
        public void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
            int bgColor = isSelected ? CATEGORY_SELECTED : CATEGORY_NORMAL;
            boolean hovered = mouseX >= getX() && mouseX <= getX() + width && mouseY >= getY() && mouseY <= getY() + height;
            
            if (hovered && !isSelected) {
                bgColor = 0x603a3a6a;
            }
            
            context.fill(getX(), getY(), getX() + width, getY() + height, bgColor);
            
            // Selection indicator
            if (isSelected) {
                context.fill(getX(), getY(), getX() + 4, getY() + height, ENABLED_COLOR);
            }
            
            context.drawTextWithShadow(textRenderer, getMessage().getString(), getX() + 15, getY() + 11, 0xFFFFFF);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (ModuleButton mb : moduleButtons) {
            if (mb.mouseClicked(mouseX, mouseY, button)) {
                return true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}
