package fr.knightmar.csmm.blocks;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;


public class BlockBronzeOre extends Block {
    public BlockBronzeOre() {
        super(Block.Properties.of(Material.STONE).strength(3f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops());


    }


}
