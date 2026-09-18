package com.sakalti;

import com.sakalti.modifier.SakaltiModifiers;
import com.sakalti.modifier.ItsulicNihilismModifier;
import com.sakalti.worldgen.SakaltiWorldgen;

public final class SakaltiFabric {
  public static final String MOD_ID = "sakalti";
  private SakaltiFabric() {}
  public static void init() {
    SakaltiContent.init();
    SakaltiModifiers.init();
    ItsulicNihilismModifier.initEvents();
    SakaltiWorldgen.init();
  }
}
