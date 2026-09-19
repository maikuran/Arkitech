package com.sakalti.modifier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class HeavyStoneModifier extends Modifier {

    @Override
    public int afterEntityHit(
            IToolStackView tool,
            int level,
            ToolAttackContext ctx,
            float damage
    ) {
        LivingEntity attacker = ctx.getAttacker();

        if (attacker != null && !attacker.level().isClientSide) {
            attacker.addEffect(new MobEffectInstance(
                    MobEffects.MOVEMENT_SLOWDOWN,
                    100,
                    4
            ));

            attacker.addEffect(new MobEffectInstance(
                    MobEffects.DAMAGE_RESISTANCE,
                    100,
                    2
            ));
        }

        return 0;
    }
}
