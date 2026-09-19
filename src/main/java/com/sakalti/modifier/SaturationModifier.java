package com.sakalti.modifier;
import net.minecraft.entity.LivingEntity; import net.minecraft.entity.player.PlayerEntity; import net.minecraft.world.World; import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.Modifier; import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
public class SaturationModifier extends Modifier { @Override public void onInventoryTick(IToolStackView tool,int level,World world,LivingEntity e,int slot,boolean selected,boolean correct,ItemStack stack){if(world.isClient||tool.isBroken()||!correct||e.age%20!=0||!(e instanceof PlayerEntity p))return;p.getHungerManager().add(level,level*0.5f);}}
