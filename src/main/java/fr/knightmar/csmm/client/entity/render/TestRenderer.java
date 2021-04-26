package fr.knightmar.csmm.client.entity.render;

import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.client.entity.model.TestModel;
import fr.knightmar.csmm.entities.TestEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class TestRenderer extends MobRenderer<TestEntity, TestModel<TestEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID,"textures/entity/test.png");

    public TestRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new TestModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(TestEntity entity) {
        return TEXTURE;
    }
}
