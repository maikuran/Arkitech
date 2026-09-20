package com.sakalti.moreweapons.traits;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class PiercingDamage {

    private final int level;

    public PiercingDamage(int level) {
        this.level = Math.max(0, level);
    }

    public int getLevel() {
        return this.level;
    }

    /**
     * Piercingによるダメージ倍率。
     *
     * Lv1: 1.02
     * Lv2: 1.12
     * Lv3: 1.72
     * Lv4: 5.32
     */
    public double getDamageMultiplier() {
        if (this.level <= 0) {
            return 1.0;
        }

        return 1.0 + 0.02 * Math.pow(6.0, this.level - 1);
    }

    /**
     * 基礎ダメージからPiercing適用後のtargetDamageを計算する。
     */
    public float calculateTargetDamage(double baseDamage) {
        if (baseDamage <= 0.0) {
            return 0.0F;
        }

        return (float) (baseDamage * getDamageMultiplier());
    }

    /**
     * Piercingによる防具の追加耐久消費。
     *
     * Lv1: 1
     * Lv2: 2
     * Lv3: 4
     * Lv4: 8
     */
    public int getDurabilityCost() {
        if (this.level <= 0) {
            return 0;
        }

        return (int) Math.pow(2.0, this.level - 1);
    }

    /**
     * ターゲットの装備している防具へPiercing分の
     * 追加耐久消費を適用する。
     */
    public void damageArmor(LivingEntity target) {
        if (target == null || this.level <= 0) {
            return;
        }

        int cost = getDurabilityCost();

        for (ItemStack armorStack : target.getArmorItems()) {
            if (armorStack.isEmpty()) {
                continue;
            }

            armorStack.damage(cost, target, entity -> {
                entity.sendEquipmentBreakStatus(
                    entity.getPreferredEquipmentSlot(armorStack)
                );
            });
        }
    }
}
