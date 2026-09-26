package net.icarus.dragonscorpse;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.icarus.dragonscorpse.block.ModBlocks;
import net.icarus.dragonscorpse.creativemodtab.ModCreativeModeTabs;
import net.icarus.dragonscorpse.item.ModItems;
import net.icarus.dragonscorpse.loot.ModLootTableModifiers;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DragonSCorpse implements ModInitializer {
	public static final String MOD_ID = "dragonscorpse";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerModCreativeModeTabs();
		ModItems.registerModItems();

		ModBlocks.registerModBlocks();

		LootTableEvents.MODIFY.register(ModLootTableModifiers::modifyLootTables);
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
