package net.icarus.dragonscorpse.creativemodtab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.icarus.dragonscorpse.DragonSCorpse;
import net.icarus.dragonscorpse.block.ModBlocks;
import net.icarus.dragonscorpse.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.List;

public class ModCreativeModeTabs {
    // Items List
    public static final List<ItemLike> DRAGONS_CORPSE_ITEMS = List.of(
            ModItems.DRAGON_BONE,
            ModItems.DRAGON_FLESH,
            ModItems.DRAGON_MEMBRANE,
            ModItems.DRAGON_EYE,
            ModItems.RAW_DRAGON_MEAT_CHUNK,
            ModItems.COOKED_DRAGON_MEAT_CHUNK,
            ModItems.DRAGONITE_HELMET,
            ModItems.DRAGONITE_CHESTPLATE,
            ModItems.DRAGONITE_LEGGINGS,
            ModItems.DRAGONITE_BOOTS,
            ModItems.DRAGONITE_NAUTILUS_ARMOR,
            ModItems.DRAGON_ELYTRA,
            ModItems.DRAGONITE_SWORD,
            ModItems.DRAGONITE_PICKAXE,
            ModItems.DRAGONITE_AXE,
            ModItems.DRAGONITE_SHOVEL,
            ModItems.DRAGONITE_HOE,
            ModItems.DRAGONITE_SPEAR,
            ModItems.DRAGON_MACE,
            ModItems.DRAGON_STAFF,
            ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE,
            ModItems.DRAGONITE_INGOT,
            ModBlocks.DRAGONITE_BLOCK,
            ModBlocks.REINFORCED_END_STONE
    );
    public static final CreativeModeTab DRAGONS_CORPSE_CREATIVE_MODE_TAB = register(
            "dragons_corpse_items",
            Component.translatable("creativemodetab.dragonscorpse.dragons_corpse_items"),
            ModItems.DRAGON_EYE,
            DRAGONS_CORPSE_ITEMS
    );

    public static void registerModCreativeModeTabs() {
        DragonSCorpse.LOGGER.info("Registering Mod Creative Mode Tabs for" + DragonSCorpse.MOD_ID);
    }

    public static CreativeModeTab register(String name, Component title, ItemLike icon, List<ItemLike> entries) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, name),
                FabricCreativeModeTab.builder()
                        .title(title)
                        .icon(() -> new ItemStack(icon))
                        .displayItems(((parameters, output) -> {
                            for(ItemLike entry : entries) {
                                output.accept(entry);
                            }
                        }))
                        .build());
    }
}
