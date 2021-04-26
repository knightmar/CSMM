package fr.knightmar.csmm.network.packet;

import fr.knightmar.csmm.init.ModBlocks;
import fr.knightmar.csmm.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.potion.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

import java.time.Instant;
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
        //CompoundNBT dataP = p.getPersistentData();

        if (world != null && p != null) {
            //p.getPersistentData().putLong("inertium_use", Instant.now().getEpochSecond());
            //BlockPos posBlock = new BlockPos(p.getPosX(), p.getPosY() - 1, p.getPosZ());
            //world.setBlockState(posBlock, ModBlocks.COPPER_BLOCK.get().getDefaultState());
            p.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 100, 5));

            p.setMotion(0,0.5,0);
            //p.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 10, 1));

           /* if (p.getPersistentData().getLong("inertium_cooldown") <= p.getPersistentData().getLong("inertium_use")) {
                if (p.getHeldItemMainhand().getItem() instanceof BlockItem) {



                }*/

        }
    }
}


