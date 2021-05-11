package fr.knightmar.csmm.init;

import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.items.BronzeHammer;
import fr.knightmar.csmm.utils.ArmorMaterial;
import fr.knightmar.csmm.utils.ModSpawnEggItem;
import fr.knightmar.csmm.utils.CustomItemTiers;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);


    //materiaux
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot",()->new Item(new Item.Properties().group(Main.ITEMS)));
    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", ()-> new Item(new Item.Properties().group(Main.ITEMS)));
    public static final RegistryObject<Item> BRONZE_STICK = ITEMS.register("bronze_stick", () -> new Item(new Item.Properties().group(Main.ITEMS)));

    //items
    public static final RegistryObject<ModSpawnEggItem> HOG_SPAWN_EGG = ITEMS.register("hog_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityType.HOG, 0xAC6000, 0x705128, new Item.Properties().group(Main.ITEMS)));

    public static final RegistryObject<ModSpawnEggItem> CROCO_SPAWN_EGG = ITEMS.register("croco_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityType.CROCO, 0x48D511, 0x236907, new Item.Properties().group(Main.ITEMS)));


    //outils
    public static final RegistryObject<Item> BRONZE_SWORD = ITEMS.register("bronze_sword",()-> new SwordItem(CustomItemTiers.BRONZE, 2,-2.4f, new Item.Properties().maxStackSize(1).group(Main.ITEMS)));
    public static final RegistryObject<Item> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe",()-> new PickaxeItem(CustomItemTiers.BRONZE, 0,-1f, new Item.Properties().maxStackSize(1).group(Main.ITEMS)));
    public static final RegistryObject<Item> BRONZE_AXE = ITEMS.register("bronze_axe",()-> new AxeItem(CustomItemTiers.BRONZE, 0,-2.4f, new Item.Properties().maxStackSize(1).group(Main.ITEMS)));
    public static final RegistryObject<Item> BRONZE_SHOVEL = ITEMS.register("bronze_shovel",()-> new ShovelItem(CustomItemTiers.BRONZE, 0,-2.4f, new Item.Properties().maxStackSize(1).group(Main.ITEMS)));


    //armure & armes
    public static final RegistryObject<SwordItem> PLATINUM_SWORD = ITEMS.register("platinum_sword",()-> new SwordItem(CustomItemTiers.PLATINUM, 5,-2.4f, new Item.Properties().maxStackSize(1).group(Main.ITEMS)));

    public static final RegistryObject<ArmorItem> PLATINUM_HELMET = ITEMS.register("platinum_helmet",()->new ArmorItem(ArmorMaterial.PLATINUM, EquipmentSlotType.HEAD, new Item.Properties().maxStackSize(1).group(Main.ITEMS)));
    public static final RegistryObject<ArmorItem> PLATINUM_CHESTPLATE = ITEMS.register("platinum_chestplate",()->new ArmorItem(ArmorMaterial.PLATINUM, EquipmentSlotType.CHEST, new Item.Properties().maxStackSize(1).group(Main.ITEMS)));
    public static final RegistryObject<ArmorItem> PLATINUM_LEGGINGS = ITEMS.register("platinum_leggings",()->new ArmorItem(ArmorMaterial.PLATINUM, EquipmentSlotType.LEGS, new Item.Properties().maxStackSize(1).group(Main.ITEMS)));
    public static final RegistryObject<ArmorItem> PLATINUM_BOOTS = ITEMS.register("platinum_boots",()->new ArmorItem(ArmorMaterial.PLATINUM, EquipmentSlotType.FEET, new Item.Properties().maxStackSize(1).group(Main.ITEMS)));

//    public static final RegistryObject<BucketItem> PLATINIUM_WATER_BUCKET = ITEMS.register("platinium_water_bucket",()-> new BucketItem(ModFluids.PLATINIUM_WATER.getFluid(),new Item.Properties().maxStackSize(1).group(Main.ITEMS)));


    public static final RegistryObject<ArmorItem> BRONZE_HELMET = ITEMS.register("bronze_helmet",()->new ArmorItem(ArmorMaterial.BRONZE, EquipmentSlotType.HEAD, new Item.Properties().maxStackSize(1).group(Main.ITEMS)));
    public static final RegistryObject<ArmorItem> BRONZE_CHESTPLATE = ITEMS.register("bronze_chestplate",()->new ArmorItem(ArmorMaterial.BRONZE, EquipmentSlotType.CHEST, new Item.Properties().maxStackSize(1).group(Main.ITEMS)));
    public static final RegistryObject<ArmorItem> BRONZE_LEGGINGS = ITEMS.register("bronze_leggings",()->new ArmorItem(ArmorMaterial.BRONZE, EquipmentSlotType.LEGS, new Item.Properties().maxStackSize(1).group(Main.ITEMS)));
    public static final RegistryObject<ArmorItem> BRONZE_BOOTS = ITEMS.register("bronze_boots",()->new ArmorItem(ArmorMaterial.BRONZE, EquipmentSlotType.FEET, new Item.Properties().maxStackSize(1).group(Main.ITEMS)));

    public static final RegistryObject<Item> MANDRAGORE_SEEDS = ITEMS.register("mandragore_seeds", () -> new BlockItem(ModBlocks.MANDRAGORE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> POLLENIUM_SHARD = ITEMS.register("pollenium_shard",()-> new Item(new Item.Properties().group(Main.ITEMS)));

    public static final RegistryObject<Item> BRONZE_HAMMER = ITEMS.register("bronze_hammer", () -> new BronzeHammer(new Item.Properties().maxStackSize(1).group(Main.ITEMS).isImmuneToFire()));
}
