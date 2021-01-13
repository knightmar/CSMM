package fr.knightmar.csmm.init;

import fr.knightmar.csmm.CSMM;
import fr.knightmar.csmm.item.ArmorMaterial;
import fr.knightmar.csmm.item.ModSpawnEggItem;
import fr.knightmar.csmm.utils.CustomItemTiers;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CSMM.MODID);


    //materiaux
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot",()->new Item(new Item.Properties().group(CSMM.ITEMS)));
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", ()-> new Item(new Item.Properties().group(CSMM.ITEMS)));
    public static final RegistryObject<Item> COPPER_STICK = ITEMS.register("copper_stick", () -> new Item(new Item.Properties().group(CSMM.ITEMS)));

    //items
    public static final RegistryObject<ModSpawnEggItem> HOG_SPAWN_EGG = ITEMS.register("hog_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityType.HOG, 0xE1A68B, 0x99593B, new Item.Properties().group(CSMM.ITEMS)));

    public static final RegistryObject<ModSpawnEggItem> CROCO_SPAWN_EGG = ITEMS.register("croco_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityType.CROCO, 0xE1A68B, 0x99593B, new Item.Properties().group(CSMM.ITEMS)));


    //outils
    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword",()-> new SwordItem(CustomItemTiers.COPPER, 2,-2.4f, new Item.Properties().maxStackSize(1).group(CSMM.ITEMS)));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",()-> new PickaxeItem(CustomItemTiers.COPPER, 0,-1f, new Item.Properties().maxStackSize(1).group(CSMM.ITEMS)));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe",()-> new AxeItem(CustomItemTiers.COPPER, 0,-2.4f, new Item.Properties().maxStackSize(1).group(CSMM.ITEMS)));
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel",()-> new ShovelItem(CustomItemTiers.COPPER, 0,-2.4f, new Item.Properties().maxStackSize(1).group(CSMM.ITEMS)));


    //armure & armes
    public static final RegistryObject<SwordItem> PLATINUM_SWORD = ITEMS.register("platinum_sword",()-> new SwordItem(CustomItemTiers.PLATINUM, 5,10f, new Item.Properties().maxStackSize(1).group(CSMM.ITEMS)));

    public static final RegistryObject<ArmorItem> PLATINUM_CHESTPLATE = ITEMS.register("platinum_chestplate",()->new ArmorItem(ArmorMaterial.PLATINUM, EquipmentSlotType.CHEST, new Item.Properties().maxStackSize(1).group(CSMM.ITEMS)));
    public static final RegistryObject<ArmorItem> PLATINUM_HELMET = ITEMS.register("platinum_helmet",()->new ArmorItem(ArmorMaterial.PLATINUM, EquipmentSlotType.HEAD, new Item.Properties().maxStackSize(1).group(CSMM.ITEMS)));
    public static final RegistryObject<ArmorItem> PLATINUM_LEGGINGS = ITEMS.register("platinum_leggings",()->new ArmorItem(ArmorMaterial.PLATINUM, EquipmentSlotType.LEGS, new Item.Properties().maxStackSize(1).group(CSMM.ITEMS)));
    public static final RegistryObject<ArmorItem> PLATINUM_BOOTS = ITEMS.register("platinum_boots",()->new ArmorItem(ArmorMaterial.PLATINUM, EquipmentSlotType.FEET, new Item.Properties().maxStackSize(1).group(CSMM.ITEMS)));



}
