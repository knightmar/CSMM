package fr.knightmar.csmm.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class PlatininumStone extends Block {
    public PlatininumStone() {
        super(AbstractBlock.Properties.of(Material.STONE).strength(3F, 7F).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops());
    }
}
