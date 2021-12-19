package fr.knightmar.csmm.blocks;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class PlatininumStone extends Block {
    public PlatininumStone() {
        super(Block.Properties.of(Material.STONE).strength(3F, 7F).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops());
    }
}
