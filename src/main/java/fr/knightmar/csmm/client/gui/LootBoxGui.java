package fr.knightmar.csmm.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.network.Network;
import fr.knightmar.csmm.network.packet.LootBoxPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LootBoxGui extends Screen {
    public static String toOverlay;
    private final ResourceLocation GUI_TEXTURE_LOCATION = new ResourceLocation(Main.MODID, "textures/gui/gui_base.png");
    private final int xSize = 256;
    private final int ySize = 202;
    private final Level level;
    private int guiLeft;
    private int guiTop;

    public LootBoxGui() {
        super(new TextComponent("gui.guispells.title"));
        assert Minecraft.getInstance().player != null;
        this.level = Minecraft.getInstance().player.level;
    }
    protected void init() {
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;

        this.addRenderableWidget(new Button(guiLeft + (xSize / 2) - 70, guiTop + (ySize / 2) - 10, 150, 20, new TextComponent("csmm.guispells.button.navis.title"), button -> {
            toOverlay = "Button press";
            System.out.println(toOverlay);
            this.onClose();
            System.out.println("gui button");
        }));

    }
    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        drawBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTicks);
    }
    private void drawBackground(PoseStack poseStack) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE_LOCATION);
        this.blit(poseStack, guiLeft, guiTop, 0, 0, this.xSize, this.ySize);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}