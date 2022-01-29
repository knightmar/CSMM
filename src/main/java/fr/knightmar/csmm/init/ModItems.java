package fr.knightmar.csmm.init;

import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.items.BronzeHammer;
import fr.knightmar.csmm.items.CoinItem;
import fr.knightmar.csmm.items.FlyingItem;
import fr.knightmar.csmm.items.HomeItem;
import fr.knightmar.csmm.utils.ArmorMaterial;
import fr.knightmar.csmm.utils.CustomItemTiers;
import fr.knightmar.csmm.utils.ModSpawnEggItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static String backpackIsUsed;



    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);
    //materiaux
    public static final RegistryObject<Item> PLATINIUM_INGOT = ITEMS.register("platinium_ingot", () -> new Item(new Item.Properties().tab(Main.items)));
    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", () -> new Item(new Item.Properties().tab(Main.items)));
    public static final RegistryObject<Item> BRONZE_STICK = ITEMS.register("bronze_stick", () -> new Item(new Item.Properties().tab(Main.items)));
    //items

    public static final RegistryObject<ModSpawnEggItem> CROCO_SPAWN_EGG = ITEMS.register("croco_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityType.CROCO, 0x48D511, 0x236907, new Item.Properties().tab(Main.items)));
    //outils
    public static final RegistryObject<Item> BRONZE_SWORD = ITEMS.register("bronze_sword", () -> new SwordItem(CustomItemTiers.BRONZE, 2, -2.4f, new Item.Properties().stacksTo(1).tab(Main.items)));
    public static final RegistryObject<Item> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe", () -> new PickaxeItem(CustomItemTiers.BRONZE, 0, -1f, new Item.Properties().stacksTo(1).tab(Main.items)));
    public static final RegistryObject<Item> BRONZE_AXE = ITEMS.register("bronze_axe", () -> new AxeItem(CustomItemTiers.BRONZE, 0, -2.4f, new Item.Properties().stacksTo(1).tab(Main.items)));
    public static final RegistryObject<Item> BRONZE_SHOVEL = ITEMS.register("bronze_shovel", () -> new ShovelItem(CustomItemTiers.BRONZE, 0, -2.4f, new Item.Properties().stacksTo(1).tab(Main.items)));
    //armure & armes
    public static final RegistryObject<SwordItem> PLATINIUM_SWORD = ITEMS.register("platinium_sword", () -> new SwordItem(CustomItemTiers.PLATINIUM, 5, -2.4f, new Item.Properties().stacksTo(1).tab(Main.items)));
    public static final RegistryObject<ArmorItem> PLATINIUM_HELMET = ITEMS.register("platinium_helmet", () -> new ArmorItem(ArmorMaterial.PLATINIUM, EquipmentSlot.HEAD, new Item.Properties().stacksTo(1).tab(Main.items)));
    public static final RegistryObject<ArmorItem> PLATINIUM_CHESTPLATE = ITEMS.register("platinium_chestplate", () -> new ArmorItem(ArmorMaterial.PLATINIUM, EquipmentSlot.CHEST, new Item.Properties().stacksTo(1).tab(Main.items)));
    public static final RegistryObject<ArmorItem> PLATINIUM_LEGGINGS = ITEMS.register("platinium_leggings", () -> new ArmorItem(ArmorMaterial.PLATINIUM, EquipmentSlot.LEGS, new Item.Properties().stacksTo(1).tab(Main.items)));
    public static final RegistryObject<ArmorItem> PLATINIUM_BOOTS = ITEMS.register("platinium_boots", () -> new ArmorItem(ArmorMaterial.PLATINIUM, EquipmentSlot.FEET, new Item.Properties().stacksTo(1).tab(Main.items)));
    public static final RegistryObject<ArmorItem> BRONZE_HELMET = ITEMS.register("bronze_helmet", () -> new ArmorItem(ArmorMaterial.BRONZE, EquipmentSlot.HEAD, new Item.Properties().stacksTo(1).tab(Main.items)));

    public static final RegistryObject<ArmorItem> BRONZE_CHESTPLATE = ITEMS.register("bronze_chestplate", () -> new ArmorItem(ArmorMaterial.BRONZE, EquipmentSlot.CHEST, new Item.Properties().stacksTo(1).tab(Main.items)));
    public static final RegistryObject<ArmorItem> BRONZE_LEGGINGS = ITEMS.register("bronze_leggings", () -> new ArmorItem(ArmorMaterial.BRONZE, EquipmentSlot.LEGS, new Item.Properties().stacksTo(1).tab(Main.items)));
    public static final RegistryObject<ArmorItem> BRONZE_BOOTS = ITEMS.register("bronze_boots", () -> new ArmorItem(ArmorMaterial.BRONZE, EquipmentSlot.FEET, new Item.Properties().stacksTo(1).tab(Main.items)));

    public static final RegistryObject<Item> HOME_ITEM = ITEMS.register("home_item", HomeItem::new);

    public static final RegistryObject<Item> POLLENIUM_SEEDS =
            ITEMS.register("pollenium_seeds", () -> new BlockItem(ModBlocks.POLLENIUM_CROPS.get(), new Item.Properties().tab(Main.items)));

    public static final RegistryObject<Item> POLLENIUM_SHARD = ITEMS.register("pollenium_shard", () -> new Item(new Item.Properties().tab(Main.items)));
    public static final RegistryObject<ArmorItem> BACKPACK = ITEMS.register("backpack", () -> new ArmorItem(ArmorMaterial.BRONZE, EquipmentSlot.CHEST, new Item.Properties().stacksTo(1).tab(Main.items)));
    public static final RegistryObject<Item> BRONZE_HAMMER = ITEMS.register("bronze_hammer", () -> new BronzeHammer(new Item.Properties().stacksTo(1).tab(Main.items).fireResistant(),1f));

    public static final RegistryObject<Item> FLYING_ITEM = ITEMS.register("flying_item", FlyingItem::new);

    public static final RegistryObject<Item> MERINGUE = ITEMS.register("meringue",()->new Item(new Item.Properties()
            .tab(Main.items)
            .food(new FoodProperties.Builder().nutrition(5).saturationMod(2).meat().effect(()-> new MobEffectInstance(MobEffects.MOVEMENT_SPEED,20*120,0),1.0f).build())));




    public static final RegistryObject<Item> HEAL_BUCKET = ITEMS.register("heal_bucket",
            () -> new BucketItem(ModFluids.HEAL_FLUID, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET).tab(Main.items)));

    public static final RegistryObject<Item> COIN = ITEMS.register("coin", CoinItem::new);
}
