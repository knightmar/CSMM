package fr.knightmar.csmm.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockBronzeOre extends Block {
    public BlockBronzeOre() {
        super(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(3f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool());


    }


}
