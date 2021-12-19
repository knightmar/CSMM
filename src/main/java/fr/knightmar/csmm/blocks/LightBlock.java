package fr.knightmar.csmm.blocks;

//import fr.knightmar.csmm.tileentity.TileEntityLight;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;

public class LightBlock extends Block {
    public static final BooleanProperty INVERTED = BlockStateProperties.INVERTED;


    public LightBlock() {
        super(Block.Properties.of(Material.GLASS).strength(2.8F, 2.8F).harvestTool(ToolType.PICKAXE));
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
    public ActionResultType use(BlockState state, Level worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (worldIn.isClientSide) {

            return ActionResultType.SUCCESS;
        } else {
            worldIn.setBlock(pos, state.cycle(INVERTED), 3);
            player.displayClientMessage(new StringTextComponent("state : " + !state.getValue(INVERTED)), true);
            return ActionResultType.CONSUME;

        }
    }
}

