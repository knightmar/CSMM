package fr.knightmar.csmm.tileentity;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TileEntityLight extends TileEntity {
    private boolean isLight = false;


    public TileEntityLight(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }


}
