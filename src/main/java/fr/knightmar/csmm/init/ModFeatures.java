package fr.knightmar.csmm.init;

import fr.knightmar.csmm.blocks.BlockCopperOre;
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


    private ConfiguredFeature<?,?> ORE_COPPER_FEARTURE;

    public void init(){

        ORE_COPPER_FEARTURE = register("ore_copper", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.COPPER_ORE.get().getDefaultState(), 15))
                .square()
                .range(50)
                );
   }

   public <FC extends IFeatureConfig> ConfiguredFeature<FC,?> register(String name,ConfiguredFeature<FC,?>feature)
   {
      return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, name, feature);

   }

   @SubscribeEvent
    public void biomeLoading(BiomeLoadingEvent e){
       BiomeGenerationSettingsBuilder generation = e.getGeneration();

       //mettre biome souhaité ici

       if (e.getCategory() != Biome.Category.NETHER){
           generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ORE_COPPER_FEARTURE);
       }
   }





}