package fr.knightmar.csmm.client.entity.render;


import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.client.entity.model.CrocoModel;
import fr.knightmar.csmm.entities.CrocoEntity;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CrocoRenderer extends MobRenderer<CrocoEntity, CrocoModel<CrocoEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID, "textures/entity/texture_croco.png");

    public CrocoRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CrocoModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getTextureLocation(CrocoEntity entity) {
        return TEXTURE;
    }
}
