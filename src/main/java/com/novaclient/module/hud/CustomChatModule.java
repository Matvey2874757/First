package com.novaclient.module.hud;

import com.novaclient.module.Module;

public class CustomChatModule extends Module {
    public float chatOpacity = 1.0f;
    public int chatBackgroundColor = 0x80000000;
    public boolean filterProfanity = false;
    
    public CustomChatModule() {
        super("custom_chat", "Custom Chat", "Customize chat appearance and filtering", Category.HUD);
    }
}
