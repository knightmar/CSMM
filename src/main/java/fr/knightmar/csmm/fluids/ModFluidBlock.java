package fr.knightmar.csmm.fluids;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.ITag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class ModFluidBlock extends FlowingFluidBlock {
    public ITag.INamedTag<Fluid> fluidTag;
    public BlockState state;
    public World world;
    public BlockPos blockPos;
    public LivingEntity liventity;

    public ModFluidBlock(Supplier<? extends FlowingFluid> supplier, Properties properties, ITag.INamedTag<Fluid> fluidTag) {
        super(supplier, properties);
        this.fluidTag = fluidTag;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void entityInside(BlockState state, World world, BlockPos blockPos, Entity entity) {
        if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).addEffect(new EffectInstance(Effects.HEAL, 1, 0, false, false, false));
        }
    }


}