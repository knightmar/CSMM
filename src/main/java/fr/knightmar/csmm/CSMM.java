package fr.knightmar.csmm;


import fr.knightmar.csmm.entities.CrocoEntity;
import fr.knightmar.csmm.entities.HogEntity;
import fr.knightmar.csmm.init.*;
/*import fr.knightmar.csmm.init.ModFeatures;*/
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CSMM.MODID)
public class CSMM {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "csmm";

    public static final ItemGroup BLOCkS = new ItemGroup("BLOCKS") {
        @Override
        public ItemStack createIcon() { return new ItemStack(ModBlocks.TEMP_BLOCK.get()); }
    };

    public static final ItemGroup ITEMS = new ItemGroup("ITEMS") {
        @Override
        public ItemStack createIcon() { return new ItemStack(ModItems.COPPER_INGOT.get()); }
    };



    public CSMM() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModTileEntities.TILE_ENTITIES.register(bus);
        ModEntityType.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
        //MinecraftForge.EVENT_BUS.addListener(this::onBiomeLoading);


    }

    /*public void onBiomeLoading(BiomeLoadingEvent event){
        if(event.getName().equals(Biomes.PLAINS.getLocation())){

            event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModFeatures.DIAMOND_BLOCK);

        }
    }*/

    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityType.HOG.get(), HogEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityType.CROCO.get(), CrocoEntity.setCustomAttributes().create());
        });

        ModFeatures features = new ModFeatures();
        features.init();
        MinecraftForge.EVENT_BUS.register(features);

    }

    private void clientSetup(final FMLClientSetupEvent event)
    {

    }

}
