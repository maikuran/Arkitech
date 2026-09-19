package com.sakalti.modifier;
import net.minecraft.entity.LivingEntity; import net.minecraft.world.World; import net.minecraft.util.math.Box; import slimeknights.tconstruct.library.modifiers.Modifier; import slimeknights.tconstruct.library.tools.context.ToolAttackContext; import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
public class LaserPrismModifier extends Modifier {
 @Override public int afterEntityHit(IToolStackView tool,int level,ToolAttackContext ctx,float damage){LivingEntity a=ctx.getAttacker();if(a!=null)applyLaserPrismEffect(a.getWorld(),a,level);return 0;}
 public static void applyLaserPrismEffect(World world,LivingEntity a,int level){if(world==null||world.isClient||a==null||level<=0)return;double r=8.0+level;float d=level;for(LivingEntity e:world.getEntitiesByClass(LivingEntity.class,a.getBoundingBox().expand(r),x->x!=a&&x.isAlive()))e.damage(a.getDamageSources().magic(),d);}
}
