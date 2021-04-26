package fr.knightmar.csmm.event;

import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.entities.CrocoEntity;
import fr.knightmar.csmm.entities.HogEntity;
import fr.knightmar.csmm.entities.TestEntity;
import fr.knightmar.csmm.init.ModEntityType;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class CommonEvents {

    @SubscribeEvent
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent event){
    event.put(ModEntityType.HOG.get(), HogEntity.setCustomAttributes().create());
    event.put(ModEntityType.CROCO.get(), CrocoEntity.setCustomAttributes().create());
    event.put(ModEntityType.TEST.get(), TestEntity.setCustomAttributes().create());
    }
}