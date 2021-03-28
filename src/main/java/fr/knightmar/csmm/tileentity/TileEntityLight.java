/*package fr.knightmar.csmm.tileentity;

import fr.knightmar.csmm.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLight extends TileEntity {
    public boolean readState = false;
    public boolean toWriteState = false;




    public TileEntityLight() {
        super(ModTileEntities.LIGHT_TILE_ENTITY.get());
    }


    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        this.getState(nbt.getBoolean("toWriteState"));

    }

    public void getState(boolean read_state) { this.readState = read_state; }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putBoolean("State", setToWriteState(true));
        return super.write(compound);
    }

    public boolean getToWriteState() {
        return toWriteState;
    }

    public boolean setToWriteState(boolean toWriteState) {
        this.toWriteState = true;
        return toWriteState;
    }

}


 */