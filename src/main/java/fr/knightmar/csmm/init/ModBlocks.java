package fr.knightmar.csmm.init;

import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.blocks.BlockTemp;
import fr.knightmar.csmm.blocks.HomeBlock;
import fr.knightmar.csmm.blocks.LightBlock;
import fr.knightmar.csmm.blocks.PolleniumFlower;
import fr.knightmar.csmm.others.PolleniumCrops;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {


    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

    public static final RegistryObject<Block> BRONZE_BLOCK = createBlock("bronze_block", () -> new Block(Block.Properties.of(Material.METAL).strength(3f, 15f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TEMP_BLOCK = createBlock("temp_block", BlockTemp::new);
    public static final RegistryObject<Block> REINFORCED_STONE = createBlock("reinforced_stone", () -> new Block(Block.Properties.of(Material.METAL).strength(-1f, 3600000.0F).noDrops()));
    public static final RegistryObject<Block> BRONZE_ORE = createBlock("bronze_ore", () -> new Block(Block.Properties.of(Material.STONE).strength(3f, 15f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SOAP_BLOCK = createBlock("soap_block", () -> new Block(Block.Properties.of(Material.ICE).strength(2.8F).friction(1.1F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PLATINIUM_BLOCK = createBlock("platinium_block", () -> new Block(Block.Properties.of(Material.METAL).strength(5F, 10F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LIGHT_BLOCK = createBlock("light_block", LightBlock::new);
    public static final RegistryObject<Block> PLATINIUM_GRASS = createBlock("platinium_grass", () -> new Block(Block.Properties.of(Material.GRASS).strength(1F, 1F)));
    public static final RegistryObject<Block> PLATINIUM_STONE = createBlock("platinium_stone", () -> new Block(Block.Properties.of(Material.STONE).strength(3F, 7F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PLATINIUM_ORE = createBlock("platinium_ore", () -> new Block(Block.Properties.of(Material.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> HOME_BLOCK = createBlock("home_block", HomeBlock::new);
    public static final RegistryObject<Block> POLLENIUM_CROPS = BLOCKS.register("pollenium_crop", () -> new PolleniumCrops(Block.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> POLLENIUM_FLOWER = createBlock("pollenium_flower", PolleniumFlower::new);

    public static final RegistryObject<Block> PLATINIUM_BRICKS = createBlock("platinium_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRACKED_PLATINIUM_BRICKS = createBlock("cracked_platinium_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CHISELED_PLATINIUM_BRICKS = createBlock("chiseled_platinium_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_PLATINIUM_BRICKS = createBlock("smooth_platinium_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PLATINIUM_STAIRS = createBlock("platinium_stairs", () -> new StairBlock(PLATINIUM_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.METAL).strength(1.5F,6.0F)));


    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier) {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(Main.blocks)));
        return block;
    }
}

