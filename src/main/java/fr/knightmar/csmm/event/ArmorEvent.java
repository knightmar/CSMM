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
            if ((event.getEntityLiving().getItemBySlot(EquipmentSlotType.HEAD).getItem() == ModItems.BRONZE_HELMET.get())) {
                player.addEffect(new EffectInstance(Effects.NIGHT_VISION, 20 * 99999, 0));
            } else if (event.getFrom().getItem() == ModItems.BRONZE_HELMET.get() && event.getEntityLiving().getItemBySlot(EquipmentSlotType.HEAD).isEmpty()) {
                player.removeEffect(Effects.NIGHT_VISION);
            }
            //effet de force lors du port de chestplate
            if ((event.getEntityLiving().getItemBySlot(EquipmentSlotType.CHEST).getItem() == ModItems.BRONZE_CHESTPLATE.get())) {
                player.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 20 * 99999999, 0));
            } else if (event.getFrom().getItem() == ModItems.BRONZE_CHESTPLATE.get() && event.getEntityLiving().getItemBySlot(EquipmentSlotType.CHEST).isEmpty()) {
                player.removeEffect(Effects.DAMAGE_BOOST);
            }

            if ((event.getEntityLiving().getItemBySlot(EquipmentSlotType.LEGS).getItem() == ModItems.BRONZE_LEGGINGS.get())) {
                player.addEffect(new EffectInstance(Effects.ABSORPTION, 20 * 99999999, 0));
            } else if (event.getFrom().getItem() == ModItems.BRONZE_LEGGINGS.get() && event.getEntityLiving().getItemBySlot(EquipmentSlotType.LEGS).isEmpty()) {
                player.removeEffect(Effects.ABSORPTION);
            }

            if ((event.getEntityLiving().getItemBySlot(EquipmentSlotType.FEET).getItem() == ModItems.BRONZE_BOOTS.get())) {
                player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 20 * 99999999, 1));
            } else if (event.getFrom().getItem() == ModItems.BRONZE_BOOTS.get() && event.getEntityLiving().getItemBySlot(EquipmentSlotType.FEET).isEmpty()) {
                player.removeEffect(Effects.MOVEMENT_SPEED);
            }

            if ((event.getEntityLiving().getItemBySlot(EquipmentSlotType.CHEST).getItem() == ModItems.BACKPACK.get())) {
                ModItems.backpackIsUsed = "true";
            } else if (event.getFrom().getItem() == ModItems.BACKPACK.get() && event.getEntityLiving().getItemBySlot(EquipmentSlotType.CHEST).isEmpty()) {
                ModItems.backpackIsUsed = "false";
            }
        }
    }
}