package fr.knightmar.csmm.fluids;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.Tag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.property.Properties;

import java.util.function.Supplier;

public class ModFluidBlock extends LiquidBlock {
    public Tag.Named<Fluid> fluidTag;
    public BlockState state;
    public Level level;
    public BlockPos blockPos;
    public LivingEntity liventity;

    public ModFluidBlock(Supplier<? extends FlowingFluid> supplier, Properties properties, Tag.Named<Fluid> fluidTag) {
        super(supplier, properties);
        this.fluidTag = fluidTag;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void entityInside(BlockState state, Level level, BlockPos blockPos, Entity entity) {
        if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 0, false, false, false));
        }
    }


}