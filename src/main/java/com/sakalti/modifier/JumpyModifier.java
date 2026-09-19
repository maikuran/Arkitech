package com.sakalti.modifier;
import net.minecraft.entity.effect.StatusEffects; import net.minecraft.entity.effect.StatusEffectInstance; import net.minecraft.entity.LivingEntity; import net.minecraft.world.World; import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.Modifier; import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
public class JumpyModifier extends Modifier { @Override public void onInventoryTick(IToolStackView tool,int level,World world,LivingEntity e,int slot,boolean selected,boolean correct,ItemStack stack){if(!world.isClient&&!tool.isBroken()&&correct)e.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,220,Math.max(0,level-1),false,true));}}
