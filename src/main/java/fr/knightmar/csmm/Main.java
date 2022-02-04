package fr.knightmar.csmm;


import fr.knightmar.csmm.data.capability.CoinCapability;
import fr.knightmar.csmm.event.ArmorEvent;
import fr.knightmar.csmm.event.ClientEvents;
import fr.knightmar.csmm.event.CommonEvents;
import fr.knightmar.csmm.init.*;
import fr.knightmar.csmm.network.Network;
import fr.knightmar.csmm.utils.KeyBoard;
import fr.knightmar.csmm.utils.ModSpawnEggItem;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

@Mod(Main.MODID)
public class Main {

    public static final String MODID = "csmm";
    public static final CreativeModeTab blocks = new CreativeModeTab("blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.TEMP_BLOCK.get());
        }
    };
    public static final CreativeModeTab items = new CreativeModeTab("items") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BRONZE_INGOT.get());
        }
    };

    public Main() {

        GeckoLib.initialize();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::setup);
        bus.addListener(this::clientSetup);

        ModBlocks.BLOCKS.register(bus);
        ModItems.ITEMS.register(bus);
        ModSounds.SOUNDS.register(bus);
        ModTileEntities.TILE_ENTITIES.register(bus);
        ModEntityType.ENTITY_TYPES.register(bus);
        ModFluids.FLUIDS.register(bus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new ArmorEvent());
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(CoinCapability.class);
        MinecraftForge.EVENT_BUS.register(CommonEvents.class);
        MinecraftForge.EVENT_BUS.register(ClientEvents.class);
        Network.registerNetworkPackets();

    }

    private void clientSetup(final FMLClientSetupEvent event) {
        KeyBoard.register();
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POLLENIUM_CROPS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POLLENIUM_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.HEAL_FLUID.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.HEAL_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.HEAL_FLOWING.get(), RenderType.translucent());
    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }


}
