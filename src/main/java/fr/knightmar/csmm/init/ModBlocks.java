package fr.knightmar.csmm.init;

import fr.knightmar.csmm.CSMM;
import fr.knightmar.csmm.blocks.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.GrassBlock;
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
    public static final RegistryObject<Block> SOAP_BLOCK = createBlock("soap_block", BlockSoap::new);
    public static final RegistryObject<Block> PLATINIUM_BLOCK = createBlock("platinium_block", PlatininumBlock::new);
    public static final RegistryObject<Block> LIGHT_BLOCK = createBlock("light_block",LightBlock::new);

    public static final RegistryObject<Block> PLATINUIUM_GRASS = createBlock("platinium_grass", PlatininumGrass::new);
    public static final RegistryObject<Block> PLATINUIUM_STONE = createBlock("platinium_stone", PlatininumStone::new);





    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties().group(CSMM.BLOCkS)));
        return block;
    }
}

