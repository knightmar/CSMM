package fr.knightmar.csmm.network.packet;

import fr.knightmar.csmm.data.capability.CoinCapability;
import fr.knightmar.csmm.data.capability.ICoinCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

import java.util.function.Supplier;

public class CoinPacket {
    private final int Coin;

    public CoinPacket(int coin) {
        this.Coin = coin;
    }

    public CoinPacket(ICoinCapability instance) {
        this.Coin = instance.getCoin();
    }

    public static void encode(CoinPacket packet, FriendlyByteBuf buffer){
        buffer.writeInt(packet.Coin);
    }

    public static CoinPacket decode(FriendlyByteBuf buffer){
        return new CoinPacket(buffer.readInt());
    }

    public static void handle(CoinPacket packet, Supplier<NetworkEvent.Context> contextSupplier){
        NetworkEvent.Context context = contextSupplier.get();
        if(context.getDirection().getReceptionSide() == LogicalSide.CLIENT){
            context.enqueueWork(() -> {
                if (Minecraft.getInstance().player != null) {
                    Minecraft.getInstance().player.getCapability(CoinCapability.COIN_CAPABILITY)
                            .ifPresent(capa -> capa.setCoin(packet.Coin));
                }
            });
        }
        context.setPacketHandled(true);
    }

}
