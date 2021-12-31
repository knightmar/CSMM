package fr.knightmar.csmm.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.network.Network;
import fr.knightmar.csmm.network.packet.PlaceBlockButtonPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;


public class TestGui extends Screen {
    public static String toOverlay;
    private final ResourceLocation GUI_TEXTURE_LOCATION = new ResourceLocation(Main.MODID, "textures/gui/gui_base.png");
    private final int xSize = 256;
    private final int ySize = 202;
    private final Level level;
    private int guiLeft;
    private int guiTop;

    public TestGui() {
        super(new TextComponent("gui.guispells.title"));
        assert Minecraft.getInstance().player != null;
        this.level = Minecraft.getInstance().player.level;
    }

    //init Gui
    protected void init() {
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;

        this.addWidget(new Button(guiLeft + (xSize / 2) - 70, guiTop + (ySize / 2) - 10, 150, 20, new TextComponent("csmm.guispells.button.navis.title"), button -> {
            toOverlay = "Button press";
            System.out.println(toOverlay);
            this.onClose();
            Network.CHANNEL.sendToServer(new PlaceBlockButtonPacket());

        }));

    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        drawBackGround(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTicks);
    }

    private void drawBackGround(PoseStack poseStack) {
        assert this.minecraft != null;
        this.minecraft.getTextureManager().bindForSetup(GUI_TEXTURE_LOCATION);
        this.blit(poseStack, guiLeft, guiTop, 0, 0, this.xSize, this.ySize);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
