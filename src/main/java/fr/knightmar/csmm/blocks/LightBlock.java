package fr.knightmar.csmm.blocks;

//import fr.knightmar.csmm.tileentity.TileEntityLight;


import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class LightBlock extends Block {
    public static final BooleanProperty INVERTED = BlockStateProperties.INVERTED;


    public LightBlock() {
        super(Block.Properties.of(Material.GLASS).strength(2.8F, 2.8F));
        this.registerDefaultState(this.stateDefinition.any().setValue(INVERTED, Boolean.TRUE));

    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(INVERTED);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {

            return InteractionResult.SUCCESS;
        } else {
            pLevel.setBlock(pPos, pState.cycle(INVERTED), 3);
            pPlayer.displayClientMessage(new TextComponent("state : " + !pState.getValue(INVERTED)), true);
            return InteractionResult.CONSUME;

        }
    }
}

