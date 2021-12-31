package fr.knightmar.csmm.network;


import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.network.packet.CoinPacket;
import fr.knightmar.csmm.network.packet.PlaceBlockButtonPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fmllegacy.network.NetworkRegistry;
import net.minecraftforge.fmllegacy.network.simple.SimpleChannel;

public class Network {
    public static final String PROTOCOL_VERSION = String.valueOf(1);


    public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(Main.MODID, "csmm_channel"))
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .simpleChannel();

    public static void registerNetworkPackets() {
        CHANNEL.messageBuilder(PlaceBlockButtonPacket.class, 0)
                .encoder(PlaceBlockButtonPacket::encode)
                .decoder(PlaceBlockButtonPacket::decode)
                .consumer(PlaceBlockButtonPacket::handle)
                .add();

        CHANNEL.messageBuilder(CoinPacket.class, 0)
                .encoder(CoinPacket::encode)
                .decoder(CoinPacket::decode)
                .consumer(CoinPacket::handle)
                .add();

    }
}
