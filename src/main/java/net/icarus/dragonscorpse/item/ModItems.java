package net.icarus.dragonscorpse.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.icarus.dragonscorpse.DragonSCorpse;
import net.icarus.dragonscorpse.food.ModFoods;
import net.icarus.dragonscorpse.item.advanced.DragonMaceItem;
import net.icarus.dragonscorpse.item.advanced.DragonStaffItem;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Unit;
import net.minecraft.util.Util;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.providers.number.floats.ContextFloatProviders;
import net.minecraft.world.level.storage.loot.providers.number.floats.ResolvableFloat;
import net.minecraft.world.level.storage.loot.providers.number.ints.ResolvableInt;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ModItems {

    // Ingredients
    public static final Item DRAGON_FLESH = registerItem("dragon_flesh", properties -> new Item(properties
            .rarity(Rarity.UNCOMMON)
            .food(ModFoods.DRAGON_RAW, ModFoods.DRAGON_RAW_CONSUMABLE)));
    public static final Item DRAGON_BONE = registerItem("dragon_bone", properties -> new Item(properties
            .rarity(Rarity.UNCOMMON)));
    public static final Item DRAGON_MEMBRANE = registerItem("dragon_membrane", properties -> new Item(properties
            .rarity(Rarity.RARE)));
    public static final Item DRAGON_EYE = registerItem("dragon_eye", properties -> new Item(properties
            .rarity(Rarity.EPIC)));
    // Dragonite Smithing Template
    private static final Identifier EMPTY_SLOT_HELMET = Identifier.withDefaultNamespace("container/slot/helmet");
    private static final Identifier EMPTY_SLOT_CHESTPLATE = Identifier.withDefaultNamespace("container/slot/chestplate");
    private static final Identifier EMPTY_SLOT_LEGGINGS = Identifier.withDefaultNamespace("container/slot/leggings");
    private static final Identifier EMPTY_SLOT_BOOTS = Identifier.withDefaultNamespace("container/slot/boots");
    private static final Identifier EMPTY_SLOT_HOE = Identifier.withDefaultNamespace("container/slot/hoe");
    private static final Identifier EMPTY_SLOT_AXE = Identifier.withDefaultNamespace("container/slot/axe");
    private static final Identifier EMPTY_SLOT_SWORD = Identifier.withDefaultNamespace("container/slot/sword");
    private static final Identifier EMPTY_SLOT_SHOVEL = Identifier.withDefaultNamespace("container/slot/shovel");
    private static final Identifier EMPTY_SLOT_SPEAR = Identifier.withDefaultNamespace("container/slot/spear");
    private static final Identifier EMPTY_SLOT_PICKAXE = Identifier.withDefaultNamespace("container/slot/pickaxe");
    private static final Identifier EMPTY_SLOT_NAUTILUS_ARMOR = Identifier.withDefaultNamespace("container/slot/nautilus_armor");
    private static final Identifier EMPTY_SLOT_INGOT = Identifier.withDefaultNamespace("container/slot/ingot");
    public static final Item DRAGONITE_UPGRADE_SMITHING_TEMPLATE = registerItem("dragonite_upgrade_smithing_template", properties -> new SmithingTemplateItem(
            Component.translatable("item.dragonscorpse.smithing_template.dragonite_upgrade.applies_to").withStyle(ChatFormatting.BLUE),
            Component.translatable("item.dragonscorpse.smithing_template.dragonite_upgrade.ingredients").withStyle(ChatFormatting.BLUE),
            Component.translatable("item.dragonscorpse.smithing.template.dragonite_upgrade.base_slot_description"),
            Component.translatable("item.dragonscorpse.smithing.template.dragonite_upgrade.additions_slot_description"),
            List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL, EMPTY_SLOT_NAUTILUS_ARMOR, EMPTY_SLOT_SPEAR),
            List.of(EMPTY_SLOT_INGOT),
            properties.rarity(Rarity.EPIC)));
    // Dragonite Ingot
    public static final Item DRAGONITE_INGOT = registerItem("dragonite_ingot", Item::new);
    // Dragonite Tools
    public static final Item DRAGONITE_SWORD = registerItem("dragonite_sword", properties -> new Item(properties
            .sword(ModToolMaterials.DRAGONITE_TOOL_MATERIAL, 3f, -2.4f).fireResistant()));
    public static final Item DRAGONITE_PICKAXE = registerItem("dragonite_pickaxe", properties -> new Item(properties
            .pickaxe(ModToolMaterials.DRAGONITE_TOOL_MATERIAL, 1f, -2.8f).fireResistant()));
    public static final Item DRAGONITE_AXE = registerItem("dragonite_axe", properties -> new Item(properties
            .axe(ModToolMaterials.DRAGONITE_TOOL_MATERIAL, 5f, -3f).fireResistant()));
    public static final Item DRAGONITE_SHOVEL = registerItem("dragonite_shovel", properties -> new Item(properties
            .shovel(ModToolMaterials.DRAGONITE_TOOL_MATERIAL, 1.5f, -3f).fireResistant()));
    public static final Item DRAGONITE_HOE = registerItem("dragonite_hoe", properties -> new Item(properties
            .hoe(ModToolMaterials.DRAGONITE_TOOL_MATERIAL, -4f, 0f).fireResistant()));
    public static final Item DRAGONITE_SPEAR = registerItem("dragonite_spear", properties -> new Item(properties
            .spear(ModToolMaterials.DRAGONITE_TOOL_MATERIAL, 1.25f, 1.5f, 0.3f, 2f, 8f, 5f, 5.1f, 8f, 4.6f).fireResistant()));
    // Dragonite Armor
    public static final Item DRAGONITE_HELMET = registerItem("dragonite_helmet", properties -> new Item(properties
            .humanoidArmor(ModArmorMaterials.DRAGONITE_ARMOR_MATERAL, ArmorType.HELMET).fireResistant()));
    public static final Item DRAGONITE_CHESTPLATE = registerItem("dragonite_chestplate", properties -> new Item(properties
            .humanoidArmor(ModArmorMaterials.DRAGONITE_ARMOR_MATERAL, ArmorType.CHESTPLATE).fireResistant()));
    public static final Item DRAGONITE_LEGGINGS = registerItem("dragonite_leggings", properties -> new Item(properties
            .humanoidArmor(ModArmorMaterials.DRAGONITE_ARMOR_MATERAL, ArmorType.LEGGINGS).fireResistant()));
    public static final Item DRAGONITE_BOOTS = registerItem("dragonite_boots", properties -> new Item(properties
            .humanoidArmor(ModArmorMaterials.DRAGONITE_ARMOR_MATERAL, ArmorType.BOOTS).fireResistant()));
    public static final Item DRAGONITE_NAUTILUS_ARMOR = registerItem("dragonite_nautilus_armor", properties -> new Item(properties
            .nautilusArmor(ModArmorMaterials.DRAGONITE_ARMOR_MATERAL).fireResistant()));
    // Advanced Items
    public static final Item DRAGON_MACE = registerItem("dragon_mace", properties -> new DragonMaceItem(properties
            .attributes(DragonMaceItem.getDragonMaceAttributeModifiers())
            .stacksTo(1)
            .component(DataComponents.TOOL, MaceItem.createToolProperties())
            .component(DataComponents.WEAPON, new Weapon(1))
            .rarity(Rarity.EPIC)
            .repairable(DRAGON_EYE)
            .fireResistant()
            .enchantable(15)));
    public static final Item DRAGON_STAFF = registerItem("dragon_staff", properties -> new DragonStaffItem(properties
            .stacksTo(1)
            .durability(2661)
            .rarity(Rarity.EPIC)
            .useCooldown(30f)
            .fireResistant()
            .repairable(DRAGON_EYE)));
    public static final Item DRAGON_ELYTRA = registerItem("dragon_elytra", properties -> new Item(properties
            .durability(1296)
            .rarity(Rarity.EPIC)
            .component(DataComponents.GLIDER, Unit.INSTANCE)
            .component(DataComponents.EQUIPPABLE, Equippable.builder(EquipmentSlot.CHEST).setEquipSound(SoundEvents.ARMOR_EQUIP_ELYTRA).setAsset(ModArmorMaterials.DRAGON_ELYTRA_KEY).setDamageOnHurt(false).build())
            .repairable(DRAGON_MEMBRANE)
            .fireResistant()
            .attributes(ItemAttributeModifiers.builder().add(Attributes.ARMOR, new AttributeModifier(Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, "dragon_elytra_armor"), 7f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.CHEST).build())));
    // Dragon Foods
    public static final Item RAW_DRAGON_MEAT_CHUNK = registerItem("raw_dragon_meat_chunk", properties -> new Item(properties
            .rarity(Rarity.UNCOMMON)
            .food(ModFoods.DRAGON_RAW, ModFoods.DRAGON_RAW_CONSUMABLE)
    ));
    public static final Item COOKED_DRAGON_MEAT_CHUNK = registerItem("cooked_dragon_meat_chunk", properties -> new Item(properties
            .rarity(Rarity.RARE)
            .food(ModFoods.DRAGON_COOKED, ModFoods.DRAGON_COOKED_CONSUMABLE)
    ));






    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, name)))));
    }

    public static void registerModItems() {
        DragonSCorpse.LOGGER.info("Registering Mod Items for " + DragonSCorpse.MOD_ID);
    }

}
