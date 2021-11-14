package fr.knightmar.csmm.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockSoap extends Block {
    public BlockSoap() {
        super(AbstractBlock.Properties.of(Material.ICE).strength(2.8F).friction(1.1F).requiresCorrectToolForDrops().harvestTool(ToolType.SHOVEL));
    }
}
