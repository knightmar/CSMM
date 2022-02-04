package fr.knightmar.csmm.network;


import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.network.packet.CoinPacket;
import fr.knightmar.csmm.network.packet.LootBoxPacket;
import fr.knightmar.csmm.network.packet.PlaceBlockButtonPacket;
import fr.knightmar.csmm.network.packet.TestPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.Optional;

public class Network {
    public static final String PROTOCOL_VERSION = String.valueOf(1);


    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(Main.MODID, "csmm"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals);

    public static void registerNetworkPackets() {
        CHANNEL.registerMessage(0, PlaceBlockButtonPacket.class, PlaceBlockButtonPacket::encode, PlaceBlockButtonPacket::decode, PlaceBlockButtonPacket::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
        CHANNEL.registerMessage(1, CoinPacket.class, CoinPacket::encode, CoinPacket::decode, CoinPacket::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
        CHANNEL.registerMessage(2, LootBoxPacket.class, LootBoxPacket::encode, LootBoxPacket::decode, LootBoxPacket::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
        CHANNEL.registerMessage(2, TestPacket.class, TestPacket::encode, TestPacket::decode, TestPacket::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
    }
}
