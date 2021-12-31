package fr.knightmar.csmm.init;

import fr.knightmar.csmm.Main;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;

public class SurfacesBuilderInit {

    public static final SurfaceBuilderBaseConfiguration TEST_CONFIG = new SurfaceBuilderBaseConfiguration(ModBlocks.PLATINIUM_GRASS.get().defaultBlockState(), ModBlocks.PLATINIUM_STONE.get().defaultBlockState(), ModBlocks.PLATINIUM_STONE.get().defaultBlockState());

    public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> TEST = register("test", SurfaceBuilder.DEFAULT.configured(TEST_CONFIG));

    private static <SC extends SurfaceBuilderBaseConfiguration> ConfiguredSurfaceBuilder<SC> register(String name, ConfiguredSurfaceBuilder<SC> configuredSurfaceBuilder) {
        return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(Main.MODID, name), configuredSurfaceBuilder);
    }

}
