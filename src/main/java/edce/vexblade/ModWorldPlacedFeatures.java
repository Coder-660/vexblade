package edce.vexblade;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.placement.*;


import java.util.List;

public class ModWorldPlacedFeatures {

    public static final ResourceKey<PlacedFeature> RIFTSTONE_ORE_PLACED_KEY =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    Identifier.fromNamespaceAndPath(Vexblade.MOD_ID, "riftstone_ore_placed")
            );

    public static final ResourceKey<PlacedFeature> DEEPSLATE_RIFTSTONE_ORE_PLACED_KEY =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    Identifier.fromNamespaceAndPath(Vexblade.MOD_ID, "deepslate_riftstone_ore_placed")
            );

    public static void configure(BootstrapContext<PlacedFeature> context) {

        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        List<PlacementModifier> riftstoneOreVeinModifiers = List.of(
                CountPlacement.of(6),
                BiomeFilter.biome(),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(0), VerticalAnchor.absolute(22)))
        );

        List<PlacementModifier> deepslate_RiftstoneOreVeinModifiers = List.of(
                CountPlacement.of(6),
                BiomeFilter.biome(),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.BOTTOM, VerticalAnchor.absolute(0)))
        );

        context.register(
                RIFTSTONE_ORE_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModWorldConfiguredFeatures.RIFTSTONE_ORE_VEIN_CONFIGURED_KEY),
                        riftstoneOreVeinModifiers
                )
        );
        context.register(
                DEEPSLATE_RIFTSTONE_ORE_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModWorldConfiguredFeatures.DEEPSLATE_RIFTSTONE_ORE_VEIN_CONFIGURED_KEY),
                        riftstoneOreVeinModifiers
                )
        );
    }
}
