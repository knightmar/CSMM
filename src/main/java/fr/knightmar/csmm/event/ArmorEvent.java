package fr.knightmar.csmm.event;

import fr.knightmar.csmm.init.ModItems;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.io.IOException;

public class ArmorEvent {
    @SubscribeEvent
    public void onPlayerArmorEquip(LivingEquipmentChangeEvent event) throws IOException {
        if (event.getEntityLiving() instanceof Player) {
            Player player = (Player) event.getEntityLiving();

            //vision nocture lors du port de casque
            if ((event.getEntityLiving().getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.BRONZE_HELMET.get())) {
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 20 * 99999, 0));
            } else if (event.getFrom().getItem() == ModItems.BRONZE_HELMET.get() && event.getEntityLiving().getItemBySlot(EquipmentSlot.HEAD).isEmpty()) {
                player.removeEffect(MobEffects.NIGHT_VISION);
            }
            //effet de force lors du port de chestplate
            if ((event.getEntityLiving().getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.BRONZE_CHESTPLATE.get())) {
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20 * 99999999, 0));
            } else if (event.getFrom().getItem() == ModItems.BRONZE_CHESTPLATE.get() && event.getEntityLiving().getItemBySlot(EquipmentSlot.CHEST).isEmpty()) {
                player.removeEffect(MobEffects.DAMAGE_BOOST);
            }

            if ((event.getEntityLiving().getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.BRONZE_LEGGINGS.get())) {
                player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 20 * 99999999, 0));
            } else if (event.getFrom().getItem() == ModItems.BRONZE_LEGGINGS.get() && event.getEntityLiving().getItemBySlot(EquipmentSlot.LEGS).isEmpty()) {
                player.removeEffect(MobEffects.ABSORPTION);
            }

            if ((event.getEntityLiving().getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.BRONZE_BOOTS.get())) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20 * 99999999, 1));
            } else if (event.getFrom().getItem() == ModItems.BRONZE_BOOTS.get() && event.getEntityLiving().getItemBySlot(EquipmentSlot.FEET).isEmpty()) {
                player.removeEffect(MobEffects.MOVEMENT_SPEED);
            }

            if ((event.getEntityLiving().getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.BACKPACK.get())) {
                ModItems.backpackIsUsed = "true";
            } else if (event.getFrom().getItem() == ModItems.BACKPACK.get() && event.getEntityLiving().getItemBySlot(EquipmentSlot.CHEST).isEmpty()) {
                ModItems.backpackIsUsed = "false";
            }
        }
    }
}