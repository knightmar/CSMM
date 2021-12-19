package fr.knightmar.csmm.utils;


import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.fmlclient.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

import javax.swing.text.JTextComponent;

public class KeyBoard {
    public static final JTextComponent.KeyBinding GUI = new JTextComponent.KeyBinding("key.gui", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_K, "key.categories.gui");
    public static final JTextComponent.KeyBinding BACKPACK = new JTextComponent.KeyBinding("key.backpack", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_B, "key.categories.gui");

    public static void register() {
        ClientRegistry.registerKeyBinding(GUI);
    }

}