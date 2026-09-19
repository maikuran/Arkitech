package com.sakalti.modifier;
import net.minecraft.entity.LivingEntity; import net.minecraft.world.World; import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.Modifier; import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
public class SlowrepairModifier extends Modifier { @Override public void onInventoryTick(IToolStackView tool,int level,World world,LivingEntity e,int slot,boolean selected,boolean correct,ItemStack stack){if(world.isClient||tool.isBroken()||!stack.isDamaged()||e.age%120!=0)return;stack.setDamage(Math.max(0,stack.getDamage()-1));}}
