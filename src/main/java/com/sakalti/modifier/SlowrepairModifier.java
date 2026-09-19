package com.sakalti.modifier;
import net.minecraft.world.entity.LivingEntity; import net.minecraft.world.level.Level; import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.Modifier; import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
public class SlowrepairModifier extends Modifier { @Override public void onInventoryTick(IToolStackView tool,int level,Level world,LivingEntity e,int slot,boolean selected,boolean correct,ItemStack stack){if(world.isClientSide||tool.isBroken()||!stack.isDamaged()||e.tickCount%120!=0)return;stack.setDamageValue(Math.max(0,stack.getDamageValue()-1));}}
