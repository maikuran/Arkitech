package com.sakalti.modifier;
import net.minecraft.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
public class UnstableModifier extends Modifier {
  @Override public float getEntityDamage(IToolStackView tool,int level,ToolAttackContext ctx,float baseDamage,float damage){
    LivingEntity a=ctx.getAttacker(); if(level<=0||tool.isBroken()||a==null)return damage;
    float r=1f+a.getRandom().nextFloat()*3.4f; int cost=r<2?0:r<3?1:r<4?2:r<4.4f?3:4;
    if(!a.getWorld().isClient&&cost>0)tool.setDamage(tool.getDamage()+cost); return damage*r;
  }
}
