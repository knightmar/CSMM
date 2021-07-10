package fr.knightmar.csmm.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import fr.knightmar.csmm.entities.TestEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;


public class TestModel<T extends TestEntity> extends EntityModel<T> {
    private final ModelRenderer corps;
    private final ModelRenderer brasdroit;
    private final ModelRenderer brasdroit_r1;
    private final ModelRenderer tete;
    private final ModelRenderer jambesgauche;
    private final ModelRenderer jambedroite;
    private final ModelRenderer brasgauche;
    private final ModelRenderer brasgauche_r1;

    public TestModel() {
        textureWidth = 16;
        textureHeight = 16;

        corps = new ModelRenderer(this);
        corps.setRotationPoint(0.0F, 24.0F, 0.0F);
        corps.setTextureOffset(0, 0).addBox(-2.0F, -8.0F, 1.0F, 1.0F, 1.0F, -2.0F, 2.0F, false);

        brasdroit = new ModelRenderer(this);
        brasdroit.setRotationPoint(-1.5F, 13.0F, 0.5F);


        brasdroit_r1 = new ModelRenderer(this);
        brasdroit_r1.setRotationPoint(2.5F, 1.0F, -0.5F);
        brasdroit.addChild(brasdroit_r1);
        setRotationAngle(brasdroit_r1, 0.0F, 0.0F, 0.8727F);
        brasdroit_r1.setTextureOffset(0, 0).addBox(4.0F, 0.0F, 0.0F, -4.0F, 1.0F, 1.0F, 0.0F, false);

        tete = new ModelRenderer(this);
        tete.setRotationPoint(0.0F, 24.0F, 0.0F);
        tete.setTextureOffset(0, 0).addBox(-3.0F, -13.0F, -2.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

        jambesgauche = new ModelRenderer(this);
        jambesgauche.setRotationPoint(-1.5F, 14.0F, 1.5F);
        jambesgauche.setTextureOffset(4, 8).addBox(-1.5F, 5.0F, -1.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        jambedroite = new ModelRenderer(this);
        jambedroite.setRotationPoint(-1.5F, 14.0F, 1.5F);
        jambedroite.setTextureOffset(0, 8).addBox(0.5F, 5.0F, -1.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        brasgauche = new ModelRenderer(this);
        brasgauche.setRotationPoint(-1.5F, 13.0F, 0.5F);


        brasgauche_r1 = new ModelRenderer(this);
        brasgauche_r1.setRotationPoint(-2.5F, 1.0F, -0.5F);
        brasgauche.addChild(brasgauche_r1);
        setRotationAngle(brasgauche_r1, 0.0F, 0.0F, -0.6981F);
        brasgauche_r1.setTextureOffset(0, 6).addBox(-4.0F, 0.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.tete.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);


        this.corps.rotateAngleY = 0.0F;
        this.brasdroit.rotationPointZ = 0.0F;
        this.brasdroit.rotationPointX = -5.0F;
        this.brasgauche.rotationPointZ = 0.0F;
        this.brasgauche.rotationPointX = 5.0F;


        this.brasdroit.rotateAngleZ = 0.0F;
        this.brasgauche.rotateAngleZ = 0.0F;
        this.jambedroite.rotateAngleY = 0.0F;
        this.jambesgauche.rotateAngleY = 0.0F;
        this.jambedroite.rotateAngleZ = 0.0F;
        this.jambesgauche.rotateAngleZ = 0.0F;


        this.brasdroit.rotateAngleY = 0.0F;
        this.brasgauche.rotateAngleY = 0.0F;

    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        corps.render(matrixStack, buffer, packedLight, packedOverlay);
        brasdroit.render(matrixStack, buffer, packedLight, packedOverlay);
        tete.render(matrixStack, buffer, packedLight, packedOverlay);
        jambesgauche.render(matrixStack, buffer, packedLight, packedOverlay);
        jambedroite.render(matrixStack, buffer, packedLight, packedOverlay);
        brasgauche.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
