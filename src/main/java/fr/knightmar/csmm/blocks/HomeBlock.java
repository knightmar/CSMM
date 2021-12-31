package fr.knightmar.csmm.blocks;



import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;


public class HomeBlock extends Block {
    public HomeBlock() {
        super(Block.Properties.of(Material.METAL).strength(5f, 1000000f).requiresCorrectToolForDrops());
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        pPlayer.getPersistentData().putInt("home_x", pPos.getX());
        pPlayer.getPersistentData().putInt("home_y", pPos.getY() + 1);
        pPlayer.getPersistentData().putInt("home_z", pPos.getZ());
        pPlayer.displayClientMessage(new TextComponent("Home mis aux positions : x=" + pPlayer.getPersistentData().getInt("home_x") + " y=" + pPlayer.getPersistentData().getInt("home_y") + " z=" + pPlayer.getPersistentData().getInt("home_z")), true);
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public void playerWillDestroy(Level worldIn, BlockPos pos, BlockState state, Player player) {
        player.getPersistentData().remove("home_x");
        player.getPersistentData().remove("home_y");
        player.getPersistentData().remove("home_z");
        super.playerWillDestroy(worldIn, pos, state, player);
    }
}
