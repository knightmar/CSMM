package fr.knightmar.csmm.gui;

import com.mojang.blaze3d.matrix.MatrixStack;

import fr.knightmar.csmm.CSMM;
import fr.knightmar.csmm.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class TestGui extends Screen {
    private final ResourceLocation GUI_TEXTURE_LOCATION = new ResourceLocation(CSMM.MODID, "textures/gui/gui_base.png");
    private final int xSize = 256;
    private final int ySize = 202;
    private final ClientPlayerEntity player;
    private final World world;
    public static String toOverlay;

    private int guiLeft;
    private int guiTop;

    public TestGui() {
        super(new TranslationTextComponent("pintium.guispells.title"));
        this.player = Minecraft.getInstance().player;
        this.world = Minecraft.getInstance().player.world;
    }

    //init Gui
    protected void init() {
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;

        this.addButton(new Button(guiLeft  + (xSize/2) - 70, guiTop + (ySize/2) - 10, 150, 20, new TranslationTextComponent("pintium.guispells.button.navis.title"), button -> {
            toOverlay = "Button press";
            System.out.println(toOverlay);

            BlockPos posBlock = new BlockPos(0 , 64, 0);
            this.closeScreen();
        }));

    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        drawBackGround(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    private void drawBackGround(MatrixStack matrixStack) {
        assert this.minecraft != null;
        this.minecraft.getTextureManager().bindTexture(GUI_TEXTURE_LOCATION);
        this.blit(matrixStack, guiLeft, guiTop, 0, 0, this.xSize, this.ySize);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
