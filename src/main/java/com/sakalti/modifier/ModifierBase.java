package com.sakalti.modifier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;

import java.util.List;

final class ModifierBase {
  private ModifierBase() {}

  static LivingEntity firstInFront(LivingEntity attacker, double distance) {
    Vec3 dir = attacker.getViewVector(1.0F).normalize();
    Vec3 center = attacker.getEyePosition().add(dir.scale(distance));
    AABB box = new AABB(center.x - 0.75, center.y - 1.0, center.z - 0.75,
        center.x + 0.75, center.y + 1.0, center.z + 0.75);
    List<LivingEntity> entities = attacker.level().getEntitiesOfClass(LivingEntity.class, box,
        e -> e != attacker && e.isAlive());
    return entities.isEmpty() ? null : entities.get(0);
  }

  static void add(LivingEntity entity, net.minecraft.world.effect.MobEffect effect, int duration, int amplifier) {
    entity.addEffect(new MobEffectInstance(effect, duration, Math.max(0, amplifier), false, true));
  }
}
