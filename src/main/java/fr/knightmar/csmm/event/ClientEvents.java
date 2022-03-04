package fr.knightmar.csmm.event;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.realmsclient.RealmsMainScreen;
import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.client.gui.MainGui;
import fr.knightmar.csmm.client.gui.TestGui;
import fr.knightmar.csmm.data.capability.CoinOverlay;
import fr.knightmar.csmm.entities.render.CrocoRenderer;
import fr.knightmar.csmm.init.ModEntityType;
import fr.knightmar.csmm.utils.KeyBoard;
import fr.knightmar.csmm.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.ScreenOpenEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
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

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityType.CROCO.get(), CrocoRenderer::new);
    }

    @SubscribeEvent
    public static void onOverlaysRendered(RenderGameOverlayEvent.Text event) {
        PoseStack matrixStack = event.getMatrixStack();
        CoinOverlay.render(matrixStack);
    }

    @SubscribeEvent
    public void onOpenGui(ScreenOpenEvent event) {
        if (event.getScreen() != null) {
            if (event.getScreen().getClass() == TitleScreen.class) {
                event.setScreen(new MainGui());
            }
        }
    }

}


