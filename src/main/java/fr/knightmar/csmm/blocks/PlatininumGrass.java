package fr.knightmar.csmm.blocks;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class PlatininumGrass extends Block {
    public PlatininumGrass() {
        super(Block.Properties.of(Material.GRASS).strength(1F, 1F).harvestTool(ToolType.SHOVEL));

    }
}
