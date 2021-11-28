package fr.knightmar.csmm.init;

import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.fluids.ModFluidBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Rarity;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
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


    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, Main.MODID);



    public static final RegistryObject<FlowingFluid> HEAL_FLUID
            = FLUIDS.register("heal_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.HEAL_PROPERTIES));

    public static final RegistryObject<FlowingFluid> HEAL_FLOWING
            = FLUIDS.register("heal_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.HEAL_PROPERTIES));


    public static final ForgeFlowingFluid.Properties HEAL_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> ModFluids.HEAL_FLUID.get(), () -> ModFluids.HEAL_FLOWING.get(),
            FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL).overlay(WATER_OVERLAY_RL).rarity(Rarity.RARE)
                    .luminosity(6).density(1).viscosity(1).temperature(300).color(0xFF2AC8F2).sound(SoundEvents.WATER_AMBIENT)
                    .sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY)).slopeFindDistance(8).levelDecreasePerBlock(2)
            .canMultiply().explosionResistance(100.0F).tickRate(5).block(() -> ModFluids.HEAL_BLOCK.get())
            .bucket(() -> ModItems.HEAL_BUCKET.get());

    public static final RegistryObject<FlowingFluidBlock> HEAL_BLOCK = ModBlocks.BLOCKS.register("oil",
            () -> new FlowingFluidBlock(() -> ModFluids.HEAL_FLUID.get(), AbstractBlock.Properties.of(Material.WATER)
                    .noCollission().strength(100f).noDrops()));

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
