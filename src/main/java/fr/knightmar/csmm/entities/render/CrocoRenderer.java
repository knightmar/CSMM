package fr.knightmar.csmm.entities.render;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import fr.knightmar.csmm.entities.CrocoEntity;
import fr.knightmar.csmm.entities.model.CrocoModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CrocoRenderer extends GeoEntityRenderer<CrocoEntity> {
    public CrocoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CrocoModel());
    }

    @Override
    public RenderType getRenderType(CrocoEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
}
