package fr.knightmar.csmm.init;

import fr.knightmar.csmm.Main;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Main.MODID);

    public static final RegistryObject<Biome> PLATINUM_BIOME = BIOMES.register("platinum_biome", () -> makeTestBiome(1F, 1F, 0.3F));

    public static Biome makeTestBiome(float depth, float scale, float temperature) {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.farmAnimals(mobspawninfo$builder);
        mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(ModEntityType.HOG.get(), 8, 4, 4));
        mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(ModEntityType.CROCO.get(), 100, 1, 3));
        mobspawninfo$builder.addSpawn(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.GHAST, 7, 4, 10));

        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SurfacesBuilderInit.TEST);
        DefaultBiomeFeatures.addDefaultOverworldLandStructures(biomegenerationsettings$builder);
        biomegenerationsettings$builder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
        DefaultBiomeFeatures.addDefaultCarvers(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultLakes(biomegenerationsettings$builder);

        return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.PLAINS).depth(depth).scale(scale).temperature(temperature).downfall(1F).specialEffects((new BiomeAmbience.Builder()).waterColor(12386452).waterFogColor(12386452).fogColor(25343).skyColor(12255487/*getSkyColorWithTemperatureModifier(temperature)*/).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
    }


    private static int getSkyColorWithTemperatureModifier(float temperature) {
        float lvt_1_1_ = temperature / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }


}
