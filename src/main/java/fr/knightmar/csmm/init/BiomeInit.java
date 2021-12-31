package fr.knightmar.csmm.init;

import com.mojang.serialization.Codec;
import fr.knightmar.csmm.Main;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.util.Mth;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class BiomeInit {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Main.MODID);

    public static final RegistryObject<Biome> PLATINUM_BIOME = BIOMES.register("platinum_biome", () -> makeTestBiome(1F, 1F, 0.3F));

    public static Biome makeTestBiome(float depth, float scale, float temperature) {
        MobSpawnSettings.Builder mobspawninfo$builder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(mobspawninfo$builder);
        mobspawninfo$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntityType.CROCO.get(), 10, 1, 3));
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SurfacesBuilderInit.TEST);
        BiomeDefaultFeatures.addDefaultOverworldLandStructures(biomegenerationsettings$builder);
//        biomegenerationsettings$builder.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
        BiomeDefaultFeatures.addDefaultCarvers(biomegenerationsettings$builder);
        BiomeDefaultFeatures.addDefaultLakes(biomegenerationsettings$builder);

        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.PLAINS).depth(depth).scale(scale).temperature(temperature).downfall(1F).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(12386452).waterFogColor(12386452).fogColor(25343).skyColor(12255487/*getSkyColorWithTemperatureModifier(temperature)*/).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
    }


    private static int calculateSkyColor(float temperature) {
        float lvt_1_1_ = temperature / 3.0F;
        lvt_1_1_ = Mth.clamp(lvt_1_1_, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }
}
