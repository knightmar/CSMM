package fr.knightmar.csmm.utils;



import fr.knightmar.csmm.init.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;


public enum CustomItemTiers implements Tier, ArmorMaterial {
    BRONZE(3, 400, 4.8F, 1.4F, 15, new LazyLoadedValue<>(() -> {
        return Ingredient.of(ModItems.BRONZE_INGOT.get());
    })),
    PLATINIUM(4, 3000, 10.0F, 5.0F, 20, new LazyLoadedValue<>(() -> {
        return Ingredient.of(ModItems.PLATINIUM_INGOT.get());
    }));;


    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyLoadedValue<Ingredient> repairMaterial;

    CustomItemTiers(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, LazyLoadedValue<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getUses() {
        return maxUses;
    }

    @Override
    public float getSpeed() {
        return efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamage;
    }

    @Override
    public int getLevel() {
        return harvestLevel;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot slotIn) {
        return 0;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slotIn) {
        return 0;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return null;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial.get();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
