package com.sakalti.mixin;

import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.minecraft.server.packs.resources.ResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import slimeknights.tconstruct.library.client.modifiers.ModifierModelManager;

@Mixin(ModifierModelManager.class)
public abstract class ModifierModelManagerMixin {

    @Inject(
            method = "onReloadSafe",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void sakalti$waitForRenderer(
            ResourceManager resourceManager,
            CallbackInfo ci
    ) {
        if (RendererAccess.INSTANCE.getRenderer() == null) {
            ci.cancel();
        }
    }
}
