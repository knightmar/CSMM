package fr.knightmar.csmm.blocks;

import fr.knightmar.csmm.tileentity.TileEntityLight;
import fr.knightmar.csmm.tileentity.TileEntityTemp;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class LightBlock extends Block {
    public float isLight = 0;

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }


    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityLight();
    }


    public LightBlock() {
        super(AbstractBlock.Properties.create(Material.REDSTONE_LIGHT).hardnessAndResistance(2.8F,2.8F).harvestTool(ToolType.PICKAXE));

    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        if (worldIn.getTileEntity(pos) instanceof TileEntityTemp){






            TileEntityTemp te = (TileEntityTemp) worldIn.getTileEntity(pos);
            player.sendStatusMessage(new StringTextComponent("Counter : " + te.getCounter()), true);
            return ActionResultType.SUCCESS;
        }


        return ActionResultType.PASS;
    }

}
