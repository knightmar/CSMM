package fr.knightmar.csmm.init;

import fr.knightmar.csmm.Main;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;

public class SurfacesBuilderInit {

    public static final SurfaceBuilderConfig TEST_CONFIG = new SurfaceBuilderConfig(ModBlocks.PLATINIUM_GRASS.get().defaultBlockState(), ModBlocks.PLATINIUM_STONE.get().defaultBlockState(), ModBlocks.PLATINIUM_STONE.get().defaultBlockState());

    public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> TEST = register("test", SurfaceBuilder.DEFAULT.configured(TEST_CONFIG));

    private static <SC extends ISurfaceBuilderConfig> ConfiguredSurfaceBuilder<SC> register(String name, ConfiguredSurfaceBuilder<SC> configuredSurfaceBuilder) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(Main.MODID, name), configuredSurfaceBuilder);
    }

}
