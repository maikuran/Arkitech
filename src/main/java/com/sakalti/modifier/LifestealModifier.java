package com.sakalti.modifier;
import net.minecraft.entity.LivingEntity; import slimeknights.tconstruct.library.modifiers.Modifier; import slimeknights.tconstruct.library.tools.context.ToolAttackContext; import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
public class LifestealModifier extends Modifier { @Override public int afterEntityHit(IToolStackView tool,int level,ToolAttackContext ctx,float damage){LivingEntity a=ctx.getAttacker();if(a!=null&&!a.getWorld().isClient&&level>0)a.heal(a.getMaxHealth()*0.08f*level);return 0;}}
