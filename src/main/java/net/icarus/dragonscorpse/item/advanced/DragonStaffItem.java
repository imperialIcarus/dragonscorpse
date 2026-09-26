package net.icarus.dragonscorpse.item.advanced;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.hurtingprojectile.DragonFireball;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownEnderpearl;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class DragonStaffItem extends Item {
    public DragonStaffItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        Vec3 lookDirection = player.getLookAngle();
        if (player.isCrouching()) {
            level.playSound((Entity)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDER_DRAGON_GROWL, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
            if (level instanceof ServerLevel serverLevel) {
                Projectile.spawnProjectileUsingShoot((lvl, shooter, weapon) -> new DragonFireball(lvl, shooter, lookDirection),
                        serverLevel,
                        player.getItemInHand(hand),
                        player,
                        lookDirection.x,
                        lookDirection.y,
                        lookDirection.z,
                        3f,
                        0f);
            }
            player.getItemInHand(hand).hurtAndBreak(2, player, hand);
        } else {
            level.playSound((Entity)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
            if (level instanceof ServerLevel serverLevel) {
                Projectile.spawnProjectileFromRotation(ThrownEnderpearl::new, serverLevel, player.getItemInHand(hand), player, 0.0F, 1.5F, 1.0F);
            }
            player.getItemInHand(hand).hurtAndBreak(1, player, hand);
        }
        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResult.SUCCESS;
    }
}
