package net.icarus.dragonscorpse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.icarus.dragonscorpse.DragonSCorpse;
import net.icarus.dragonscorpse.block.ModBlocks;
import net.icarus.dragonscorpse.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider { // Provides the recipes
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, BootstrapContext<Recipe<?>> recipeContext, BootstrapContext<Advancement> advancementContext) {
        return new RecipeProvider(recipeContext, advancementContext) {
            @Override
            public void buildRecipes() {
                // Dragonite Ingot/Block Recipes
                nineBlockStorageRecipesRecipesWithCustomUnpacking(RecipeCategory.BUILDING_BLOCKS, ModItems.DRAGONITE_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRAGONITE_BLOCK, "dragonite_block_to_dragonite_ingot", "dragonite");
                shapeless(RecipeCategory.MISC, ModItems.DRAGONITE_INGOT)
                        .requires(ModItems.DRAGON_BONE, 4)
                        .requires(ModItems.DRAGON_FLESH, 4)
                        .unlockedBy(getHasName(ModItems.DRAGON_BONE), has(ModItems.DRAGON_BONE))
                        .unlockedBy(getHasName(ModItems.DRAGON_FLESH), has(ModItems.DRAGON_FLESH))
                        .save(output);
                // Dragonite Upgrade Smithing Template Recipes
                shaped(RecipeCategory.COMBAT, ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE, 2)
                        .pattern("sts")
                        .pattern("sms")
                        .pattern("sss")
                        .define('t', ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE)
                        .define('s', Items.NETHERITE_SCRAP)
                        .define('m', ModItems.DRAGON_MEMBRANE)
                        .unlockedBy(getHasName(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), has(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE))
                        .unlockedBy(getHasName(ModItems.DRAGON_MEMBRANE), has(ModItems.DRAGON_MEMBRANE))
                        .unlockedBy(getHasName(Items.NETHERITE_SCRAP), has(Items.NETHERITE_SCRAP))
                        .save(output);
                // Misc Recipes
                shapeless(RecipeCategory.FOOD, ModItems.RAW_DRAGON_MEAT, 8)
                        .requires(ModItems.DRAGON_FLESH)
                        .unlockedBy(getHasName(ModItems.DRAGON_FLESH), has(ModItems.DRAGON_FLESH))
                        .save(output);
                SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.RAW_DRAGON_MEAT),
                        RecipeCategory.FOOD,
                        CookingBookCategory.FOOD,
                        ModItems.COOKED_DRAGON_MEAT,
                        3.5f,
                        120)
                        .unlockedBy(getHasName(ModItems.RAW_DRAGON_MEAT), has(ModItems.RAW_DRAGON_MEAT))
                        .save(output, DragonSCorpse.id("dragon_meat_smelting").toString());
                SimpleCookingRecipeBuilder.smoking(
                                Ingredient.of(ModItems.RAW_DRAGON_MEAT),
                                RecipeCategory.FOOD,
                                ModItems.COOKED_DRAGON_MEAT,
                                3.5f,
                                60)
                        .unlockedBy(getHasName(ModItems.RAW_DRAGON_MEAT), has(ModItems.RAW_DRAGON_MEAT))
                        .save(output, DragonSCorpse.id("dragon_meat_smoking").toString());
                SimpleCookingRecipeBuilder.campfireCooking(
                                Ingredient.of(ModItems.RAW_DRAGON_MEAT),
                                RecipeCategory.FOOD,
                                ModItems.COOKED_DRAGON_MEAT,
                                3.5f,
                                150)
                        .unlockedBy(getHasName(ModItems.RAW_DRAGON_MEAT), has(ModItems.RAW_DRAGON_MEAT))
                        .save(output, DragonSCorpse.id("dragon_meat_campfire_cooking").toString());
                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_ENDSTONE)
                        .pattern("obo")
                        .pattern("beb")
                        .pattern("obo")
                        .define('e', Blocks.END_STONE)
                        .define('b', ModItems.DRAGON_BONE)
                        .define('o', Blocks.OBSIDIAN)
                        .unlockedBy(getHasName(ModItems.DRAGON_BONE), has(ModItems.DRAGON_BONE))
                        .unlockedBy(getHasName(Items.OBSIDIAN), has(Items.OBSIDIAN))
                        .unlockedBy(getHasName(Items.END_STONE), has(Items.END_STONE))
                        .save(output);
                // Dragonite Armor and Tools Recipes
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(Items.NETHERITE_HELMET), Ingredient.of(ModItems.DRAGONITE_INGOT), RecipeCategory.COMBAT, ModItems.DRAGONITE_HELMET)
                        .unlocks(RecipeProvider.getHasName(Items.NETHERITE_HELMET), has(Items.NETHERITE_HELMET))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_INGOT), has(ModItems.DRAGONITE_INGOT))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), has(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE))
                        .save(output, getItemName(ModItems.DRAGONITE_HELMET) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(Items.NETHERITE_CHESTPLATE), Ingredient.of(ModItems.DRAGONITE_INGOT), RecipeCategory.COMBAT, ModItems.DRAGONITE_CHESTPLATE)
                        .unlocks(RecipeProvider.getHasName(Items.NETHERITE_CHESTPLATE), has(Items.NETHERITE_CHESTPLATE))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_INGOT), has(ModItems.DRAGONITE_INGOT))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), has(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE))
                        .save(output, getItemName(ModItems.DRAGONITE_CHESTPLATE) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(Items.NETHERITE_LEGGINGS), Ingredient.of(ModItems.DRAGONITE_INGOT), RecipeCategory.COMBAT, ModItems.DRAGONITE_LEGGINGS)
                        .unlocks(RecipeProvider.getHasName(Items.NETHERITE_LEGGINGS), has(Items.NETHERITE_LEGGINGS))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_INGOT), has(ModItems.DRAGONITE_INGOT))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), has(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE))
                        .save(output, getItemName(ModItems.DRAGONITE_LEGGINGS) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(Items.NETHERITE_BOOTS), Ingredient.of(ModItems.DRAGONITE_INGOT), RecipeCategory.COMBAT, ModItems.DRAGONITE_BOOTS)
                        .unlocks(RecipeProvider.getHasName(Items.NETHERITE_BOOTS), has(Items.NETHERITE_BOOTS))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_INGOT), has(ModItems.DRAGONITE_INGOT))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), has(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE))
                        .save(output, getItemName(ModItems.DRAGONITE_BOOTS) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(Items.NETHERITE_SWORD), Ingredient.of(ModItems.DRAGONITE_INGOT), RecipeCategory.COMBAT, ModItems.DRAGONITE_SWORD)
                        .unlocks(RecipeProvider.getHasName(Items.NETHERITE_SWORD), has(Items.NETHERITE_SWORD))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_INGOT), has(ModItems.DRAGONITE_INGOT))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), has(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE))
                        .save(output, getItemName(ModItems.DRAGONITE_SWORD) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(Items.NETHERITE_PICKAXE), Ingredient.of(ModItems.DRAGONITE_INGOT), RecipeCategory.COMBAT, ModItems.DRAGONITE_PICKAXE)
                        .unlocks(RecipeProvider.getHasName(Items.NETHERITE_PICKAXE), has(Items.NETHERITE_PICKAXE))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_INGOT), has(ModItems.DRAGONITE_INGOT))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), has(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE))
                        .save(output, getItemName(ModItems.DRAGONITE_PICKAXE) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(Items.NETHERITE_AXE), Ingredient.of(ModItems.DRAGONITE_INGOT), RecipeCategory.COMBAT, ModItems.DRAGONITE_AXE)
                        .unlocks(RecipeProvider.getHasName(Items.NETHERITE_AXE), has(Items.NETHERITE_AXE))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_INGOT), has(ModItems.DRAGONITE_INGOT))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), has(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE))
                        .save(output, getItemName(ModItems.DRAGONITE_AXE) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(Items.NETHERITE_SHOVEL), Ingredient.of(ModItems.DRAGONITE_INGOT), RecipeCategory.COMBAT, ModItems.DRAGONITE_SHOVEL)
                        .unlocks(RecipeProvider.getHasName(Items.NETHERITE_SHOVEL), has(Items.NETHERITE_SHOVEL))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_INGOT), has(ModItems.DRAGONITE_INGOT))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), has(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE))
                        .save(output, getItemName(ModItems.DRAGONITE_SHOVEL) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(Items.NETHERITE_HOE), Ingredient.of(ModItems.DRAGONITE_INGOT), RecipeCategory.COMBAT, ModItems.DRAGONITE_HOE)
                        .unlocks(RecipeProvider.getHasName(Items.NETHERITE_HOE), has(Items.NETHERITE_HOE))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_INGOT), has(ModItems.DRAGONITE_INGOT))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), has(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE))
                        .save(output, getItemName(ModItems.DRAGONITE_HOE) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(Items.NETHERITE_SPEAR), Ingredient.of(ModItems.DRAGONITE_INGOT), RecipeCategory.COMBAT, ModItems.DRAGONITE_SPEAR)
                        .unlocks(RecipeProvider.getHasName(Items.NETHERITE_SPEAR), has(Items.NETHERITE_SPEAR))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_INGOT), has(ModItems.DRAGONITE_INGOT))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), has(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE))
                        .save(output, getItemName(ModItems.DRAGONITE_SPEAR) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(Items.NETHERITE_NAUTILUS_ARMOR), Ingredient.of(ModItems.DRAGONITE_INGOT), RecipeCategory.COMBAT, ModItems.DRAGONITE_NAUTILUS_ARMOR)
                        .unlocks(RecipeProvider.getHasName(Items.NETHERITE_NAUTILUS_ARMOR), has(Items.NETHERITE_NAUTILUS_ARMOR))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_INGOT), has(ModItems.DRAGONITE_INGOT))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), has(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE))
                        .save(output, getItemName(ModItems.DRAGONITE_NAUTILUS_ARMOR) + "_smithing");
                // Advanced Recipes
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(Items.ELYTRA), Ingredient.of(ModItems.DRAGON_MEMBRANE), RecipeCategory.COMBAT, ModItems.DRAGON_ELYTRA)
                        .unlocks(RecipeProvider.getHasName(Items.ELYTRA), has(Items.ELYTRA))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGON_MEMBRANE), has(ModItems.DRAGON_MEMBRANE))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), has(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE))
                        .save(output, getItemName(ModItems.DRAGON_ELYTRA) + "_smithing");
                SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(Items.MACE), Ingredient.of(ModItems.DRAGON_EYE), RecipeCategory.COMBAT, ModItems.DRAGON_MACE)
                        .unlocks(RecipeProvider.getHasName(Items.MACE), has(Items.MACE))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGON_EYE), has(ModItems.DRAGON_EYE))
                        .unlocks(RecipeProvider.getHasName(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE), has(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE))
                        .save(output, getItemName(ModItems.DRAGON_MACE) + "_smithing");
                shaped(RecipeCategory.COMBAT, ModItems.DRAGON_STAFF)
                        .pattern(" me")
                        .pattern(" bm")
                        .pattern("b  ")
                        .define('m', ModItems.DRAGON_MEMBRANE)
                        .define('b', ModItems.DRAGON_BONE)
                        .define('e', ModItems.DRAGON_EYE)
                        .unlockedBy(getHasName(ModItems.DRAGON_MEMBRANE), has(ModItems.DRAGON_MEMBRANE))
                        .unlockedBy(getHasName(ModItems.DRAGON_BONE), has(ModItems.DRAGON_BONE))
                        .unlockedBy(getHasName(ModItems.DRAGON_EYE), has(ModItems.DRAGON_EYE))
                        .save(output);
            }
        };

    }
}

