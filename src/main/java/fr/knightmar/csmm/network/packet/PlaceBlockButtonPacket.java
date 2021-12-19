package fr.knightmar.csmm.network.packet;


import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

import java.util.function.Supplier;

public class PlaceBlockButtonPacket {
    public PlaceBlockButtonPacket() {
    }

    public static void encode(PlaceBlockButtonPacket packet, PacketBuffer buffer) {
    }

    public static PlaceBlockButtonPacket decode(PacketBuffer buffer) {
        return new PlaceBlockButtonPacket();
    }

    public static void handle(PlaceBlockButtonPacket packet, Supplier<NetworkEvent.Context> ctxProvider) {
        ServerPlayer p = ctxProvider.get().getSender();
        ServerLevel level = ctxProvider.get().getSender().getLevel();

        if (p != null) {
            p.addEffect(new EffectInstance(Effects.JUMP, 100, 5));

            p.setDeltaMovement(0, 0.5, 0);

        }
    }
}


