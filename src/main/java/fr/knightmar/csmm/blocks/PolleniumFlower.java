package fr.knightmar.csmm.blocks;


import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class PolleniumFlower extends FlowerBlock {
    public PolleniumFlower() {
        super(MobEffects.ABSORPTION,20*20,BlockBehaviour.Properties.copy(Blocks.DANDELION));
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
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
}
