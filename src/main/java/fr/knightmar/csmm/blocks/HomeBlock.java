package fr.knightmar.csmm.blocks;



import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;


public class HomeBlock extends Block {
    public HomeBlock() {
        super(Block.Properties.of(Material.METAL).strength(5f, 1000000f).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops());
    }

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        player.getPersistentData().putInt("home_x", pos.getX());
        player.getPersistentData().putInt("home_y", pos.getY() + 1);
        player.getPersistentData().putInt("home_z", pos.getZ());
        player.displayClientMessage(new StringTextComponent("Home mis aux positions : x=" + player.getPersistentData().getInt("home_x") + " y=" + player.getPersistentData().getInt("home_y") + " z=" + player.getPersistentData().getInt("home_z")), true);
        return super.use(state, worldIn, pos, player, handIn, hit);
    }

    @Override
    public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        player.getPersistentData().remove("home_x");
        player.getPersistentData().remove("home_y");
        player.getPersistentData().remove("home_z");
        super.playerWillDestroy(worldIn, pos, state, player);
    }


}
