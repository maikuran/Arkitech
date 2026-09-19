package com.sakalti;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.minecraft.client.Minecraft;

public final class SakaltiClient implements ClientModInitializer {

    private static boolean reloaded;

    @Override
    public void onInitializeClient() {
        ClientLifecycleEvents.CLIENT_STARTED.register(SakaltiClient::tryReload);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (!reloaded) {
                tryReload(client);
            }
        });
    }

    private static void tryReload(Minecraft client) {
        if (reloaded || RendererAccess.INSTANCE.getRenderer() == null) {
            return;
        }

        reloaded = true;
        client.reloadResourcePacks();
    }
}
