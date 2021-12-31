package fr.knightmar.csmm.event;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.data.capability.CoinOverlay;
import fr.knightmar.csmm.entities.render.CrocoRenderer;
import fr.knightmar.csmm.init.ModEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class ClientListener {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityType.CROCO.get(), CrocoRenderer::new);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onOverlaysRendered(RenderGameOverlayEvent.Text event){
        PoseStack matrixStack = event.getMatrixStack();
        CoinOverlay.render(matrixStack);
    }
}
