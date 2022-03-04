package fr.knightmar.csmm.utils;


import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBoard {
    public static final KeyMapping GUI = new KeyMapping("key.gui", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_K, "key.categories.gui");
    public static final KeyMapping BACKPACK = new KeyMapping("key.backpack", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_B, "key.categories.gui");

    public static void register() {
        ClientRegistry.registerKeyBinding(GUI);
    }

}