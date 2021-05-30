package fr.knightmar.csmm.event;

import fr.knightmar.csmm.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ArmorEvent {
    @SubscribeEvent
    public void onPlayerArmorEquip(LivingEquipmentChangeEvent event){
        if (event.getEntityLiving() instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();

            //vision nocture lors du port de casque
            if ((event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ModItems.BRONZE_HELMET.get())){
                Minecraft.getInstance().gameSettings.gamma = 9.0D;
            }
            if (event.getFrom().getItem() == ModItems.BRONZE_HELMET.get() && event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD).isEmpty()) {
                Minecraft.getInstance().gameSettings.gamma = 1.0D;
            }
            //effet de force lors du port de chestplate
            if ((event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ModItems.BRONZE_CHESTPLATE.get())){
                player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 20 * 99999999, 0));
            }else if (event.getFrom().getItem() == ModItems.BRONZE_CHESTPLATE.get() && event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.CHEST).isEmpty()) {
                player.removePotionEffect(Effects.STRENGTH);
            }

            if ((event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ModItems.BRONZE_LEGGINGS.get())){
                player.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 20 * 99999999, 0));
            }else if (event.getFrom().getItem() == ModItems.BRONZE_LEGGINGS.get() && event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.LEGS).isEmpty()) {
                player.removePotionEffect(Effects.ABSORPTION);
            }

            if ((event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ModItems.BRONZE_BOOTS.get())){
                player.addPotionEffect(new EffectInstance(Effects.SPEED, 20 * 99999999, 1));
            }else if (event.getFrom().getItem() == ModItems.BRONZE_BOOTS.get() && event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET).isEmpty()) {
                player.removePotionEffect(Effects.SPEED);
            }


        }
    }
}
//    @SubscribeEvent
//    public void onPlayerEquipmentChange(final LivingEquipmentChangeEvent e) {
//        if (e.getEntityLiving() instanceof PlayerEntity) {
//            PlayerEntity player = ((PlayerEntity) e.getEntityLiving());
//
//            if (e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ModItems.BRONZE_HELMET.get() && Minecraft.getInstance().gameSettings.gamma == 1.0D) {
//                Minecraft.getInstance().gameSettings.gamma = 9.0D;
//            } else if (e.getFrom().getItem() == ModItems.BRONZE_HELMET.get() && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD).isEmpty() && Minecraft.getInstance().gameSettings.gamma == 9.0D) {
//                Minecraft.getInstance().gameSettings.gamma = 1.0D;
//            }
//
//            if (e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ModItems.BRONZE_CHESTPLATE.get() && !player.isPotionActive(Effects.STRENGTH)) {
//                player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 20 * 99999999, 0));
//            } else if (e.getFrom().getItem() == ModItems.BRONZE_CHESTPLATE.get() && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.CHEST).isEmpty() && player.isPotionActive(Effects.STRENGTH)) {
//                player.removePotionEffect(Effects.STRENGTH);
//            }
//
//            if (e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ModItems.BRONZE_LEGGINGS.get() && !player.isPotionActive(Effects.HASTE)) {
//                player.addPotionEffect(new EffectInstance(Effects.HASTE, 20 * 99999999, 0));
//            } else if (e.getFrom().getItem() == ModItems.BRONZE_LEGGINGS.get() && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.LEGS).isEmpty() && player.isPotionActive(Effects.HASTE)) {
//                player.removePotionEffect(Effects.HASTE);
//            }
//
//            if (e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ModItems.BRONZE_BOOTS.get() && !player.isPotionActive(Effects.SPEED)) {
//                player.addPotionEffect(new EffectInstance(Effects.SPEED, 20 * 99999999, 0));
//            } else if (e.getFrom().getItem() == ModItems.BRONZE_BOOTS.get() && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET).isEmpty() && player.isPotionActive(Effects.SPEED)) {
//                player.removePotionEffect(Effects.SPEED);
//            }
//
//            if (e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == ModItems.BRONZE_HELMET.get()
//                    && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == ModItems.BRONZE_CHESTPLATE.get()
//                    && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == ModItems.BRONZE_LEGGINGS.get()
//                    && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == ModItems.BRONZE_BOOTS.get()
//                    && !player.isPotionActive(Effects.INVISIBILITY)) {
//                player.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 20 * 99999999, 1));
//            } else if (e.getFrom().getItem() == ModItems.BRONZE_HELMET.get() && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD).isEmpty() && player.isPotionActive(Effects.INVISIBILITY) ||
//                    e.getFrom().getItem() == ModItems.BRONZE_CHESTPLATE.get() && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.CHEST).isEmpty() && player.isPotionActive(Effects.INVISIBILITY) ||
//                    e.getFrom().getItem() == ModItems.BRONZE_LEGGINGS.get() && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.LEGS).isEmpty() && player.isPotionActive(Effects.INVISIBILITY) ||
//                    e.getFrom().getItem() == ModItems.BRONZE_BOOTS.get() && e.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET).isEmpty() && player.isPotionActive(Effects.INVISIBILITY)) {
//                player.removePotionEffect(Effects.INVISIBILITY);
//            }
//        }
//    }


