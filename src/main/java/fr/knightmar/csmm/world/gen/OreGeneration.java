package fr.knightmar.csmm.world.gen;


import fr.knightmar.csmm.init.BiomeInit;
import fr.knightmar.csmm.init.ModBlocks;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;


public class OreGeneration
{
    @SubscribeEvent
    public void generateOres(final @NotNull BiomeLoadingEvent event)
    {
        if(event.getCategory() != Biome.BiomeCategory.THEEND && event.getCategory() != Biome.BiomeCategory.NETHER)
            this.generateBronzeOre(event);
    }

    private void generateBronzeOre(@NotNull BiomeLoadingEvent event)
    {
        event.getGeneration()
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Feature.ORE
                        .configured(new OreConfiguration(List.of(
                                OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, ModBlocks.BRONZE_ORE.get().defaultBlockState()),
                                OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.BRONZE_ORE.get().defaultBlockState())), 8))
                        .rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(20))
                        .squared()
                );
    }
}