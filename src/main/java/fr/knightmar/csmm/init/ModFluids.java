package fr.knightmar.csmm.init;

import fr.knightmar.csmm.Main;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluids {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUID = DeferredRegister.create(ForgeRegistries.FLUIDS, Main.MODID);


    public static final RegistryObject<FlowingFluid> HEAL_FLUID = FLUID.register("heal_fluid",()-> new ForgeFlowingFluid.Source(ModFluids.HEAL_PROPERTIES));
    public static final RegistryObject<FlowingFluid> HEAL_FLOWING = FLUID.register("heal_flowing",()-> new ForgeFlowingFluid.Flowing(ModFluids.HEAL_PROPERTIES));


    public static final ForgeFlowingFluid.Properties HEAL_PROPERTIES = new ForgeFlowingFluid.Properties(()-> HEAL_FLUID.get(), ()-> HEAL_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
            .density(10)
            .luminosity(4)
            .viscosity(6)
            .overlay(WATER_OVERLAY_RL)
            .color(0xc35ec5d0)
    )
            .slopeFindDistance(20)
            .levelDecreasePerBlock(1)
            .block(()->ModFluids.HEAL_BLOCK.get()).bucket(()-> ModItems.HEAL_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> HEAL_BLOCK = ModBlocks.BLOCKS.register("heal_block",()-> new FlowingFluidBlock(()-> ModFluids.HEAL_FLUID.get(), AbstractBlock.Properties.of(Material.WATER).noCollission().strength(100f).noDrops()));




    public static void register(IEventBus eventBus){
        FLUID.register(eventBus);
    }
}
