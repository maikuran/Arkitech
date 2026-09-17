package com.sakalti.modifier;
import net.minecraft.world.entity.LivingEntity; import net.minecraft.world.level.Level; import slimeknights.tconstruct.library.modifiers.Modifier; import slimeknights.tconstruct.library.tools.context.ToolAttackContext; import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
public class FireWallModifier extends Modifier {
 @Override public int afterEntityHit(IToolStackView tool,int level,ToolAttackContext ctx,float damage){LivingEntity a=ctx.getAttacker();if(a!=null)applyFireWallEffect(a.level(),a,level);return 0;}
 public static void applyFireWallEffect(Level world,LivingEntity a,int level){if(world==null||world.isClientSide||a==null||level<=0)return;double r=2.0+level;float d=2f*level;for(LivingEntity e:world.getEntitiesOfClass(LivingEntity.class,a.getBoundingBox().inflate(r),x->x!=a&&x.isAlive()))e.hurt(a.damageSources().inFire(),d);}
}
