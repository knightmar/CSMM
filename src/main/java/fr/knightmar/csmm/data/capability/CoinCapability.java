package fr.knightmar.csmm.data.capability;

import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.data.capability.provider.PlayerCoinProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CoinCapability {
    public static Capability<ICoinCapability> COIN_CAPABILITY = CapabilityManager.get(new CapabilityToken<>(){});

    public static final ResourceLocation CAP_KEY = new ResourceLocation(Main.MODID, "coin");

    @SubscribeEvent
    public static void attachToEntities(AttachCapabilitiesEvent<Entity> event)
    {
        if(event.getObject() instanceof Player)
        {
            ICoinCapability capability;
            if(event.getObject() instanceof ServerPlayer){
                capability = new PlayerCoinStorage((ServerPlayer)event.getObject());
            }
            else {
                capability = new CoinStorage();
            }

            PlayerCoinProvider provider = new PlayerCoinProvider(capability);
            event.addCapability(CAP_KEY, provider);
        }
    }

    @SubscribeEvent
    public void registerCaps(RegisterCapabilitiesEvent event) {
        event.register(ICoinCapability.class);
    }
}
