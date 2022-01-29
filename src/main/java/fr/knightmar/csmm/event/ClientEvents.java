package fr.knightmar.csmm.event;

import fr.knightmar.csmm.client.gui.TestGui;
import fr.knightmar.csmm.utils.KeyBoard;
import fr.knightmar.csmm.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ClientEvents {
    @OnlyIn(Dist.CLIENT)
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
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
        Minecraft.getInstance().font.draw(event.getMatrixStack(), ModItems.backpackIsUsed, 0, 0, 0);
    }


}


