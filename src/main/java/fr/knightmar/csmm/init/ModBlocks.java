package fr.knightmar.csmm.init;

import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.blocks.*;
import fr.knightmar.csmm.others.PolleniumCrops;
<<<<<<< Updated upstream
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
=======

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fmllegacy.RegistryObject;
>>>>>>> Stashed changes
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {


    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

    public static final RegistryObject<Block> BRONZE_BLOCK = createBlock("bronze_block", BlockBronze::new);
    public static final RegistryObject<Block> TEMP_BLOCK = createBlock("temp_block", BlockTemp::new);
    public static final RegistryObject<Block> REINFORCED_STONE = createBlock("reinforced_stone", BlockReinforcedStone::new);
    public static final RegistryObject<Block> BRONZE_ORE = createBlock("bronze_ore", BlockBronzeOre::new);
    public static final RegistryObject<Block> SOAP_BLOCK = createBlock("soap_block", BlockSoap::new);
    public static final RegistryObject<Block> PLATINIUM_BLOCK = createBlock("platinium_block", PlatininumBlock::new);
    public static final RegistryObject<Block> LIGHT_BLOCK = createBlock("light_block", LightBlock::new);

    public static final RegistryObject<Block> PLATINIUM_GRASS = createBlock("platinium_grass", PlatininumGrass::new);
    public static final RegistryObject<Block> PLATINIUM_STONE = createBlock("platinium_stone", PlatininumStone::new);


    public static final RegistryObject<Block> PLATINIUM_ORE = createBlock("platinium_ore", () -> new Block(Block.Properties.of(Material.METAL).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().harvestLevel(3)));

    public static final RegistryObject<Block> HOME_BLOCK = createBlock("home_block", HomeBlock::new);

    //public static final RegistryObject<FlowingFluidBlock> PLATINIUM_FLOWING = new FlowingFluidBlock(() -> ModFluids.PLATINIUM_WATER, AbstractBlock.Properties.create(Material.WATER).doesNotBlockMovement().noDrops());

    public static final RegistryObject<Block> POLLENIUM_CROPS =
            BLOCKS.register("pollenium_crop", () -> new PolleniumCrops(Block.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> POLLENIUM_FLOWER = createBlock("pollenium_flower", ()-> new PolleniumFlower(AbstractBlock.Properties.copy(Blocks.DANDELION)));


    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier) {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(Main.blocks)));
        return block;
    }
}

