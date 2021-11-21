package fr.knightmar.csmm.blocks;

//import fr.knightmar.csmm.tileentity.TileEntityLight;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class LightBlock extends Block {
    public static final BooleanProperty INVERTED = BlockStateProperties.INVERTED;


    public LightBlock() {
        super(AbstractBlock.Properties.of(Material.GLASS).strength(2.8F, 2.8F).harvestTool(ToolType.PICKAXE));
        this.registerDefaultState(this.stateDefinition.any().setValue(INVERTED, Boolean.TRUE));

    }

//    @Override
//    public boolean hasTileEntity(BlockState state) {
//        return true;
//    }

//    @Override
//    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
//        return new TileEntityLight();
//    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(INVERTED);
    }

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isClientSide) {

            return ActionResultType.SUCCESS;
        } else {
            worldIn.setBlock(pos, state.cycle(INVERTED), 3);
            player.displayClientMessage(new StringTextComponent("state : " + !state.getValue(INVERTED)), true);
            return ActionResultType.CONSUME;

        }
    }
}

