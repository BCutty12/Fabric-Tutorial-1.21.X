package net.bcutty.tutorialmod.item;

import net.bcutty.tutorialmod.TutorialMod;
import net.bcutty.tutorialmod.item.custom.ChiselItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));
    public static final Item INFINERITE_INGOT = registerItem("infinerite_ingot", new Item(new Item.Settings()));
    public static final Item RAW_INFINERITE = registerItem("raw_infinerite", new Item(new Item.Settings()));
    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        TutorialMod.LOGGER.info("Register Modded Items for " +  TutorialMod.MOD_ID);
    }
}
