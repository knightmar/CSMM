package fr.knightmar.csmm.init;

import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.fluids.ModFluidBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, Main.MODID);

    public static final ResourceLocation HEAL_STILL_RL = new ResourceLocation(Main.MODID, "block/heal_still");
    public static final ResourceLocation HEAL_FLOWING_RL = new ResourceLocation(Main.MODID, "block/heal_flowing");
    public static final ResourceLocation HEAL_OVERLAY_RL = new ResourceLocation(Main.MODID, "block/heal_overlay");
    public static final ResourceLocation HEAL_TAG_RL = new ResourceLocation(Main.MODID, "fluids/heal");

    public static final Tag.Named<Fluid> HEAL = FluidTags.createOptional(HEAL_TAG_RL);

    public static void init() {
    }    public static final RegistryObject<FlowingFluid> HEAL_FLUID = FLUIDS.register("heal_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.HEAL_PROPERTIES));

    public static final RegistryObject<FlowingFluid> HEAL_FLOWING = FLUIDS.register("heal_flowing",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.HEAL_PROPERTIES));

    public static final ForgeFlowingFluid.Properties HEAL_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> ModFluids.HEAL_FLUID.get(), () -> ModFluids.HEAL_FLOWING.get(),
            FluidAttributes.builder(HEAL_STILL_RL, HEAL_FLOWING_RL).overlay(HEAL_OVERLAY_RL).rarity(Rarity.RARE)
                    .luminosity(6).density(1).viscosity(2).temperature(300)/*.color(0x00FF00)*/.sound(SoundEvents.WATER_AMBIENT)
                    .sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY)).slopeFindDistance(3).levelDecreasePerBlock(1)
            .canMultiply().explosionResistance(100.0F).tickRate(5).block(() -> ModFluids.HEAL_BLOCK.get())
            .bucket(() -> ModItems.HEAL_BUCKET.get());

    public static final RegistryObject<LiquidBlock> HEAL_BLOCK = ModBlocks.BLOCKS.register("heal",
            () -> new ModFluidBlock(() -> ModFluids.HEAL_FLUID.get(), Block.Properties.of(Material.WATER)
                    .strength(100.0F).noDrops().speedFactor(0.5F).lightLevel((state) -> {
                        return 6;
                    }), ModFluids.HEAL));

}