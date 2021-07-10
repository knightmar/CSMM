package fr.knightmar.csmm.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class PlatininumGrass extends Block {
    public PlatininumGrass() {
        super(AbstractBlock.Properties.create(Material.ORGANIC).hardnessAndResistance(1F, 1F).harvestTool(ToolType.SHOVEL));

    }
}
