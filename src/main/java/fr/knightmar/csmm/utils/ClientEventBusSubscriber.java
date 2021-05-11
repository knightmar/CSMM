package fr.knightmar.csmm.utils;


import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.client.entity.render.CrocoRenderer;
import fr.knightmar.csmm.client.entity.render.HogRenderer;
import fr.knightmar.csmm.client.entity.render.TestRenderer;
import fr.knightmar.csmm.init.ModEntityType;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityType.HOG.get(), HogRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityType.TEST.get(), TestRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityType.CROCO.get(), CrocoRenderer::new);


    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }
}
