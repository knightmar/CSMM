package fr.knightmar.csmm.tileentity;

import fr.knightmar.csmm.init.ModTileEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TileEntityTemp extends BlockEntity {
    private int counter = 0;

    public TileEntityTemp(BlockPos pos, BlockState state){
        super(ModTileEntities.TEMP_TILE_ENTITY.get(), pos, state);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);

        this.setCounter(nbt.getInt("counter"));
    }
    @Override
    public void saveAdditional(CompoundTag compound) {
        super.saveAdditional(compound);
        compound.putInt("counter", this.getCounter());
    }


    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    public static void tick(Level level, BlockPos pos, BlockState state, TileEntityTemp blockEntity){
        blockEntity.setCounter(blockEntity.getCounter() + 1);
    }
}