package com.sakalti.modifier;
import net.minecraft.world.entity.LivingEntity; import slimeknights.tconstruct.library.modifiers.Modifier; import slimeknights.tconstruct.library.tools.context.ToolAttackContext; import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
public class LureMeteorModifier extends Modifier { @Override public int afterEntityHit(IToolStackView tool,int level,ToolAttackContext ctx,float damage){LivingEntity t=ctx.getLivingTarget();if(t!=null&&!t.level().isClientSide)t.hurt(t.damageSources().magic(),6f*level);return 0;}}
