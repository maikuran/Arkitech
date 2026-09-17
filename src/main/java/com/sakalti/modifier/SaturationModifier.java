package com.sakalti.modifier;
import net.minecraft.world.entity.LivingEntity; import net.minecraft.world.entity.player.Player; import net.minecraft.world.level.Level; import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.Modifier; import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
public class SaturationModifier extends Modifier { @Override public void onInventoryTick(IToolStackView tool,int level,Level world,LivingEntity e,int slot,boolean selected,boolean correct,ItemStack stack){if(world.isClientSide||tool.isBroken()||!correct||e.tickCount%20!=0||!(e instanceof Player p))return;p.getFoodData().eat(level,level*0.5f);}}
