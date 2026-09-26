package net.icarus.dragonscorpse.item.advanced;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;

import static net.minecraft.world.item.MaceItem.canSmashAttack;

public class DragonMaceItem extends Item {
    public DragonMaceItem(Properties properties) {
        super(properties);
    }

    public static ItemAttributeModifiers getDragonMaceAttributeModifiers() {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (double)10.0F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, (double)-3.4F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }

    @Override
    public float getAttackDamageBonus(Entity victim, float ignoredDamage, DamageSource damageSource) {
        Entity var5 = damageSource.getDirectEntity();
        if (var5 instanceof LivingEntity attacker) {
            if (!canSmashAttack(attacker)) {
                return 0.0F;
            } else {
                double fallHeightThreshold1 = (double)3.0F;
                double fallHeightThreshold2 = (double)8.0F;
                double fallDistance = attacker.fallDistance;
                double damage;
                if (fallDistance <= (double)3.0F) {
                    damage = (double)6.0F * fallDistance;
                } else if (fallDistance <= (double)8.0F) {
                    damage = (double)18.0F + (double)3.0F * (fallDistance - (double)3.0F);
                } else {
                    damage = (double)33.0F + fallDistance - (double)8.0F;
                }

                Level var14 = attacker.level();
                if (var14 instanceof ServerLevel) {
                    ServerLevel level = (ServerLevel)var14;
                    return (float)(damage + (double) EnchantmentHelper.modifyFallBasedDamage(level, attacker.getWeaponItem(), victim, damageSource, 0.0F) * fallDistance);
                } else {
                    return (float)damage;
                }
            }
        } else {
            return 0.0F;
        }
    }

}
