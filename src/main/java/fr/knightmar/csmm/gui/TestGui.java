package fr.knightmar.csmm.gui;

import com.mojang.blaze3d.matrix.MatrixStack;

import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.network.Network;
import fr.knightmar.csmm.network.packet.PlaceBlockButtonPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class TestGui extends Screen {
    private final ResourceLocation GUI_TEXTURE_LOCATION = new ResourceLocation(Main.MODID, "textures/gui/gui_base.png");
    private final int xSize = 256;
    private final int ySize = 202;
    private final World world;
    public static String toOverlay;


    private int guiLeft;
    private int guiTop;

    public TestGui() {
        super(new TranslationTextComponent("gui.guispells.title"));
        this.world = Minecraft.getInstance().player.world;
    }

    //init Gui
    protected void init() {
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;

        this.addButton(new Button(guiLeft  + (xSize/2) - 70, guiTop + (ySize/2) - 10, 150, 20, new TranslationTextComponent("csmm.guispells.button.navis.title"), button -> {
            toOverlay = "Button press";
            System.out.println(toOverlay);
            this.closeScreen();
            Network.CHANNEL.sendToServer(new PlaceBlockButtonPacket());

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
