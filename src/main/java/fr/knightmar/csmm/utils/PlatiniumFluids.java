//package fr.knightmar.csmm.utils;
//
//import fr.knightmar.csmm.init.ModFluids;
//import fr.knightmar.csmm.init.ModItems;
//import net.minecraft.block.BlockState;
//import net.minecraft.fluid.FlowingFluid;
//import net.minecraft.fluid.Fluid;
//import net.minecraft.fluid.FluidState;
//import net.minecraft.item.Item;
//import net.minecraft.util.Direction;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.IBlockReader;
//import net.minecraft.world.IWorld;
//import net.minecraft.world.IWorldReader;
//
//public abstract class PlatiniumFluids extends FlowingFluid {
//    @Override
//    public Fluid getFlowingFluid() {
//        return fr.knightmar.csmm.init.ModFluids.FLOWING_PLATINIUM_WATER;
//    }
//
//    @Override
//    public Fluid getStillFluid() {
//        return fr.knightmar.csmm.init.ModFluids.PLATINIUM_WATER;
//    }
//
//    @Override
//    protected boolean canSourcesMultiply() {
//        return true;
//    }
//
//    @Override
//    protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
//
//    }
//
//    @Override
//    protected int getSlopeFindDistance(IWorldReader worldIn) {
//        return 4;
//    }
//
//    @Override
//    protected int getLevelDecreasePerBlock(IWorldReader worldIn) {
//        return 15;
//    }
//
//    @Override
//    public Item getFilledBucket() {
//        return ModItems.PLATINIUM_WATER_BUCKET.get();
//    }
//
//    @Override
//    protected boolean canDisplace(FluidState fluidState, IBlockReader blockReader, BlockPos pos, Fluid fluid, Direction direction) {
//        return direction == Direction.DOWN && !fluid.isIn(ModFluids.Tags.PLATINUM_WATER);
//    }
//
//    @Override
//    public int getTickRate(IWorldReader p_205569_1_) {
//        return 25;
//    }
//
//    @Override
//    protected float getExplosionResistance() {
//        return 100.0f;
//    }
//
//    @Override
//    protected BlockState getBlockState(FluidState state) {
//        return null;
//    }
//
//
//}
//
