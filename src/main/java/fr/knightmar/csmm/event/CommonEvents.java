package fr.knightmar.csmm.event;

import fr.knightmar.csmm.commands.MoneyCommand;
import fr.knightmar.csmm.data.capability.CoinCapability;
import fr.knightmar.csmm.data.capability.CoinStorage;
import fr.knightmar.csmm.data.capability.ICoinCapability;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.server.command.ConfigCommand;

public class CommonEvents {
    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event) {
        new MoneyCommand(event.getDispatcher());
        ConfigCommand.register(event.getDispatcher());
    }
    @SubscribeEvent
    public static void onPlayerCloneEvent(PlayerEvent.Clone event){
        Player originalPlayer = event.getOriginal();
        LazyOptional<ICoinCapability> capa = originalPlayer.getCapability(CoinCapability.COIN_CAPABILITY);
        int coin = capa.orElse(new CoinStorage()).getCoin();

        Player newPlayer = event.getPlayer();

        LazyOptional<ICoinCapability> coin_capability = newPlayer.getCapability(CoinCapability.COIN_CAPABILITY);
        coin_capability.ifPresent(cap -> cap.setCoin(coin));
    }
}







