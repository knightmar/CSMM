package fr.knightmar.csmm.blocks;


import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class HomeBlock extends Block {
    public HomeBlock() {
        super(AbstractBlock.Properties.of(Material.METAL).strength(5f, 1000000f).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops());
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
    public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        player.getPersistentData().remove("home_x");
        player.getPersistentData().remove("home_y");
        player.getPersistentData().remove("home_z");
        super.playerWillDestroy(worldIn, pos, state, player);
    }


}
