package fr.knightmar.csmm.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class BlockReinforcedStone extends Block {

    public BlockReinforcedStone() {
        super(Block.Properties.of(Material.METAL).strength(-1f, 3600000.0F).noDrops());
    }
}
