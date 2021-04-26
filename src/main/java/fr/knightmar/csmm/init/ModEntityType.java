package fr.knightmar.csmm.init;

import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.entities.CrocoEntity;
import fr.knightmar.csmm.entities.HogEntity;
import fr.knightmar.csmm.entities.TestEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityType {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Main.MODID);

    // Entity Types
    public static final RegistryObject<EntityType<HogEntity>> HOG = ENTITY_TYPES.register("hog",
            () -> EntityType.Builder.create(HogEntity::new, EntityClassification.CREATURE)
                    .size(1.0f, 1.0f) // Hitbox Size
                    .build(new ResourceLocation(Main.MODID, "hog").toString()));

    public static final RegistryObject<EntityType<CrocoEntity>> CROCO = ENTITY_TYPES.register("croco",
            () -> EntityType.Builder.create(CrocoEntity::new, EntityClassification.CREATURE)
                    .size(1.5f, 0.6f) // Hitbox Size
                    .build(new ResourceLocation(Main.MODID, "croco").toString()));

    public static final RegistryObject<EntityType<TestEntity>> TEST = ENTITY_TYPES.register("test",
            () -> EntityType.Builder.create(TestEntity::new, EntityClassification.CREATURE)
                    .size(1.0f, 1.0f) // Hitbox Size
                    .build(new ResourceLocation(Main.MODID, "test").toString()));
}
