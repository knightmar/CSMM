package fr.knightmar.csmm.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class LightBlock extends Block {
    public float isLight = 0;


    public LightBlock() {
        super(AbstractBlock.Properties.create(Material.REDSTONE_LIGHT).hardnessAndResistance(2.8F,2.8F).harvestTool(ToolType.PICKAXE));

    }


}
