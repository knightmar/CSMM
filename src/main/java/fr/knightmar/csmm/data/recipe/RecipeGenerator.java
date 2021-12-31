package fr.knightmar.csmm.data.recipe;

import fr.knightmar.csmm.init.ModBlocks;
import fr.knightmar.csmm.init.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.*;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;


import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {
    public RecipeGenerator(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        //Crafts items mod
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.PLATINIUM_ORE.get()), ModItems.PLATINIUM_INGOT.get(), 1f, 200)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.PLATINIUM_ORE.get().asItem()))
                .save(consumer);


        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.BRONZE_ORE.get()), ModItems.BRONZE_INGOT.get(), 0.5f, 200)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.BRONZE_ORE.get().asItem()))
                .save(consumer);


        ShapedRecipeBuilder.shaped(ModItems.BRONZE_STICK.get(), 4)
                .pattern("#")
                .pattern("#")
                .define('#', ModItems.BRONZE_INGOT.get())
                .group("sticks")
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BRONZE_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.BRONZE_SWORD.get(), 1)
                .pattern(" B ")
                .pattern(" B ")
                .pattern(" S ")
                .define('B', ModItems.BRONZE_INGOT.get())
                .define('S', ModItems.BRONZE_STICK.get())
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BRONZE_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.BRONZE_PICKAXE.get(), 1)
                .pattern("BBB")
                .pattern(" S ")
                .pattern(" S ")
                .define('B', ModItems.BRONZE_INGOT.get())
                .define('S', ModItems.BRONZE_STICK.get())
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BRONZE_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.BRONZE_AXE.get())
                .define('#', ModItems.BRONZE_STICK.get())
                .define('X', ModItems.BRONZE_INGOT.get())
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .unlockedBy("unlock", has(Items.DIAMOND))
                .save(consumer);


        ShapedRecipeBuilder.shaped(ModItems.BRONZE_SHOVEL.get(), 1)
                .pattern(" B ")
                .pattern(" S ")
                .pattern(" S ")
                .define('B', ModItems.BRONZE_INGOT.get())
                .define('S', ModItems.BRONZE_STICK.get())
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BRONZE_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.PLATINIUM_SWORD.get(), 1)
                .pattern(" B ")
                .pattern(" B ")
                .pattern(" S ")
                .define('B', ModItems.PLATINIUM_INGOT.get())
                .define('S', ModItems.BRONZE_STICK.get())
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PLATINIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.PLATINIUM_HELMET.get())
                .define('X', ModItems.PLATINIUM_INGOT.get())
                .pattern("XXX")
                .pattern("X X")
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PLATINIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.PLATINIUM_CHESTPLATE.get())
                .define('X', ModItems.PLATINIUM_INGOT.get())
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PLATINIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.PLATINIUM_LEGGINGS.get())
                .define('X', ModItems.PLATINIUM_INGOT.get())
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PLATINIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.PLATINIUM_BOOTS.get())
                .define('X', ModItems.PLATINIUM_INGOT.get())
                .pattern("X X")
                .pattern("X X")
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PLATINIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.BRONZE_HELMET.get())
                .define('X', ModItems.BRONZE_INGOT.get())
                .pattern("XXX")
                .pattern("X X")
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BRONZE_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.BRONZE_CHESTPLATE.get())
                .define('X', ModItems.BRONZE_INGOT.get())
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BRONZE_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.BRONZE_LEGGINGS.get())
                .define('X', ModItems.BRONZE_INGOT.get())
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BRONZE_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.BRONZE_BOOTS.get())
                .define('X', ModItems.BRONZE_INGOT.get())
                .pattern("X X")
                .pattern("X X")
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BRONZE_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.BACKPACK.get())
                .define('L', Items.LEATHER)
                .define('C', Items.CHEST)
                .pattern("L L")
                .pattern("LCL")
                .pattern("LLL")
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CHEST))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModItems.BRONZE_HAMMER.get())
                .define('I', ModItems.BRONZE_INGOT.get())
                .define('S', ModItems.BRONZE_STICK.get())
                .pattern("III")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BRONZE_INGOT.get()))
                .save(consumer);

        //crafts blocks mod
        ShapedRecipeBuilder.shaped(ModBlocks.BRONZE_BLOCK.get())
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ModItems.BRONZE_INGOT.get())
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BRONZE_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.TEMP_BLOCK.get())
                .pattern("CCC")
                .pattern("CGC")
                .pattern("CCC")
                .define('C', ModItems.BRONZE_INGOT.get())
                .define('G', Items.CLOCK)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CLOCK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.REINFORCED_STONE.get())
                .pattern("OOO")
                .pattern("OPO")
                .pattern("OOO")
                .define('P', ModBlocks.PLATINIUM_BLOCK.get())
                .define('O', Blocks.OBSIDIAN)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.PLATINIUM_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.SOAP_BLOCK.get())
                .pattern("CCC")
                .pattern("CWC")
                .pattern("CCC")
                .define('C', Blocks.CLAY)
                .define('W', Items.WATER_BUCKET)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.CLAY))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.PLATINIUM_BLOCK.get())
                .pattern("PPP")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', ModItems.PLATINIUM_INGOT.get())
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PLATINIUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.LIGHT_BLOCK.get())
                .pattern("CDC")
                .pattern("CBC")
                .pattern("CCC")
                .define('C', ModItems.BRONZE_INGOT.get())
                .define('D', Blocks.DAYLIGHT_DETECTOR)
                .define('B', Ingredient.of(Items.ACACIA_BUTTON, Items.BIRCH_BUTTON, Items.CRIMSON_BUTTON, Items.OAK_BUTTON, Items.DARK_OAK_BUTTON, Items.JUNGLE_BUTTON, Items.POLISHED_BLACKSTONE_BUTTON, Items.SPRUCE_BUTTON, Items.STONE_BUTTON, Items.WARPED_BUTTON))
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DAYLIGHT_DETECTOR))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.HOME_BLOCK.get())
                .pattern("PTP")
                .pattern("SRS")
                .pattern("SCS")
                .define('T', Blocks.RED_CARPET)
                .define('C', ModItems.BRONZE_INGOT.get())
                .define('S', Blocks.STONE)
                .define('P', Blocks.OAK_PLANKS)
                .define('R', Blocks.REDSTONE_BLOCK)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.BLUE_CARPET))
                .save(consumer);


        //ajout crafts vanilla
        ShapedRecipeBuilder.shaped(Blocks.GRASS_BLOCK, 3)
                .pattern("HHH")
                .pattern("TTT")
                .pattern("TTT")
                .define('H', Items.WHEAT_SEEDS)
                .define('T', Blocks.DIRT)
                .unlockedBy("unlock", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT_SEEDS, Blocks.DIRT))
                .save(consumer);


    }
}
