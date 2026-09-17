package com.sakalti.moreweapons.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow
    protected int timeUntilRegen;

    @Inject(method = "tick", at = @At("HEAD"))
    private void moreweapons$removeInvulnerability(CallbackInfo ci) {
        this.timeUntilRegen = 0;
    }
}
