package com.sakalti.modifier;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import java.util.Random;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class LuckyModifier extends Modifier {
    private static final Random RANDOM = new Random();

    @Override
    public void onInventoryTick(
            IToolStackView tool,
            int level,
            Level world,
            LivingEntity entity,
            int slot,
            boolean selected,
            boolean correct,
            ItemStack stack
    ) {
        if (world == null || world.isClientSide || tool == null || stack == null
                || !correct || tool.isBroken()) {
            return;
        }

        CompoundTag tag = stack.getOrCreateTag();
        int timer = tag.getInt("SakaltiLuckyTimer");
        int limit = tag.getInt("SakaltiLuckyLimit");

        if (limit < 20 || limit > 7200) {
            limit = 20 + RANDOM.nextInt(7181);
        }

        timer++;
        if (timer >= limit) {
            tool.setDamage(0);
            timer = 0;
            limit = 20 + RANDOM.nextInt(7181);
        }

        tag.putInt("SakaltiLuckyTimer", timer);
        tag.putInt("SakaltiLuckyLimit", limit);
        stack.setTag(tag);
    }
}
