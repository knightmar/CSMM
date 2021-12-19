package fr.knightmar.csmm.blocks;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;


public class BlockSoap extends Block {
    public BlockSoap() {
        super(Block.Properties.of(Material.ICE).strength(2.8F).friction(1.1F).requiresCorrectToolForDrops().harvestTool(ToolType.SHOVEL));
    }
}
