//package fr.knightmar.csmm.init;
//
//import fr.knightmar.csmm.Main;
//import fr.knightmar.csmm.client.gui.LootBoxContainer;
//import net.minecraft.world.inventory.MenuType;
//import net.minecraftforge.common.extensions.IForgeMenuType;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
//
//public class ModContainer {
//
//    public static final DeferredRegister<MenuType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Main.MODID);
//
//
//    public static final RegistryObject<MenuType<LootBoxContainer>> LOOT_BOX_CONTAINER = CONTAINER_TYPES
//            .register("loot_box_container", () -> IForgeMenuType.create(LootBoxContainer::new));}
