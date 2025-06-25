package net.bcutty.tutorialmod;

import net.bcutty.tutorialmod.block.ModBlocks;
import net.bcutty.tutorialmod.item.ModItemGroups;
import net.bcutty.tutorialmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// Test
public class TutorialMod implements ModInitializer {
    public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 20000);
    }
}