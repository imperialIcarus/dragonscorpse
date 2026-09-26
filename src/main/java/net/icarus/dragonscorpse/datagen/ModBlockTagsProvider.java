package net.icarus.dragonscorpse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.icarus.dragonscorpse.block.ModBlocks;
import net.icarus.dragonscorpse.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider { // Provides tags for blocks like what tool you should mine it with
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.DRAGONITE_BLOCK));
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.getRK(ModBlocks.DRAGONITE_BLOCK));
        tag(ModTags.Blocks.NEEDS_DRAGONITE_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}
