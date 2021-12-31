package fr.knightmar.csmm.init;

import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.tileentity.TileEntityTemp;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Main.MODID);

    public static final RegistryObject<BlockEntityType<TileEntityTemp>> TEMP_TILE_ENTITY = TILE_ENTITIES.register("temp_tile_entity", () -> BlockEntityType.Builder.of(TileEntityTemp::new, ModBlocks.TEMP_BLOCK.get())
            .build(null));
}
