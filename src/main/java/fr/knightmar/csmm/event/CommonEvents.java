package fr.knightmar.csmm.event;

import fr.knightmar.csmm.data.capability.CoinCapability;
import fr.knightmar.csmm.data.capability.CoinStorage;
import fr.knightmar.csmm.data.capability.ICoinCapability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CommonEvents {
    @SubscribeEvent
    public static void onPlayerAttack(AttackEntityEvent event) {
        System.out.println("test");
        LazyOptional<ICoinCapability> power_capability = event.getPlayer().getCapability(CoinCapability.COIN_CAPABILITY);
        if(power_capability.orElse(new CoinStorage()).getCoin() >= 60) {
            power_capability.ifPresent(cap -> cap.reduceCoin(60));
        }
        else{
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        event.player.getCapability(CoinCapability.COIN_CAPABILITY).ifPresent(cap -> cap.increaseCoin(1));
    }
}







