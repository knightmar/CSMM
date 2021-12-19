package fr.knightmar.csmm.init;


import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Objects;

public class ModFeatures {
    private ConfiguredFeature<?, ?> ORE_BRONZE_FEARTURE;
    private ConfiguredFeature<?, ?> ORE_PLATINUM_FEARTURE;
    public void init() {
        ORE_BRONZE_FEARTURE = register("ore_bronze", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.BRONZE_ORE.get().defaultBlockState(), 5))
                .squared()
                .count(10))
                .decorated(Placement.DEPTH_AVERAGE.configured(new DepthAverageConfig(38,20)));

        ORE_PLATINUM_FEARTURE = register("ore_platinum", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.PLATINIUM_BLOCK.get().defaultBlockState(), 15)).squared().range(50).chance(100)


        );
    }
    public <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> feature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, name, feature);

    }

    @SubscribeEvent
    public void biomeLoading(BiomeLoadingEvent e) {
        BiomeGenerationSettingsBuilder generation = e.getGeneration();

        //mettre biome souhaité ici

        if (e.getCategory() != Biome.Category.NETHER) {
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_BRONZE_FEARTURE);

        }



    }
}