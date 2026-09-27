package net.icarus.dragonscorpse.loot;

import net.fabricmc.fabric.api.loot.v3.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.icarus.dragonscorpse.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.UniformContainerBase;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.List;

public class ModLootTableModifiers {
    public static final List<? extends UniformContainerBase.Builder<?>> DRAGON_BONE_LOOT = List.of(
            LootItem.lootTableItem(ModItems.DRAGON_BONE).apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 5)))
    );
    public static final List<? extends UniformContainerBase.Builder<?>> DRAGON_FLESH_LOOT = List.of(
            LootItem.lootTableItem(ModItems.DRAGON_FLESH).apply(SetItemCountFunction.setCount(ContextIntProviders.between(3, 5)))
    );
    public static final List<? extends UniformContainerBase.Builder<?>> DRAGON_MEMBRANE_LOOT = List.of(
            LootItem.lootTableItem(ModItems.DRAGON_MEMBRANE).apply(SetItemCountFunction.setCount(ContextIntProviders.between(0, 1)))
    );
    public static final List<? extends UniformContainerBase.Builder<?>> DRAGON_EYE_LOOT = List.of(
            LootItem.lootTableItem(ModItems.DRAGON_EYE).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))
    );

    public static final List<? extends UniformContainerBase.Builder<?>> END_CITY_DRAGONITE_UPFRADE_SMITHING_TEMPLATE_LOOT = List.of(
            LootItem.lootTableItem(ModItems.DRAGONITE_UPGRADE_SMITHING_TEMPLATE).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))
    );
    public static void modifyLootTables(ResourceKey<LootTable> key, FabricLootTableBuilder builder, LootTableSource source, HolderLookup.Provider provider) {
        addPoolToLootTable(key, builder, "entities/ender_dragon", 1, LootItemRandomChanceCondition.randomChance(1f), DRAGON_BONE_LOOT);
        addPoolToLootTable(key, builder, "entities/ender_dragon", 1, LootItemRandomChanceCondition.randomChance(1f), DRAGON_FLESH_LOOT);
        addPoolToLootTable(key, builder, "entities/ender_dragon", 1, LootItemRandomChanceCondition.randomChance(1f), DRAGON_MEMBRANE_LOOT);
        addPoolToLootTable(key, builder, "entities/ender_dragon", 1, LootItemRandomChanceCondition.randomChance(0.1f), DRAGON_EYE_LOOT);

        addPoolToLootTable(key, builder, "chests/end_city_treasure", 1, LootItemRandomChanceCondition.randomChance(0.25f), END_CITY_DRAGONITE_UPFRADE_SMITHING_TEMPLATE_LOOT);

    }

    public static void addPoolToLootTable(ResourceKey<LootTable> key, FabricLootTableBuilder builder, String path, int rolls, LootItemCondition.Builder condition, List<? extends UniformContainerBase.Builder<?>> entries) {
        if (key.identifier().equals(Identifier.withDefaultNamespace(path))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ContextIntProviders.exactly(rolls))
                    .when(condition)
                    .addAll((entries));

            builder.pool(poolBuilder.build());
        }
    }
}
