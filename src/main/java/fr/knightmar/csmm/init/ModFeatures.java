package fr.knightmar.csmm.init;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModFeatures {


    private ConfiguredFeature<?,?> ORE_BRONZE_FEARTURE;
    private ConfiguredFeature<?,?> ORE_PLATINUM_FEARTURE;


    public void init(){

        ORE_BRONZE_FEARTURE = register("ore_copper", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.BRONZE_ORE.get().getDefaultState(), 15))
                .square()
                .range(50)
                .count(20)
                .chance(100)

        );
        ORE_PLATINUM_FEARTURE = register("ore_platinum", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.PLATINIUM_BLOCK.get().getDefaultState(), 15)).square().range(50).chance(100)


        );
    }

    public <FC extends IFeatureConfig> ConfiguredFeature<FC,?> register(String name,ConfiguredFeature<FC,?>feature)
    {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, name, feature);

    }

    @SubscribeEvent
    public void biomeLoading(BiomeLoadingEvent e) {
        BiomeGenerationSettingsBuilder generation = e.getGeneration();

        //mettre biome souhaité ici

        if (e.getCategory() != Biome.Category.NETHER) {
            generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_BRONZE_FEARTURE);

        }
        if (e.getName().equals("platinum_biome")) {
            generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_PLATINUM_FEARTURE);
        }


    }
}