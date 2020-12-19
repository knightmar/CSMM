package fr.knightmar.csmm.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockReinforced_stone extends Block {

    public BlockReinforced_stone() {
        super(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(-1f, -1f).setRequiresTool());
    }
}
