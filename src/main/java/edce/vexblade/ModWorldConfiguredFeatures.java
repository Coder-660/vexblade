package edce.vexblade;
import edce.vexblade.Vexblade;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.Main;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;


public class ModWorldConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> RIFTSTONE_ORE_VEIN_CONFIGURED_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Identifier.fromNamespaceAndPath(Vexblade.MOD_ID, "riftstone_ore_vein")
            );
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEEPSLATE_RIFTSTONE_ORE_VEIN_CONFIGURED_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Identifier.fromNamespaceAndPath(Vexblade.MOD_ID, "deepslate_riftstone_ore_vein")
            );

    public static void configure(BootstrapContext<ConfiguredFeature<?, ?>> context) {


        RuleTest StoneReplaceableRule = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest DeepslateReplaceableRule = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> RiftstoneOreConfig =
                List.of(
                        OreConfiguration.target(StoneReplaceableRule, Riftstone.RIFTSTONE_ORE.defaultBlockState())
                );
        List<OreConfiguration.TargetBlockState> DeepslateRiftstoneOreConfig =
                List.of(
                        OreConfiguration.target(DeepslateReplaceableRule, Riftstone.DEEPSLATE_RIFTSTONE_ORE.defaultBlockState())
                );

        context.register(
                RIFTSTONE_ORE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(RiftstoneOreConfig, 3)) // 3 is the blocks per vein, 3 is pretty good.
        );

        context.register(
                DEEPSLATE_RIFTSTONE_ORE_VEIN_CONFIGURED_KEY,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreConfiguration(RiftstoneOreConfig, 3)) // 3 is the blocks per vein, 3 is pretty good.
        );
    }
}
