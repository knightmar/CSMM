package fr.knightmar.csmm;


import fr.knightmar.csmm.init.*;
import fr.knightmar.csmm.network.Network;
import fr.knightmar.csmm.utils.KeyBoard;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
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



    public Main() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();


        bus.addListener(this::setup);
        bus.addListener(this::clientSetup);

        ModSounds.SOUNDS.register(bus);
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModTileEntities.TILE_ENTITIES.register(bus);
        ModEntityType.ENTITY_TYPES.register(bus);


        MinecraftForge.EVENT_BUS.register(this);

        Network.registerNetworkPackets();





    }



    private void setup(final FMLCommonSetupEvent event) {


        ModFeatures features = new ModFeatures();
        features.init();
        MinecraftForge.EVENT_BUS.register(features);

    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
        KeyBoard.register();
    }


    public void onServerStarting(FMLServerStartingEvent event){

    }

}
