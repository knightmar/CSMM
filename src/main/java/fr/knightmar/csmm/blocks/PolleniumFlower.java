package fr.knightmar.csmm.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class PolleniumFlower extends HorizontalBlock {
    public PolleniumFlower(Properties p_i48377_1_) {
        super(p_i48377_1_);
    }

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(7, 0, 7, 8, 5, 8),
            Block.box(8, 4, 7, 9, 7, 8),
            Block.box(8, 6, 7, 9, 7, 8),
            Block.box(8, 7, 7, 9, 8, 8),
            Block.box(4, 9, 7, 4, 12, 8),
            Block.box(8, 9, 3, 9, 12, 3),
            Block.box(13, 9, 7, 13, 12, 8),
            Block.box(8, 9, 12, 9, 12, 12),
            Block.box(7, 7, 7, 10, 7, 8),
            Block.box(7, 7, 5, 9, 7, 6),
            Block.box(8, 7, 6, 9, 7, 9),
            Block.box(0, 7, 9, 2, 7, 11)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();




    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }
}
