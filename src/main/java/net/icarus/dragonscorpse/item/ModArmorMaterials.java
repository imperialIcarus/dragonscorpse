package net.icarus.dragonscorpse.item;

import com.google.common.collect.Maps;
import net.icarus.dragonscorpse.DragonSCorpse;
import net.icarus.dragonscorpse.tags.ModTags;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.Map;

public class ModArmorMaterials {
    public static final ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = ResourceKey.createRegistryKey(
            Identifier.withDefaultNamespace("equipment_asset"));

    public static final ResourceKey<EquipmentAsset> DRAGONITE_KEY = createRK("dragonite");

    public static final ArmorMaterial DRAGONITE_ARMOR_MATERAL = new ArmorMaterial(
            43,
            ArmorMaterials.makeDefense(5, 8, 10, 5, 28),
            15,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            4.0f,
            0.2f,
            ModTags.Items.DRAGONITE_REPAIR,
            DRAGONITE_KEY
    );


    public static ResourceKey<EquipmentAsset> createRK(String name) {
        return ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(name, DragonSCorpse.MOD_ID));
    }


}
