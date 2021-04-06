package fr.knightmar.csmm.blocks;

import fr.knightmar.csmm.tileentity.TileEntityLight;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.properties.BlockStateProperties;
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
    public static final BooleanProperty INVERTED = BlockStateProperties.INVERTED;


    public LightBlock() {
        super(AbstractBlock.Properties.create(Material.REDSTONE_LIGHT).hardnessAndResistance(2.8F, 2.8F).harvestTool(ToolType.PICKAXE));
        this.setDefaultState(this.stateContainer.getBaseState().with(INVERTED, Boolean.valueOf(false)));

    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityLight();
    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        boolean flag = state.get(INVERTED);
        if (player.isAllowEdit()) {
            if (worldIn.isRemote) {
                return ActionResultType.SUCCESS;
            } else {
                BlockState blockstate = state.cycleValue(INVERTED);
                worldIn.setBlockState(pos, blockstate, 4);
                player.sendStatusMessage(new StringTextComponent("Counter : " + flag), true);
                return ActionResultType.CONSUME;
            }
        } else {
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
        }

    }




}

