package fr.knightmar.csmm.client.entity.model;// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import fr.knightmar.csmm.CSMM;
import fr.knightmar.csmm.entities.HogEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class CrocoModel<T extends Entity> extends EntityModel<T> {
	private final ModelRenderer corps;
	private final ModelRenderer queue;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer pate_arriere_gauche;
	private final ModelRenderer cube_r4;
	private final ModelRenderer pate_arriere_droite;
	private final ModelRenderer cube_r5;
	private final ModelRenderer pate_avant_gauche;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer pate_avant_droite;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer tete;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;

	public CrocoModel() {
		textureWidth = 64;
		textureHeight = 64;

		corps = new ModelRenderer(this);
		corps.setRotationPoint(0.0F, 24.0F, 0.0F);
		corps.setTextureOffset(0, 0).addBox(-5.0F, -5.0F, -10.0F, 10.0F, 4.0F, 19.0F, 0.0F, false);

		queue = new ModelRenderer(this);
		queue.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(queue, 0.0F, -0.0436F, 0.0F);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, -1.0F, 16.0F);
		queue.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.3491F, 0.0F);
		cube_r1.setTextureOffset(0, 23).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 2.0F, 10.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, -2.0F, 10.0F);
		queue.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0873F, 0.0F);
		cube_r2.setTextureOffset(21, 32).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 3.0F, 7.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, -2.0F, 8.0F);
		queue.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0436F, 0.0F);
		cube_r3.setTextureOffset(39, 7).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 3.0F, 3.0F, 0.0F, false);

		pate_arriere_gauche = new ModelRenderer(this);
		pate_arriere_gauche.setRotationPoint(5.0F, 21.0F, 6.0F);
		pate_arriere_gauche.setTextureOffset(0, 6).addBox(0.0F, -1.0F, -1.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(4.0F, 3.0F, -1.0F);
		pate_arriere_gauche.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, -0.3491F);
		cube_r4.setTextureOffset(18, 23).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		pate_arriere_droite = new ModelRenderer(this);
		pate_arriere_droite.setRotationPoint(-5.0F, 21.0F, 6.0F);
		pate_arriere_droite.setTextureOffset(0, 0).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-3.0F, 3.0F, -1.0F);
		pate_arriere_droite.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, 0.3927F);
		cube_r5.setTextureOffset(13, 14).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		pate_avant_gauche = new ModelRenderer(this);
		pate_avant_gauche.setRotationPoint(5.0F, 21.0F, -6.0F);
		

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(2.0F, 2.0F, -2.0F);
		pate_avant_gauche.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.3927F, 0.0F, 0.0F);
		cube_r6.setTextureOffset(7, 3).addBox(-2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(3.0F, 3.0F, -4.0F);
		pate_avant_gauche.addChild(cube_r7);
		setRotationAngle(cube_r7, -0.3927F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(0, 23).addBox(-2.0F, -3.0F, 0.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		pate_avant_droite = new ModelRenderer(this);
		pate_avant_droite.setRotationPoint(-5.0F, 21.0F, -6.0F);
		

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.0F, 2.0F, -2.0F);
		pate_avant_droite.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.4363F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(7, 9).addBox(-2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-1.0F, 3.0F, -4.0F);
		pate_avant_droite.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.3927F, 0.0F, 0.0F);
		cube_r9.setTextureOffset(0, 28).addBox(-2.0F, -3.0F, 0.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		tete = new ModelRenderer(this);
		tete.setRotationPoint(0.0F, 22.0F, -10.0F);
		tete.setTextureOffset(39, 0).addBox(-3.0F, -1.0F, -11.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		tete.setTextureOffset(0, 35).addBox(-3.0F, 0.0F, -11.0F, 6.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-1.0F, 1.0F, -4.0F);
		tete.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.5672F, 0.0F, 0.0F);
		cube_r10.setTextureOffset(0, 12).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r10.setTextureOffset(5, 14).addBox(2.0F, -2.0F, 0.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(0.0F, 0.0F, 0.0F);
		tete.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.1745F, 0.0F, 0.0F);
		cube_r11.setTextureOffset(18, 23).addBox(-4.0F, -2.0F, -5.0F, 8.0F, 3.0F, 6.0F, 0.0F, false);
	}





	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		corps.render(matrixStack, buffer, packedLight, packedOverlay);
		queue.render(matrixStack, buffer, packedLight, packedOverlay);
		pate_arriere_gauche.render(matrixStack, buffer, packedLight, packedOverlay);
		pate_arriere_droite.render(matrixStack, buffer, packedLight, packedOverlay);
		pate_avant_gauche.render(matrixStack, buffer, packedLight, packedOverlay);
		pate_avant_droite.render(matrixStack, buffer, packedLight, packedOverlay);
		tete.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}