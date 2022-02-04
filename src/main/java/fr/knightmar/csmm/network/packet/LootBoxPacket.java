package fr.knightmar.csmm.network.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class LootBoxPacket {
    public LootBoxPacket() {
    }

    public static void encode(LootBoxPacket packet, FriendlyByteBuf buffer) {
    }

    public static LootBoxPacket decode(FriendlyByteBuf buffer) {
        return new LootBoxPacket();
    }

    public static void handle(LootBoxPacket packet, Supplier<NetworkEvent.Context> ctxProvider) {

        if (Minecraft.getInstance().player != null) {
            Minecraft.getInstance().player.addItem(new ItemStack(Items.DIAMOND));

        }
    }
}
