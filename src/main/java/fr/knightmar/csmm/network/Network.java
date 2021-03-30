package fr.knightmar.csmm.network;


import fr.knightmar.csmm.CSMM;
import fr.knightmar.csmm.network.packet.PlaceBlockButtonPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class Network {
    public static final String PROTOCOL_VERSION = String.valueOf(1);
    public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(CSMM.MODID, "csmm_channel"))
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .simpleChannel();

    public static void registerNetworkPackets()
    {
        CHANNEL.messageBuilder(PlaceBlockButtonPacket.class, 0)
                .encoder(PlaceBlockButtonPacket::encode)
                .decoder(PlaceBlockButtonPacket::decode)
                .consumer(PlaceBlockButtonPacket::handle)
                .add();
    }
}
