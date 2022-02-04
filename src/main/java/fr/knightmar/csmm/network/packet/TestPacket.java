package fr.knightmar.csmm.network.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TestPacket {

    public int quantity;
    public TestPacket(int quantity) {
        this.quantity = quantity;
    }


    public static void encode(TestPacket testPacket, FriendlyByteBuf packetBuffer) {
        packetBuffer.writeInt(testPacket.quantity);
    }

    public static TestPacket decode(FriendlyByteBuf packetBuffer) {
        return new TestPacket(packetBuffer.readInt());
    }

    public static void handle(TestPacket testPacket, Supplier<NetworkEvent.Context> ctx) {
        ServerPlayer player = ctx.get().getSender();
        player.addItem(new ItemStack(Items.DIAMOND , testPacket.quantity));
    }
}
