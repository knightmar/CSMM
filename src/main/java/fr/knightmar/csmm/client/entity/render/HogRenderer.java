package fr.knightmar.csmm.client.entity.render;


import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.client.entity.model.HogModel;
import fr.knightmar.csmm.entities.HogEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class HogRenderer extends MobRenderer<HogEntity, HogModel<HogEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID, "textures/entity/hog.png");

    public HogRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new fr.knightmar.csmm.client.entity.model.HogModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(HogEntity entity) {
        return TEXTURE;
    }
}
