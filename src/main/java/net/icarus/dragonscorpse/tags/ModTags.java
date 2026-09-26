package net.icarus.dragonscorpse.tags;

import net.icarus.dragonscorpse.DragonSCorpse;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> NEEDS_DRAGONITE_TOOL = createTag("needs_dragonite_tool");
        public static final TagKey<Block> INCORRECT_FOR_DRAGONITE_TOOL = createTag("incorrect_for_dragonite_tool");


        public static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, name));
        }
    }
    public static class Items {

        public static final TagKey<Item> DRAGONITE_REPAIR = createTag("dragonite_repair");

        public static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, name));
        }
    }
    public static class Trades {


        public static TagKey<VillagerTrade> createTag(String name) {
            return TagKey.create(Registries.VILLAGER_TRADE, Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, name));
        }
    }
}
