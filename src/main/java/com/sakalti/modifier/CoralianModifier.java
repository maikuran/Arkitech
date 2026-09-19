package com.sakalti.modifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
public class CoralianModifier extends Modifier {
  @Override public void onInventoryTick(IToolStackView tool,int level,Level world,LivingEntity entity,int itemSlot,boolean isSelected,boolean isCorrectSlot,ItemStack stack){
    if(world.isClientSide||tool.isBroken()||!isCorrectSlot)return; entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING,220,0,false,true));
  }
}
