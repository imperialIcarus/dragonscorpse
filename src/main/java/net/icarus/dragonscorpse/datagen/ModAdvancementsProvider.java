package net.icarus.dragonscorpse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.icarus.dragonscorpse.DragonSCorpse;
import net.icarus.dragonscorpse.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.advancements.packs.VanillaTheEndAdvancements;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementsProvider extends FabricAdvancementProvider {
    public ModAdvancementsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
        // Dragonite Ingot Advancement
        AdvancementHolder dragoniteIngot = Advancement.Builder.advancement()
                .parent(createPlaceholder(Identifier.withDefaultNamespace("end/kill_dragon")))
                .display(ModItems.DRAGONITE_INGOT, Component.translatable("advancements.dragonscorpse.end.dragonite_ingot.title"), Component.translatable("advancements.dragonscorpse.end.dragonite_ingot.desc"), AdvancementType.CHALLENGE, true, true, false)
                .rewards(AdvancementRewards.Builder.experience(400))
                .addCriterion("dragonite_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DRAGONITE_INGOT))
                .save(consumer, DragonSCorpse.id("end/dragonite_ingot"));
        // Dragonite Armor Advancement
        Advancement.Builder.advancement()
                .parent(dragoniteIngot)
                .display(ModItems.DRAGONITE_CHESTPLATE, Component.translatable("advancements.dragonscorpse.end.dragonite_armor.title"), Component.translatable("advancements.dragonscorpse.end.dragonite_armor.desc"), AdvancementType.CHALLENGE, true, true, false)
                .rewards(AdvancementRewards.Builder.experience(400))
                .addCriterion("dragonite_armor", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DRAGONITE_HELMET, ModItems.DRAGONITE_CHESTPLATE, ModItems.DRAGONITE_LEGGINGS, ModItems.DRAGONITE_BOOTS))
                .save(consumer, DragonSCorpse.id("end/dragonite_armor"));
        // Dragonite Hoe Advancement
        Advancement.Builder.advancement()
                .parent(dragoniteIngot)
                .display(ModItems.DRAGONITE_HOE, Component.translatable("advancements.dragonscorpse.end.dragonite_hoe.title"), Component.translatable("advancements.dragonscorpse.end.dragonite_hoe.desc"), AdvancementType.CHALLENGE, true, true, false)
                .rewards(AdvancementRewards.Builder.experience(400))
                .addCriterion("dragonite_hoe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DRAGONITE_HOE))
                .save(consumer, DragonSCorpse.id("end/dragonite_hoe"));
        // Dragon Elytra Advancement
        Advancement.Builder.advancement()
                .parent(createPlaceholder(Identifier.withDefaultNamespace("end/elytra")))
                .display(ModItems.DRAGON_ELYTRA, Component.translatable("advancements.dragonscorpse.end.dragon_elytra.title"), Component.translatable("advancements.dragonscorpse.end.dragon_elytra.desc"), AdvancementType.CHALLENGE, true, true, false)
                .rewards(AdvancementRewards.Builder.experience(600))
                .addCriterion("dragon_elytra", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DRAGON_ELYTRA))
                .save(consumer, DragonSCorpse.id("end/dragon_elytra"));
        // Dragon Eye Advancement
        AdvancementHolder dragonEye = Advancement.Builder.advancement()
                .parent(createPlaceholder(Identifier.withDefaultNamespace("end/kill_dragon")))
                .display(ModItems.DRAGON_EYE, Component.translatable("advancements.dragonscorpse.end.dragon_eye.title"), Component.translatable("advancements.dragonscorpse.end.dragon_eye.desc"), AdvancementType.CHALLENGE, true, true, false)
                .rewards(AdvancementRewards.Builder.experience(600))
                .addCriterion("dragon_eye", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DRAGON_EYE))
                .save(consumer, DragonSCorpse.id("end/dragon_eye"));
        // Dragon Staff Advancement
        Advancement.Builder.advancement()
                .parent(dragonEye)
                .display(ModItems.DRAGON_STAFF, Component.translatable("advancements.dragonscorpse.end.dragon_staff.title"), Component.translatable("advancements.dragonscorpse.end.dragon_staff.desc"), AdvancementType.CHALLENGE, true, true, false)
                .rewards(AdvancementRewards.Builder.experience(1000))
                .addCriterion("dragon_staff", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DRAGON_STAFF))
                .save(consumer, DragonSCorpse.id("end/dragon_staff"));
        // Dragon Mace Advancement
        Advancement.Builder.advancement()
                .parent(dragonEye)
                .display(ModItems.DRAGON_MACE, Component.translatable("advancements.dragonscorpse.end.dragon_mace.title"), Component.translatable("advancements.dragonscorpse.end.dragon_mace.desc"), AdvancementType.CHALLENGE, true, true, false)
                .rewards(AdvancementRewards.Builder.experience(1000))
                .addCriterion("dragon_mace", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.DRAGON_MACE))
                .save(consumer, DragonSCorpse.id("end/dragon_mace"));
    }
}
