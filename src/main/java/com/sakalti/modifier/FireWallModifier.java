package com.sakalti.modifier;
import net.minecraft.entity.LivingEntity; import net.minecraft.world.World; import slimeknights.tconstruct.library.modifiers.Modifier; import slimeknights.tconstruct.library.tools.context.ToolAttackContext; import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
public class FireWallModifier extends Modifier {
 @Override public int afterEntityHit(IToolStackView tool,int level,ToolAttackContext ctx,float damage){LivingEntity a=ctx.getAttacker();if(a!=null)applyFireWallEffect(a.getWorld(),a,level);return 0;}
 public static void applyFireWallEffect(World world,LivingEntity a,int level){if(world==null||world.isClient||a==null||level<=0)return;double r=2.0+level;float d=2f*level;for(LivingEntity e:world.getEntitiesByClass(LivingEntity.class,a.getBoundingBox().expand(r),x->x!=a&&x.isAlive()))e.damage(a.getDamageSources().inFire(),d);}
}
