package com.sakalti.modifier;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public final class SakaltiModifiers {
  private static final ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create("sakalti");
  public static final StaticModifier<Modifier> AURO_VISION = MODIFIERS.register("auro_vision", AuroVisionModifier::new);
  public static final StaticModifier<Modifier> BERSERK = MODIFIERS.register("berserk", BerserkModifier::new);
  public static final StaticModifier<Modifier> CELESTITE_RESONANCE = MODIFIERS.register("celestite_resonance", CelestiteResonanceModifier::new);
  public static final StaticModifier<Modifier> CORALIAN = MODIFIERS.register("coralian", CoralianModifier::new);
  public static final StaticModifier<Modifier> FIELDY = MODIFIERS.register("fieldy", FieldyModifier::new);
  public static final StaticModifier<Modifier> FIRE_WALL = MODIFIERS.register("fire_wall", FireWallModifier::new);
  public static final StaticModifier<Modifier> GLACIAL_BIND = MODIFIERS.register("glacial_bind", GlacialBindModifier::new);
  public static final StaticModifier<Modifier> HEAVY_STONE = MODIFIERS.register("heavy_stone", HeavyStoneModifier::new);
  public static final StaticModifier<Modifier> ICE_BIND = MODIFIERS.register("ice_bind", IceBindModifier::new);
  public static final StaticModifier<Modifier> ITSULIC_NIHILISM = MODIFIERS.register("itsulic_nihilism", ItsulicNihilismModifier::new);
  public static final StaticModifier<Modifier> JUMPY = MODIFIERS.register("jumpy", JumpyModifier::new);
  public static final StaticModifier<Modifier> LASER_PRISM = MODIFIERS.register("laser_prism", LaserPrismModifier::new);
  public static final StaticModifier<Modifier> LIFESTEAL = MODIFIERS.register("lifesteal", LifestealModifier::new);
  public static final StaticModifier<Modifier> LIGHT_TOUCH = MODIFIERS.register("light_touch", LightTouchModifier::new);
  public static final StaticModifier<Modifier> LONG_SPARK = MODIFIERS.register("long_spark", LongsparkModifier::new);
  public static final StaticModifier<Modifier> LUCKY = MODIFIERS.register("lucky", LuckyModifier::new);
  public static final StaticModifier<Modifier> LURE_METEOR = MODIFIERS.register("lure_meteor", LureMeteorModifier::new);
  public static final StaticModifier<Modifier> POISONOUS_BIND = MODIFIERS.register("poisonous_bind", PoisonousBindModifier::new);
  public static final StaticModifier<Modifier> SATURATION = MODIFIERS.register("saturation", SaturationModifier::new);
  public static final StaticModifier<Modifier> SEIREN_CURSE = MODIFIERS.register("seiren_curse", SeirenCurseModifier::new);
  public static final StaticModifier<Modifier> SLOWREPAIR = MODIFIERS.register("slowrepair", SlowrepairModifier::new);
  public static final StaticModifier<Modifier> SUPERMAGNET = MODIFIERS.register("supermagnet", SuperMagnetModifier::new);
  public static final StaticModifier<Modifier> UNSTABLE = MODIFIERS.register("unstable", UnstableModifier::new);
  public static final StaticModifier<Modifier> WEAK_BURN = MODIFIERS.register("weak_burn", WeakBurnModifier::new);

  public static void init() { MODIFIERS.register(); }
  private SakaltiModifiers() {}
}
