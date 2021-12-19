package fr.knightmar.csmm.blocks;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;


public class BlockBronze extends Block {
    public BlockBronze() {
        super(Block.Properties.of(Material.METAL).strength(3f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops());
    }
}


