package com.sakalti.modifier;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;

import java.util.List;

final class ModifierBase {
  private ModifierBase() {}

  static LivingEntity firstInFront(LivingEntity attacker, double distance) {
    Vec3d dir = attacker.getRotationVec(1.0F).normalize();
    Vec3d center = attacker.getEyePos().add(dir.scale(distance));
    Box box = new Box(center.x - 0.75, center.y - 1.0, center.z - 0.75,
        center.x + 0.75, center.y + 1.0, center.z + 0.75);
    List<LivingEntity> entities = attacker.getWorld().getEntitiesByClass(LivingEntity.class, box,
        e -> e != attacker && e.isAlive());
    return entities.isEmpty() ? null : entities.get(0);
  }

  static void add(LivingEntity entity, net.minecraft.entity.effect.StatusEffect effect, int duration, int amplifier) {
    entity.addStatusEffect(new StatusEffectInstance(effect, duration, Math.max(0, amplifier), false, true));
  }
}
