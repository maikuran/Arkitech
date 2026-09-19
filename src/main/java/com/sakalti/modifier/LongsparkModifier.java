package com.sakalti.modifier;
import net.minecraft.entity.LivingEntity; import slimeknights.tconstruct.library.modifiers.Modifier; import slimeknights.tconstruct.library.tools.context.ToolAttackContext; import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
public class LongsparkModifier extends Modifier {
 @Override public int afterEntityHit(IToolStackView tool,int level,ToolAttackContext ctx,float damage){LivingEntity a=ctx.getAttacker();if(a==null||a.getWorld().isClient)return 0;double[] ds={10,8,6,4,2};for(double d:ds){LivingEntity t=ModifierBase.firstInFront(a,d);if(t!=null){float v=d==10?5.15f*(2+level):d==8?3.15f*(1.6f+level):d==6?2.15f*(1.6f+level):d==4?1.15f*(1.5f+level):0.5f*(1.5f+level);t.damage(a.getDamageSources().mobAttack(a),v);break;}}return 0;}
}
