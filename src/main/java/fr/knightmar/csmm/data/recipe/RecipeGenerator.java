package fr.knightmar.csmm.data.recipe;

import fr.knightmar.csmm.init.ModBlocks;
import fr.knightmar.csmm.init.ModItems;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {
    public RecipeGenerator(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {

        //Crafts items mod
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModBlocks.PLATINIUM_ORE.get()), ModItems.PLATINIUM_INGOT.get(), 1f, 200)
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(ModBlocks.PLATINIUM_ORE.get().asItem()))
                .build(consumer);


        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModBlocks.BRONZE_ORE.get()), ModItems.BRONZE_INGOT.get(), 0.5f, 200)
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(ModBlocks.BRONZE_ORE.get().asItem()))
                .build(consumer);


        ShapedRecipeBuilder.shapedRecipe(ModItems.BRONZE_STICK.get(), 4)
                .patternLine("#")
                .patternLine("#")
                .key('#', ModItems.BRONZE_INGOT.get())
                .setGroup("sticks")
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(ModItems.BRONZE_INGOT.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModItems.BRONZE_SWORD.get(), 1)
                .patternLine(" B ")
                .patternLine(" B ")
                .patternLine(" S ")
                .key('B', ModItems.BRONZE_INGOT.get())
                .key('S', ModItems.BRONZE_STICK.get())
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(ModItems.BRONZE_INGOT.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModItems.BRONZE_PICKAXE.get(), 1)
                .patternLine("BBB")
                .patternLine(" S ")
                .patternLine(" S ")
                .key('B', ModItems.BRONZE_INGOT.get())
                .key('S', ModItems.BRONZE_STICK.get())
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(ModItems.BRONZE_INGOT.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModItems.BRONZE_AXE.get())
                .key('#', ModItems.BRONZE_STICK.get())
                .key('X', ModItems.BRONZE_INGOT.get())
                .patternLine("XX")
                .patternLine("X#")
                .patternLine(" #")
                .addCriterion("unlock", hasItem(Items.DIAMOND))
                .build(consumer);


        ShapedRecipeBuilder.shapedRecipe(ModItems.BRONZE_SHOVEL.get(), 1)
                .patternLine(" B ")
                .patternLine(" S ")
                .patternLine(" S ")
                .key('B', ModItems.BRONZE_INGOT.get())
                .key('S', ModItems.BRONZE_STICK.get())
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(ModItems.BRONZE_INGOT.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModItems.PLATINIUM_SWORD.get(), 1)
                .patternLine(" B ")
                .patternLine(" B ")
                .patternLine(" S ")
                .key('B', ModItems.PLATINIUM_INGOT.get())
                .key('S', ModItems.BRONZE_STICK.get())
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(ModItems.PLATINIUM_INGOT.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModItems.PLATINIUM_HELMET.get())
                .key('X', ModItems.PLATINIUM_INGOT.get())
                .patternLine("XXX")
                .patternLine("X X")
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(ModItems.PLATINIUM_INGOT.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModItems.PLATINIUM_CHESTPLATE.get())
                .key('X', ModItems.PLATINIUM_INGOT.get())
                .patternLine("X X")
                .patternLine("XXX")
                .patternLine("XXX")
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(ModItems.PLATINIUM_INGOT.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModItems.PLATINIUM_LEGGINGS.get())
                .key('X', ModItems.PLATINIUM_INGOT.get())
                .patternLine("XXX")
                .patternLine("X X")
                .patternLine("X X")
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(ModItems.PLATINIUM_INGOT.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModItems.PLATINIUM_BOOTS.get())
                .key('X', ModItems.PLATINIUM_INGOT.get())
                .patternLine("X X")
                .patternLine("X X")
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(ModItems.PLATINIUM_INGOT.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModItems.BRONZE_HELMET.get())
                .key('X', ModItems.BRONZE_INGOT.get())
                .patternLine("XXX")
                .patternLine("X X")
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(ModItems.BRONZE_INGOT.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModItems.BRONZE_CHESTPLATE.get())
                .key('X', ModItems.BRONZE_INGOT.get())
                .patternLine("X X")
                .patternLine("XXX")
                .patternLine("XXX")
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(ModItems.BRONZE_INGOT.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModItems.BRONZE_LEGGINGS.get())
                .key('X', ModItems.BRONZE_INGOT.get())
                .patternLine("XXX")
                .patternLine("X X")
                .patternLine("X X")
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(ModItems.BRONZE_INGOT.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModItems.BRONZE_BOOTS.get())
                .key('X', ModItems.BRONZE_INGOT.get())
                .patternLine("X X")
                .patternLine("X X")
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(ModItems.BRONZE_INGOT.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModItems.BACKPACK.get())
                .key('L', Items.LEATHER)
                .key('C', Items.CHEST)
                .patternLine("L L")
                .patternLine("LCL")
                .patternLine("LLL")
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(Items.CHEST))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModItems.BRONZE_HAMMER.get())
                .key('I', ModItems.BRONZE_INGOT.get())
                .key('S', ModItems.BRONZE_STICK.get())
                .patternLine("III")
                .patternLine(" S ")
                .patternLine(" S ")
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(ModItems.BRONZE_INGOT.get()))
                .build(consumer);

        //crafts blocks mod
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.BRONZE_BLOCK.get())
                .patternLine("CCC")
                .patternLine("CCC")
                .patternLine("CCC")
                .key('C', ModItems.BRONZE_INGOT.get())
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(ModItems.BRONZE_INGOT.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.TEMP_BLOCK.get())
                .patternLine("CCC")
                .patternLine("CGC")
                .patternLine("CCC")
                .key('C', ModItems.BRONZE_INGOT.get())
                .key('G', Items.CLOCK)
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(Items.CLOCK))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.REINFORCED_STONE.get())
                .patternLine("OOO")
                .patternLine("OPO")
                .patternLine("OOO")
                .key('P', ModBlocks.PLATINIUM_BLOCK.get())
                .key('O', Blocks.OBSIDIAN)
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(ModBlocks.PLATINIUM_BLOCK.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.SOAP_BLOCK.get())
                .patternLine("CCC")
                .patternLine("CWC")
                .patternLine("CCC")
                .key('C', Blocks.CLAY)
                .key('W', Items.WATER_BUCKET)
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(Blocks.CLAY))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.PLATINIUM_BLOCK.get())
                .patternLine("PPP")
                .patternLine("PPP")
                .patternLine("PPP")
                .key('P', ModItems.PLATINIUM_INGOT.get())
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(ModItems.PLATINIUM_INGOT.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.LIGHT_BLOCK.get())
                .patternLine("CDC")
                .patternLine("CBC")
                .patternLine("CCC")
                .key('C', ModItems.BRONZE_INGOT.get())
                .key('D', Blocks.DAYLIGHT_DETECTOR)
                .key('B', Ingredient.fromItems(Items.ACACIA_BUTTON, Items.BIRCH_BUTTON, Items.CRIMSON_BUTTON, Items.OAK_BUTTON, Items.DARK_OAK_BUTTON, Items.JUNGLE_BUTTON, Items.POLISHED_BLACKSTONE_BUTTON, Items.SPRUCE_BUTTON, Items.STONE_BUTTON, Items.WARPED_BUTTON))
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(Items.DAYLIGHT_DETECTOR))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.HOME_BLOCK.get())
                .patternLine("PTP")
                .patternLine("SRS")
                .patternLine("SCS")
                .key('T', Blocks.RED_CARPET)
                .key('C', ModItems.BRONZE_INGOT.get())
                .key('S', Blocks.STONE)
                .key('P', Blocks.OAK_PLANKS)
                .key('R', Blocks.REDSTONE_BLOCK)
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(Blocks.BLUE_CARPET))
                .build(consumer);


        //ajout crafts vanilla
        ShapedRecipeBuilder.shapedRecipe(Blocks.GRASS_BLOCK, 3)
                .patternLine("HHH")
                .patternLine("TTT")
                .patternLine("TTT")
                .key('H', Items.WHEAT_SEEDS)
                .key('T', Blocks.DIRT)
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(Items.WHEAT_SEEDS, Blocks.DIRT))
                .build(consumer);


    }
}
