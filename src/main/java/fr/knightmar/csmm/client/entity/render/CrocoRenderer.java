package fr.knightmar.csmm.client.entity.render;


import fr.knightmar.csmm.CSMM;
import fr.knightmar.csmm.client.entity.model.CrocoModel;
import fr.knightmar.csmm.client.entity.model.HogModel;
import fr.knightmar.csmm.entities.CrocoEntity;
import fr.knightmar.csmm.entities.HogEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CrocoRenderer extends MobRenderer<CrocoEntity, CrocoModel<CrocoEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(CSMM.MODID, "textures/entity/croco.png");

    public CrocoRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new fr.knightmar.csmm.client.entity.model.CrocoModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(CrocoEntity entity) {
        return TEXTURE;
    }
}
