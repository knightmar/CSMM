package fr.knightmar.csmm;


import fr.knightmar.csmm.entities.CrocoEntity;
import fr.knightmar.csmm.entities.HogEntity;
import fr.knightmar.csmm.entities.TestEntity;
import fr.knightmar.csmm.event.ArmorEvent;
import fr.knightmar.csmm.init.*;
import fr.knightmar.csmm.network.Network;
import fr.knightmar.csmm.utils.KeyBoard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(Main.MODID)
public class Main {

    public static final String MODID = "csmm";
    public static final ItemGroup BLOCKS = new ItemGroup("blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.TEMP_BLOCK.get());
        }
    };
    public static final ItemGroup ITEMS = new ItemGroup("items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.BRONZE_INGOT.get());
        }
    };
    private static final Logger LOGGER = LogManager.getLogger();


    public Main() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();


        bus.addListener(this::setup);
        bus.addListener(this::onEntityAttributeCreation);
        bus.addListener(this::clientSetup);


        ModSounds.SOUNDS.register(bus);
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModTileEntities.TILE_ENTITIES.register(bus);
        ModEntityType.ENTITY_TYPES.register(bus);
        BiomeInit.BIOMES.register(bus);
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Main.MODID, "platinum_biome")), 5));


        MinecraftForge.EVENT_BUS.register(this);

        Network.registerNetworkPackets();


    }


    private void setup(final FMLCommonSetupEvent event) {


        ModFeatures features = new ModFeatures();
        features.init();
        MinecraftForge.EVENT_BUS.register(features);
        MinecraftForge.EVENT_BUS.register(new ArmorEvent());

    }

    public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(ModEntityType.HOG.get(), HogEntity.setCustomAttributes().create());
        event.put(ModEntityType.CROCO.get(), CrocoEntity.setCustomAttributes().create());
        event.put(ModEntityType.TEST.get(), TestEntity.setCustomAttributes().create());
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        KeyBoard.register();
        RenderTypeLookup.setRenderLayer(ModBlocks.POLLENIUM_CROPS.get(), RenderType.getCutout());

    }


    public void onServerStarting(FMLServerStartingEvent event) {

    }

}
