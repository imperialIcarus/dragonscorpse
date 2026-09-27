package net.icarus.dragonscorpse.datagen;

import com.mojang.serialization.Codec;
import net.icarus.dragonscorpse.DragonSCorpse;
import net.icarus.dragonscorpse.item.ModArmorMaterials;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModEquipmentAssetProvider implements DataProvider {

    private final PackOutput.PathProvider pathProvider;
    @Override
    public CompletableFuture<?> run(final CachedOutput cache) {
        Map<ResourceKey<EquipmentAsset>, EquipmentClientInfo> equipmentAssets = new HashMap();
        bootstrap((id, asset) -> {
            if (equipmentAssets.putIfAbsent(id, asset) != null) {
                throw new IllegalStateException("Tried to register equipment asset twice for id: " + String.valueOf(id));
            }
        });
        Codec var10001 = EquipmentClientInfo.CODEC;
        PackOutput.PathProvider var10002 = this.pathProvider;
        Objects.requireNonNull(var10002);
        return DataProvider.saveAll(cache, var10001, var10002::json, equipmentAssets);
    }

    @Override
    public String getName() {
        return "Base Mod Equipment Asset Provider";
    }


    public ModEquipmentAssetProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
        this.pathProvider = packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");
    }

    private static void bootstrap(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer) {
        acceptArmorAsset(consumer, "dragonite", ModArmorMaterials.DRAGONITE_KEY);
        acceptElytraAsset(consumer, "dragon_elytra", ModArmorMaterials.DRAGON_ELYTRA_KEY);
    }

    public static void acceptArmorAsset(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer, String name, ResourceKey<EquipmentAsset> armorMaterial) {
        consumer.accept(armorMaterial, EquipmentClientInfo.builder()
                        .addHumanoidLayers(Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, name))
                        .addLayers(EquipmentClientInfo.LayerType.HORSE_BODY, new EquipmentClientInfo.Layer(Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, name)))
                .build());
    }
    public static void acceptElytraAsset(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer, String name, ResourceKey<EquipmentAsset> armorMaterial) {
        consumer.accept(armorMaterial, EquipmentClientInfo.builder()
                .addLayers(EquipmentClientInfo.LayerType.WINGS, new EquipmentClientInfo.Layer(Identifier.fromNamespaceAndPath(DragonSCorpse.MOD_ID, name)))
                .build());
    }





}
