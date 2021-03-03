package fr.knightmar.csmm.tileentity;

import fr.knightmar.csmm.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLight extends TileEntity {

    private int isOn = 0;



    public TileEntityLight() {
        super(ModTileEntities.LIGHT_TILE_ENTITY.get());
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);

        this.setState(nbt.getInt("state"));
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);

        compound.putInt("state", this.getState());

        return compound;
    }

    public void tick() {

    }


    public int getState() {
        return isOn;
    }

    public void setState(int isOn) {
        this.isOn = isOn;
    }
}