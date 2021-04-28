package fr.knightmar.csmm.event;

import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.gui.TestGui;
import fr.knightmar.csmm.utils.KeyBoard;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID,value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent e){
        if (KeyBoard.GUI.isPressed()){
            Minecraft.getInstance().displayGuiScreen(new TestGui());
        }

    }
//    @SubscribeEvent
//    public static void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
//        Minecraft.getInstance().fontRenderer.drawTextWithShadow(event.getMatrixStack(),new TranslationTextComponent("overlay.test"),0,0,0x000000);
//    }
}
