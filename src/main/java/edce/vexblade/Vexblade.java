package edce.vexblade;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Vexblade implements ModInitializer {
	public static final String MOD_ID = "vexblade";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		RiftstoneTool.InitalizeTools();
		Riftstone.InitalizeRiftstone();
		RiftstoneArmor.InitalizeRiftstoneArmor();
		ModBlocks.initalizeModBlocks();
		// Spawns everywhere in the overworld
		BiomeModifications.addFeature(
				BiomeSelectors.foundInOverworld(),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				ModWorldPlacedFeatures.RIFTSTONE_ORE_PLACED_KEY
		);
	}
}