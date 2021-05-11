package fr.knightmar.csmm.init;

import fr.knightmar.csmm.Main;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.common.Mod;

public class SurfacesBuilderInit {

    public static final SurfaceBuilderConfig TEST_CONFIG = new SurfaceBuilderConfig(ModBlocks.PLATINIUM_GRASS.get().getDefaultState(), ModBlocks.PLATINIUM_STONE.get().getDefaultState(), ModBlocks.PLATINIUM_STONE.get().getDefaultState());

    public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> TEST = register("test", SurfaceBuilder.DEFAULT.func_242929_a(TEST_CONFIG));

    private static <SC extends ISurfaceBuilderConfig> ConfiguredSurfaceBuilder<SC> register(String name, ConfiguredSurfaceBuilder<SC> configuredSurfaceBuilder) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(Main.MODID, name), configuredSurfaceBuilder);
    }

}
