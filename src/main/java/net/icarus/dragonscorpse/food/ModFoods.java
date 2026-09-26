package net.icarus.dragonscorpse.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.List;

public class ModFoods {
        // Raw Food Properties and Consumable
        public static final FoodProperties DRAGON_RAW = new FoodProperties.Builder().nutrition(4).saturationModifier(0.1f).build();
        public static final Consumable DRAGON_RAW_CONSUMABLE = Consumables.defaultFood()
                .onConsume(new ApplyStatusEffectsConsumeEffect(List.of(new MobEffectInstance(MobEffects.POISON, 30, 3), new MobEffectInstance(MobEffects.WITHER, 30, 3))))
                .build();
        // Cooked Food Properties and Consumable
        public static final FoodProperties DRAGON_COOKED = new FoodProperties.Builder().nutrition(10).saturationModifier(1.2f).alwaysEdible().build();
        public static final Consumable DRAGON_COOKED_CONSUMABLE = Consumables.defaultFood()
                .onConsume(new ApplyStatusEffectsConsumeEffect(List.of(new MobEffectInstance(MobEffects.STRENGTH, 30, 2), new MobEffectInstance(MobEffects.SPEED, 30, 2))))
                .build();
}
