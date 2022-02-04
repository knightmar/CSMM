package fr.knightmar.csmm.blocks;

import fr.knightmar.csmm.client.gui.LootBoxGui;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class LootBox extends Block {
    public LootBox() {
        super(Block.Properties.of(Material.METAL).strength(2.8F, 2.8F));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide()) {
            Minecraft.getInstance().setScreen(new LootBoxGui());

        }
        return InteractionResult.SUCCESS;
    }
}
