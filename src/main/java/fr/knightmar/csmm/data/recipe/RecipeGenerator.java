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


        ShapedRecipeBuilder.shapedRecipe(Blocks.GRASS_BLOCK, 3)
                .patternLine("HHH")
                .patternLine("TTT")
                .patternLine("TTT")
                .key('H', Blocks.GRASS)
                .key('T', Blocks.DIRT)
                .addCriterion("unlock", InventoryChangeTrigger.Instance.forItems(Blocks.GRASS, Blocks.DIRT))
                .build(consumer);
    }
}
