package fr.knightmar.csmm.blocks;


import fr.knightmar.csmm.tileentity.TileEntityTemp;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;


import javax.annotation.ParametersAreNonnullByDefault;


public class BlockTemp extends Block {


    public BlockTemp() {
        super(Block.Properties.of(Material.METAL).strength(5f, 20f).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops());

    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }


    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityTemp();
    }

    @ParametersAreNonnullByDefault
    @Override
    public ActionResultType use(BlockState state, Level level, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        if (level.getBlockEntity(pos) instanceof TileEntityTemp) {

            TileEntityTemp te = (TileEntityTemp) level.getBlockEntity(pos);
            assert te != null;
            player.displayClientMessage(new StringTextComponent("Counter : " + te.getCounter()), true);
            return ActionResultType.SUCCESS;
        }


        return ActionResultType.PASS;
    }
}
