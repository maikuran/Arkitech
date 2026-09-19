package com.sakalti.modifier;
import net.minecraft.world.entity.LivingEntity; import net.minecraft.world.level.Level; import net.minecraft.world.phys.AABB; import slimeknights.tconstruct.library.modifiers.Modifier; import slimeknights.tconstruct.library.tools.context.ToolAttackContext; import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
public class LaserPrismModifier extends Modifier {
 @Override public int afterEntityHit(IToolStackView tool,int level,ToolAttackContext ctx,float damage){LivingEntity a=ctx.getAttacker();if(a!=null)applyLaserPrismEffect(a.level(),a,level);return 0;}
 public static void applyLaserPrismEffect(Level world,LivingEntity a,int level){if(world==null||world.isClientSide||a==null||level<=0)return;double r=8.0+level;float d=level;for(LivingEntity e:world.getEntitiesOfClass(LivingEntity.class,a.getBoundingBox().inflate(r),x->x!=a&&x.isAlive()))e.hurt(a.getDamageSources().magic(),d);}
}
