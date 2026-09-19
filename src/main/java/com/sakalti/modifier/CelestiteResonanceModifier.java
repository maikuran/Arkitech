package com.sakalti.modifier;
import net.minecraft.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
public class CelestiteResonanceModifier extends Modifier {
  @Override public float getEntityDamage(IToolStackView tool,int level,ToolAttackContext ctx,float baseDamage,float damage){
    LivingEntity t=ctx.getLivingTarget(); if(t==null)return damage; float max=t.getMaxHealth(); float ratio=max>0?t.getHealth()/max:0; return damage*(1f+0.15f*level*ratio);
  }
  @Override public int afterEntityHit(IToolStackView tool,int level,ToolAttackContext ctx,float damage){return 0;}
}
