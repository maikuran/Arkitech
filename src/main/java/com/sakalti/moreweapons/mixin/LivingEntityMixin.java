package com.sakalti.moreweapons.mixin;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Shadow
    private int timeUntilRegen;

    @Inject(method = "tick", at = @At("HEAD"))
    private void removeInvulnerability(CallbackInfo ci) {
        this.timeUntilRegen = 0;
    }
}
