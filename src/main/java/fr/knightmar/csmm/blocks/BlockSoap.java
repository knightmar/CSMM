package fr.knightmar.csmm.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSoap extends Block {
    public BlockSoap() {
        super(AbstractBlock.Properties.create(Material.ICE).hardnessAndResistance(2.8F).slipperiness(1.1F));
    }
}
