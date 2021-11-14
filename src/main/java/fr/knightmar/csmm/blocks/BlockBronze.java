package fr.knightmar.csmm.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;


public class BlockBronze extends Block {
    public BlockBronze() {
        super(AbstractBlock.Properties.of(Material.METAL).strength(3f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops());
    }
}


