package fr.knightmar.csmm.blocks;


import fr.knightmar.csmm.init.ModTileEntities;
import fr.knightmar.csmm.tileentity.TileEntityTemp;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;


import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;


public class BlockTemp extends BaseEntityBlock {


    public BlockTemp() {
        super(Block.Properties.of(Material.METAL).strength(5f, 20f).requiresCorrectToolForDrops());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new TileEntityTemp(pPos, pState);
    }


    @ParametersAreNonnullByDefault
    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.getBlockEntity(pPos) instanceof TileEntityTemp) {
            TileEntityTemp te = (TileEntityTemp) pLevel.getBlockEntity(pPos);
            assert te != null;
            pPlayer.displayClientMessage(new TextComponent("Counter : " + te.getCounter()), true);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, ModTileEntities.TEMP_TILE_ENTITY.get(), TileEntityTemp::tick);    }
}
