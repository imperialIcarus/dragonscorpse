package net.icarus.dragonscorpse.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.icarus.dragonscorpse.block.ModBlocks;
import net.icarus.dragonscorpse.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

import java.util.Map;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.DRAGONITE_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.REINFORCED_ENDSTONE);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.DRAGON_FLESH, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DRAGON_BONE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DRAGON_MEMBRANE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DRAGON_EYE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_DRAGON_MEAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.COOKED_DRAGON_MEAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DRAGONITE_INGOT, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.DRAGONITE_NAUTILUS_ARMOR, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DRAGONITE_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DRAGONITE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DRAGONITE_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DRAGONITE_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DRAGONITE_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerators.generateElytra(ModItems.DRAGON_ELYTRA);

        itemModelGenerators.generateFlatItem(ModItems.DRAGON_MACE, ModelTemplates.FLAT_HANDHELD_MACE_ITEM);

        itemModelGenerators.generateSpear(ModItems.DRAGONITE_SPEAR);

        itemModelGenerators.declareCustomModelItem(ModItems.DRAGON_STAFF);

        itemModelGenerators.generateTrimmableArmorSet(ModItems.DRAGONITE_HELMET, ModItems.DRAGONITE_CHESTPLATE, ModItems.DRAGONITE_LEGGINGS, ModItems.DRAGONITE_BOOTS, false, Map.of());


    }
}
