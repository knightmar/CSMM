package fr.knightmar.csmm.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class PlatininumBlock extends Block {

    public PlatininumBlock() {
        super(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(5F,10F).harvestTool(ToolType.PICKAXE).harvestLevel(4).setRequiresTool().setRequiresTool());
    }
}
