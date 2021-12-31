package fr.knightmar.csmm.entities.render;


import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.entities.model.HogModel;
import fr.knightmar.csmm.entities.HogEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class HogRenderer extends MobRenderer<HogEntity, HogModel<HogEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID, "textures/entity/hog.png");

    public HogRenderer(EntityRendererProvider.Context p_173952_) {
        super(p_173952_, new HogModel<>(p_173952_.bakeLayer(HogModel.HOG_LOCATION)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(HogEntity entity) {
        return TEXTURE;
    }
}
