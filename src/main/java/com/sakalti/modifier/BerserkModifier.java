package com.sakalti.modifier;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
public class BerserkModifier extends Modifier {
  @Override public float getEntityDamage(IToolStackView tool,int level,ToolAttackContext ctx,float baseDamage,float damage){
    LivingEntity a=ctx.getAttacker(); if(level<=0||tool.isBroken()||a==null)return damage;
    if(RANDOM.nextFloat()<0.33f){if(!a.level().isClientSide)tool.setDamage(tool.getDamage()+2);return damage*3f;} return damage;
  }
}
