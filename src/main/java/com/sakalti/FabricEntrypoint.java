package com.sakalti;

import net.fabricmc.api.ModInitializer;

public final class FabricEntrypoint implements ModInitializer {
  @Override public void onInitialize() { SakaltiFabric.init(); }
}
