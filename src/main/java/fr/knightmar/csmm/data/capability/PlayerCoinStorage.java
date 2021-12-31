package fr.knightmar.csmm.data.capability;

import fr.knightmar.csmm.network.Network;
import fr.knightmar.csmm.network.packet.CoinPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.fmllegacy.network.PacketDistributor;

public class PlayerCoinStorage extends CoinStorage{
    private final ServerPlayer player;

    public PlayerCoinStorage(ServerPlayer player) {
        this.player = player;
    }

    @Override
    public void setCoin(int value) {
        super.setCoin(value);

        if (player.connection != null) {
            player.getCapability(CoinCapability.COIN_CAPABILITY).ifPresent(capability -> Network.CHANNEL.send(
                    PacketDistributor.PLAYER.with(() -> this.player), new CoinPacket(capability)
            ));
        }
    }
}
