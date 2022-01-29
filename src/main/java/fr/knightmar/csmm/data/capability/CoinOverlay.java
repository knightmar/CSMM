package fr.knightmar.csmm.data.capability;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class CoinOverlay extends GuiComponent {
    private static final Minecraft MC = Minecraft.getInstance();

    private static final Font font = MC.font;

    public static void render(PoseStack matrixStack) {
        Player player = Minecraft.getInstance().player;
        int coin = 0;

        assert player != null;
        LazyOptional<ICoinCapability> capa = player.getCapability(CoinCapability.COIN_CAPABILITY);
        coin = capa.orElse(new CoinStorage()).getCoin();
        font.draw(matrixStack, "coins : " + coin, 0, 0, 14737632);
    }
}
