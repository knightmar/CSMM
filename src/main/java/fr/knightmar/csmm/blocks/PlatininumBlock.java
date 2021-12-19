package fr.knightmar.csmm.blocks;


import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;


public class PlatininumBlock extends Block {
    private static final ITextComponent CONTAINER_NAME = new TranslationTextComponent("container.test_container");


    public PlatininumBlock() {
        super(Block.Properties.of(Material.METAL).strength(5F, 10F).harvestTool(ToolType.PICKAXE).harvestLevel(4).requiresCorrectToolForDrops());
    }

}
