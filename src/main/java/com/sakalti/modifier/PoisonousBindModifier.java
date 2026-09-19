package com.sakalti.modifier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class PoisonousBindModifier extends Modifier {
    @Override
    public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext ctx, float damage) {
        if (level <= 0 || ctx == null) {
            return 0;
        }

        LivingEntity target = ctx.getLivingTarget();
        if (target == null || !target.isAlive() || target.level().isClientSide) {
            return 0;
        }

        target.addEffect(new MobEffectInstance(
                MobEffects.POISON,
                100,
                level - 1
        ));
        return 0;
    }
}
