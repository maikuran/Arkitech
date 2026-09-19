package com.sakalti.modifier;
import net.minecraft.entity.LivingEntity; import slimeknights.tconstruct.library.modifiers.Modifier; import slimeknights.tconstruct.library.tools.context.ToolAttackContext; import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
public class IceBindModifier extends Modifier {
 @Override public int afterEntityHit(IToolStackView tool,int level,ToolAttackContext ctx,float damage){LivingEntity a=ctx.getAttacker();if(a==null||a.getWorld().isClient)return 0;double[] ds={10,8,6,4,2};float[] vals={6,5,4,3,2};for(int i=0;i<ds.length;i++){LivingEntity t=ModifierBase.firstInFront(a,ds[i]);if(t!=null){t.damage(a.getDamageSources().mobAttack(a),vals[i]*(1.5f+level));break;}}return 0;}
}
