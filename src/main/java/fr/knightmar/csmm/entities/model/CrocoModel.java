package fr.knightmar.csmm.entities.model;


import fr.knightmar.csmm.Main;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedTickingGeoModel;


public class CrocoModel extends AnimatedTickingGeoModel {

    @Override
    public ResourceLocation getModelLocation(Object entity) {
        return new ResourceLocation(Main.MODID, "geo/croco.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Object entity) {
        return new ResourceLocation(Main.MODID, "textures/entity/croco.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Object entity) {
        return new ResourceLocation(Main.MODID, "animations/croco.animation.json");
    }
}