package com.example.zoommod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ZoomMod implements ModInitializer {
    public static final String MOD_ID = "zoommod";

    public static final Item THUNDER_HAMMER = Registry.register(
            Registries.ITEM,
            Identifier.of(MOD_ID, "thunder_hammer"),
            new SwordItem(ToolMaterials.NETHERITE, 6, -2.9f, new Item.Settings().maxCount(1))
    );

    @Override
    public void onInitialize() {
        // Регистрируем предмет на старте мода.
    }
}
