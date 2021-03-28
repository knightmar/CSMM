/*package fr.knightmar.csmm.blocks;

import fr.knightmar.csmm.tileentity.TileEntityLight;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class LightBlock extends Block {
    private String message;
    private Boolean currentState = null;
    private boolean thisState;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public LightBlock() {
        super(AbstractBlock.Properties.create(Material.REDSTONE_LIGHT).hardnessAndResistance(2.8F,2.8F).harvestTool(ToolType.PICKAXE));

    }
    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityLight();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        if (worldIn.getTileEntity(pos) instanceof TileEntityLight){
            TileEntityLight te = (TileEntityLight) worldIn.getTileEntity(pos);

            if (thisState) {
                thisState = false;

            }else {
                thisState = true;
            }

            player.sendStatusMessage(new StringTextComponent("Statut : " + thisState), true);

        }

        return ActionResultType.PASS;

    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isRemote) {
            BlockState blockstate1 = state.func_235896_a_(POWERED);
            return ActionResultType.SUCCESS;
        }
        player.sendStatusMessage(new StringTextComponent("Statut : " + POWERED), true);
        return ActionResultType.CONSUME;
    }
}

*/