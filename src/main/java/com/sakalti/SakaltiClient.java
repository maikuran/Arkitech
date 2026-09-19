package com.sakalti;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.renderer.v1.Renderer;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;

public final class SakaltiClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerFallbackRenderer();
    }

    private static void registerFallbackRenderer() {
        if (RendererAccess.INSTANCE.getRenderer() != null) {
            return;
        }

        try {
            Class<?> rendererClass = Class.forName(
                    "net.fabricmc.fabric.impl.client.indigo.renderer.IndigoRenderer"
            );

            Object renderer = rendererClass.getField("INSTANCE").get(null);

            if (renderer instanceof Renderer) {
                try {
                    RendererAccess.INSTANCE.registerRenderer((Renderer) renderer);
                } catch (UnsupportedOperationException ignored) {
                    // Another renderer won the registration race.
                }
            }
        } catch (ReflectiveOperationException ignored) {
            // Indigo is not available; leave renderer selection to the installed renderer implementation.
        }
    }
}
