package fr.knightmar.csmm.utils;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public class KeyBoard {
    public static final KeyBinding GUI = new KeyBinding("key.gui", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_K, "key.categories.gui");
    public static final KeyBinding BACKPACK = new KeyBinding("key.backpack", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_B, "key.categories.gui");
    public static void register()
    {
        ClientRegistry.registerKeyBinding(GUI);
    }

}