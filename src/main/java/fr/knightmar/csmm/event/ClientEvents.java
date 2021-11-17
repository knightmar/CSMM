package fr.knightmar.csmm.event;

import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.client.gui.TestGui;
import fr.knightmar.csmm.init.ModItems;
import fr.knightmar.csmm.utils.KeyBoard;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.gui.screen.Screen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.gui.GuiUtils;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID, value = Dist.CLIENT)
public class ClientEvents {


    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent e) {
        if (KeyBoard.GUI.isDown()) {
            Minecraft.getInstance().setScreen(new TestGui());
        }
        if (KeyBoard.BACKPACK.isDown()) {
            if (ModItems.backpackIsUsed.equals("true")) {
                System.out.println("test");

            } else {
                System.out.println("no you can't");

            }
        }
    }

    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        Minecraft.getInstance().font.draw(event.getMatrixStack(), ModItems.backpackIsUsed, 0, 0, 0);
    }
}


