package fr.knightmar.csmm.network.packet;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

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
        ServerPlayerEntity p = ctxProvider.get().getSender();
        ServerWorld world = ctxProvider.get().getSender().getServerWorld();

        if (world != null && p != null) {
            p.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 100, 5));

            p.setMotion(0, 0.5, 0);

        }
    }
}


