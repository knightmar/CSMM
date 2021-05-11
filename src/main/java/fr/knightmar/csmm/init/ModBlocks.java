package fr.knightmar.csmm.init;

import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.blocks.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {



    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

    public static final RegistryObject<Block> BRONZE_BLOCK = createBlock("bronze_block", BlockBronze::new);
    public static final RegistryObject<Block> TEMP_BLOCK = createBlock("temp_block", BlockTemp::new );
    public static final RegistryObject<Block> REINFORCED_STONE = createBlock("reinforced_stone" , BlockReinforcedStone::new);
    public static final RegistryObject<Block> BRONZE_ORE = createBlock("bronze_ore", BlockBronzeOre::new);
    public static final RegistryObject<Block> SOAP_BLOCK = createBlock("soap_block", BlockSoap::new);
    public static final RegistryObject<Block> PLATINIUM_BLOCK = createBlock("platinium_block", PlatininumBlock::new);
    public static final RegistryObject<Block> LIGHT_BLOCK = createBlock("light_block",LightBlock::new);

    public static final RegistryObject<Block> PLATINIUM_GRASS = createBlock("platinium_grass", PlatininumGrass::new);
    public static final RegistryObject<Block> PLATINIUM_STONE = createBlock("platinium_stone", PlatininumStone::new);

    //public static final RegistryObject<FlowingFluidBlock> PLATINUM_FLOWING = new FlowingFluidBlock(() -> ModFluids.PLATINIUM_WATER, AbstractBlock.Properties.create(Material.WATER).doesNotBlockMovement().noDrops());

    public static final RegistryObject<Block> MANDRAGORE_CROP = BLOCKS.register("mandragore_crop", () -> new MandragoreCrop(AbstractBlock.Properties.from(Blocks.WHEAT)));



    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties().group(Main.BLOCKS)));
        return block;
    }
}

