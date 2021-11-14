package fr.knightmar.csmm.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockReinforcedStone extends Block {

    public BlockReinforcedStone() {
        super(AbstractBlock.Properties.of(Material.METAL).strength(-1f, 3600000.0F).noDrops());
    }
}
