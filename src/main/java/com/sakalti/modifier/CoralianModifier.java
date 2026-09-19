package com.sakalti.modifier;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
public class CoralianModifier extends Modifier {
  @Override public void onInventoryTick(IToolStackView tool,int level,World world,LivingEntity entity,int itemSlot,boolean isSelected,boolean isCorrectSlot,ItemStack stack){
    if(world.isClient||tool.isBroken()||!isCorrectSlot)return; entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING,220,0,false,true));
  }
}
