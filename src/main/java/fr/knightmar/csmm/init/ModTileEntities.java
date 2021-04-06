package fr.knightmar.csmm.init;

import fr.knightmar.csmm.CSMM;
//import fr.knightmar.csmm.tileentity.TileEntityLight;
import fr.knightmar.csmm.tileentity.TileEntityLight;
import fr.knightmar.csmm.tileentity.TileEntityTemp;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, CSMM.MODID);

    public static final RegistryObject<TileEntityType<?>> TEMP_TILE_ENTITY = TILE_ENTITIES.register("temp_tile_entity", ()-> TileEntityType.Builder.create(TileEntityTemp::new, ModBlocks.TEMP_BLOCK.get()).build(null));
    public static final RegistryObject<TileEntityType<?>> LIGHT_TILE_ENTITY = TILE_ENTITIES.register("light_tile_entity" , ()->TileEntityType.Builder.create(TileEntityLight::new, ModBlocks.LIGHT_BLOCK.get()).build(null));
}
