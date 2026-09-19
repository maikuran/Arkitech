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
        LivingEntity target = ctx.getLivingTarget();
        if (target != null && !target.level().isClientSide) {
            target.addEffect(new MobEffectInstance(
                    MobEffects.POISON,
                    100,
                    Math.max(0, level - 1)
            ));
        }
        return 0;
    }
}
