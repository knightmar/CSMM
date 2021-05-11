package fr.knightmar.csmm.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockReinforcedStone extends Block {

    public BlockReinforcedStone() {
        super(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(-1f, 3600000.0F).noDrops());
    }
}
