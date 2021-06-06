package fr.knightmar.csmm.event;

import fr.knightmar.csmm.init.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ArmorEvent {
    @SubscribeEvent
    public void onPlayerArmorEquip(LivingEquipmentChangeEvent event) {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();

            //vision nocture lors du port de casque
            if ((event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ModItems.BRONZE_HELMET.get())) {
                player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION,20*99999,0));
            } else if (event.getFrom().getItem() == ModItems.BRONZE_HELMET.get() && event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD).isEmpty()) {
                player.removePotionEffect(Effects.NIGHT_VISION);
            }
            //effet de force lors du port de chestplate
            if ((event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ModItems.BRONZE_CHESTPLATE.get())) {
                player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 20 * 99999999, 0));
            } else if (event.getFrom().getItem() == ModItems.BRONZE_CHESTPLATE.get() && event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.CHEST).isEmpty()) {
                player.removePotionEffect(Effects.STRENGTH);
            }

            if ((event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ModItems.BRONZE_LEGGINGS.get())) {
                player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 20 * 99999999, 0));
            } else if (event.getFrom().getItem() == ModItems.BRONZE_LEGGINGS.get() && event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.LEGS).isEmpty()) {
                player.removePotionEffect(Effects.ABSORPTION);
            }

            if ((event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ModItems.BRONZE_BOOTS.get())) {
                player.addPotionEffect(new EffectInstance(Effects.SPEED, 20 * 99999999, 1));
            } else if (event.getFrom().getItem() == ModItems.BRONZE_BOOTS.get() && event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET).isEmpty()) {
                player.removePotionEffect(Effects.SPEED);
            }

            if ((event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ModItems.BACKPACK.get())) {
                ModItems.backpackIsUsed = "true";
            } else if (event.getFrom().getItem() == ModItems.BACKPACK.get() && event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.CHEST).isEmpty()) {
                ModItems.backpackIsUsed ="false";
            }
        }
    }
}