package net.icarus.dragonscorpse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.icarus.dragonscorpse.item.ModItems;
import net.icarus.dragonscorpse.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

import static net.icarus.dragonscorpse.item.ModItems.*;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ItemTags.SWORDS)
                .add(ModItems.getRK(DRAGONITE_SWORD));
        tag(ItemTags.PICKAXES)
                .add(ModItems.getRK(DRAGONITE_PICKAXE));
        tag(ItemTags.AXES)
                .add(ModItems.getRK(DRAGONITE_AXE));
        tag(ItemTags.SHOVELS)
                .add(ModItems.getRK(DRAGONITE_SHOVEL));
        tag(ItemTags.HOES)
                .add(ModItems.getRK(DRAGONITE_HOE));
        tag(ItemTags.SPEARS)
                .add(ModItems.getRK(DRAGONITE_SPEAR));

        tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.getRK(ModItems.DRAGONITE_HELMET));
        tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.getRK(ModItems.DRAGONITE_CHESTPLATE));
        tag(ItemTags.LEG_ARMOR)
                .add(ModItems.getRK(ModItems.DRAGONITE_LEGGINGS));
        tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.getRK(ModItems.DRAGONITE_BOOTS));

        tag(ModTags.Items.DRAGONITE_REPAIR)
                .add(ModItems.getRK(DRAGONITE_INGOT));

        tag(ItemTags.MACE_ENCHANTABLE)
                .add(ModItems.getRK(DRAGON_MACE));
        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.getRK(DRAGON_ELYTRA))
                .add(ModItems.getRK(DRAGON_STAFF));


    }

}
