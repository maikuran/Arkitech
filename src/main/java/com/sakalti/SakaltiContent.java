package com.sakalti;

import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.AbstractBlock;

import java.util.LinkedHashSet;
import java.util.Set;

public final class SakaltiContent {
  private static final Set<String> BLOCK_NAMES = new LinkedHashSet<>();
  private static final Set<String> ITEM_NAMES = new LinkedHashSet<>();

  static {
    String[] blocks = {"aurostone_block","chiisteel_block","chirite_block","chirite_ore","coral_block","deepsteel_block","dilonite_block","hachilite_block","hachilite_ore","herdyeen_block","hirolite_block","hirolite_ore","hiroswari_block","hotalite_block","igniz_block","igniz_ore","ioxium_block","itsulite_block","kanilite_block","kanilite_ore","marulite_block","momongaite_block","momongaite_ore","ostlum_block","ostlum_ore","ourite_block","ourite_ore","ouswari_block","proxia_block","seiren_block","seiren_ore","soralite_block","stannoidea_block","stannoidea_ore","tiberium_block","tiberium_ore"};
    for(String s:blocks) BLOCK_NAMES.add(s);
    String[] items = {"aurostone_ingot","chiisteel_ingot","chirite_ingot","coral_ingot","deepchunk","deepsteel_ingot","dilonite_ingot","hachilite","hachilite_ingot","health_crystal","herdyeen_ingot","hirolite_ingot","hiroswari_ingot","hotalite_ingot","igniz_ingot","ioxium_ingot","itsulite_ingot","kanilite_ingot","marulite_ingot","momongaite_ingot","ostlum_ingot","ourite","ourite_ingot","ouswari_ingot","proxia_ingot","raw_chirite","raw_hachilite","raw_igniz","raw_kanilite","raw_momongaite","seiren_ingot","soralite_ingot","stannoidea_ingot","tiberium_ingot","tiberite_ingot","sakalti"};
    for(String s:items) ITEM_NAMES.add(s);
  }

  public static void init() {
    for(String id: BLOCK_NAMES) {
      Block base = id.endsWith("_ore") ? Blocks.IRON_ORE : Blocks.IRON_BLOCK;
      Block b = new Block(AbstractBlock.Settings.copy(base));
      Registry.register(Registries.BLOCK, new Identifier(SakaltiFabric.MOD_ID,id), b);
      Registry.register(Registries.ITEM, new Identifier(SakaltiFabric.MOD_ID,id), new BlockItem(b,new Item.Settings()));
    }
    for(String id: ITEM_NAMES) {
      if(!Registries.ITEM.containsId(new Identifier(SakaltiFabric.MOD_ID,id)))
        Registry.register(Registries.ITEM,new Identifier(SakaltiFabric.MOD_ID,id),new Item(new Item.Settings()));
    }
  }
  private SakaltiContent() {}
}
