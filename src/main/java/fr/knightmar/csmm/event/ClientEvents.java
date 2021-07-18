package fr.knightmar.csmm.event;

import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.client.gui.TestGui;
import fr.knightmar.csmm.init.ModItems;
import fr.knightmar.csmm.utils.KeyBoard;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID, value = Dist.CLIENT)
public class ClientEvents {


    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent e) {
        if (KeyBoard.GUI.isPressed()) {
            Minecraft.getInstance().displayGuiScreen(new TestGui());
        }
        if (KeyBoard.BACKPACK.isPressed()) {
            if (ModItems.backpackIsUsed.equals("true")) {
                System.out.println("test");

            } else {
                System.out.println("no you can't");

            }
        }
    }


    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), ModItems.backpackIsUsed, 0, 0, 0);
    }

}


