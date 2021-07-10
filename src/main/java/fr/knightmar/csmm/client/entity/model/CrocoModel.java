package fr.knightmar.csmm.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import fr.knightmar.csmm.entities.CrocoEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class CrocoModel<C extends CrocoEntity> extends EntityModel<C> {
    private final ModelRenderer head;
    private final ModelRenderer bloc_tete;
    private final ModelRenderer oreille_droite;
    private final ModelRenderer oreille_gauche;
    private final ModelRenderer body;
    private final ModelRenderer queue_haut;
    private final ModelRenderer queue_milieu;
    private final ModelRenderer queue_bas;
    private final ModelRenderer legBackRight;
    private final ModelRenderer cube_bas2;
    private final ModelRenderer legBackLeft;
    private final ModelRenderer cube_bas;
    private final ModelRenderer legFrontRight;
    private final ModelRenderer bas2;
    private final ModelRenderer haut3;
    private final ModelRenderer legFrontLeft;
    private final ModelRenderer haut;
    private final ModelRenderer bas;

    public CrocoModel() {
        textureWidth = 64;
        textureHeight = 64;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 22.0F, -10.0F);
        head.setTextureOffset(39, 0).addBox(-3.0F, -1.0F, -11.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
        head.setTextureOffset(0, 35).addBox(-3.0F, 0.0F, -11.0F, 6.0F, 1.0F, 7.0F, 0.0F, false);

        bloc_tete = new ModelRenderer(this);
        bloc_tete.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addChild(bloc_tete);
        setRotationAngle(bloc_tete, 0.1745F, 0.0F, 0.0F);
        bloc_tete.setTextureOffset(18, 23).addBox(-4.0F, -2.0F, -5.0F, 8.0F, 3.0F, 6.0F, 0.0F, false);

        oreille_droite = new ModelRenderer(this);
        oreille_droite.setRotationPoint(2.0F, 1.0F, -4.0F);
        head.addChild(oreille_droite);
        setRotationAngle(oreille_droite, 0.5672F, 0.0F, 0.0F);
        oreille_droite.setTextureOffset(5, 14).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);

        oreille_gauche = new ModelRenderer(this);
        oreille_gauche.setRotationPoint(-1.0F, 1.0F, -4.0F);
        head.addChild(oreille_gauche);
        setRotationAngle(oreille_gauche, 0.5672F, 0.0F, 0.0F);
        oreille_gauche.setTextureOffset(0, 12).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-5.0F, -5.0F, -10.0F, 10.0F, 4.0F, 19.0F, 0.0F, false);

        queue_haut = new ModelRenderer(this);
        queue_haut.setRotationPoint(0.0F, -2.0F, 8.0F);
        body.addChild(queue_haut);
        setRotationAngle(queue_haut, 0.0F, 0.0436F, 0.0F);
        queue_haut.setTextureOffset(39, 7).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 3.0F, 3.0F, 0.0F, false);

        queue_milieu = new ModelRenderer(this);
        queue_milieu.setRotationPoint(0.0F, -2.0F, 10.0F);
        body.addChild(queue_milieu);
        setRotationAngle(queue_milieu, 0.0F, 0.0873F, 0.0F);
        queue_milieu.setTextureOffset(21, 32).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 3.0F, 7.0F, 0.0F, false);

        queue_bas = new ModelRenderer(this);
        queue_bas.setRotationPoint(0.0F, -2.0F, 16.0F);
        body.addChild(queue_bas);
        setRotationAngle(queue_bas, 0.0F, 0.3491F, 0.0F);
        queue_bas.setTextureOffset(0, 23).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 10.0F, 0.0F, false);

        legBackRight = new ModelRenderer(this);
        legBackRight.setRotationPoint(-5.0F, 21.0F, 6.0F);
        legBackRight.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);

        cube_bas2 = new ModelRenderer(this);
        cube_bas2.setRotationPoint(-2.0F, 0.0F, 0.0F);
        legBackRight.addChild(cube_bas2);
        setRotationAngle(cube_bas2, 0.0F, 0.0F, 0.3927F);
        cube_bas2.setTextureOffset(13, 14).addBox(-0.6934F, -0.4588F, -0.6F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        legBackLeft = new ModelRenderer(this);
        legBackLeft.setRotationPoint(5.0F, 21.0F, 6.0F);
        legBackLeft.setTextureOffset(0, 6).addBox(0.0F, -1.0F, -1.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);

        cube_bas = new ModelRenderer(this);
        cube_bas.setRotationPoint(2.0F, 1.0F, 1.0F);
        legBackLeft.addChild(cube_bas);
        setRotationAngle(cube_bas, 0.0F, 0.0F, -0.3491F);
        cube_bas.setTextureOffset(18, 23).addBox(0.1953F, -0.4366F, -1.6F, 1.0F, 3.0F, 2.0F, 0.0F, false);

        legFrontRight = new ModelRenderer(this);
        legFrontRight.setRotationPoint(-5.0F, 21.0F, -7.0F);


        bas2 = new ModelRenderer(this);
        bas2.setRotationPoint(0.0F, 2.0F, -1.0F);
        legFrontRight.addChild(bas2);
        setRotationAngle(bas2, -0.3927F, 0.0F, 0.0F);
        bas2.setTextureOffset(0, 28).addBox(-3.0F, -1.0761F, -1.6173F, 2.0F, 3.0F, 2.0F, 0.0F, false);

        haut3 = new ModelRenderer(this);
        haut3.setRotationPoint(0.0F, 2.0F, -1.0F);
        legFrontRight.addChild(haut3);
        setRotationAngle(haut3, 0.4363F, 0.0F, 0.0F);
        haut3.setTextureOffset(7, 9).addBox(-2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

        legFrontLeft = new ModelRenderer(this);
        legFrontLeft.setRotationPoint(5.0F, 21.0F, -7.0F);


        haut = new ModelRenderer(this);
        haut.setRotationPoint(0.0F, 0.0F, 1.0F);
        legFrontLeft.addChild(haut);
        setRotationAngle(haut, 0.6021F, 0.0F, 0.0F);
        haut.setTextureOffset(7, 3).addBox(0.0F, -1.3066F, -2.5412F, 2.0F, 2.0F, 3.0F, 0.0F, false);

        bas = new ModelRenderer(this);
        bas.setRotationPoint(2.0F, 0.8F, -1.0F);
        legFrontLeft.addChild(bas);
        setRotationAngle(bas, -0.3927F, 0.0F, 0.0F);
        bas.setTextureOffset(0, 23).addBox(-1.0F, -0.2588F, -0.6934F, 2.0F, 3.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(C entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float) Math.PI / 300F);
        this.body.rotateAngleX = ((float) Math.PI / 50F);
        this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        legBackRight.render(matrixStack, buffer, packedLight, packedOverlay);
        legBackLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        legFrontRight.render(matrixStack, buffer, packedLight, packedOverlay);
        legFrontLeft.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}