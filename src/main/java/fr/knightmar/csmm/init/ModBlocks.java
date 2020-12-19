package fr.knightmar.csmm.init;

import fr.knightmar.csmm.CSMM;
import fr.knightmar.csmm.blocks.BlockCopper;
import fr.knightmar.csmm.blocks.BlockCopperOre;
import fr.knightmar.csmm.blocks.BlockReinforced_stone;
import fr.knightmar.csmm.blocks.BlockTemp;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {



    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CSMM.MODID);

    public static final RegistryObject<Block> COPPER_BLOCK = createBlock("copper_block", BlockCopper::new);
    public static final RegistryObject<Block> TEMP_BLOCK = createBlock("temp_block", BlockTemp::new );
    public static final RegistryObject<Block> REINFORCED_STONE = createBlock("reinforced_stone" , BlockReinforced_stone::new);
    public static final RegistryObject<Block> COPPER_ORE = createBlock("copper_ore", BlockCopperOre::new);





    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties().group(CSMM.BLOCkS)));
        return block;
    }
}

