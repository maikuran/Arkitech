package com.sakalti.modifier;
import net.minecraft.world.effect.MobEffects; import net.minecraft.world.effect.MobEffectInstance; import net.minecraft.world.entity.LivingEntity; import net.minecraft.world.level.Level; import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.Modifier; import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
public class JumpyModifier extends Modifier { @Override public void onInventoryTick(IToolStackView tool,int level,Level world,LivingEntity e,int slot,boolean selected,boolean correct,ItemStack stack){if(!world.isClientSide&&!tool.isBroken()&&correct)e.addEffect(new MobEffectInstance(MobEffects.JUMP,220,Math.max(0,level-1),false,true));}}
