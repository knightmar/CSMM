/*package fr.knightmar.csmm.utils;

import fr.knightmar.csmm.CSMM;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


@net.minecraftforge.registries.ObjectHolder("csmm")
public class SoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENT_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CSMM.MODID);

    public static final RegistryObject<SoundEvent> CROCO_AMBIENT = SOUND_EVENT_DEFERRED_REGISTER.register("croco_ambient",
            () -> new SoundEvent(new ResourceLocation(CSMM.MODID,"sound/croco_ambient")));

//sound/croco-ambient.ogg





    private static SoundEvent register(String key) {
        return Registry.register(Registry.SOUND_EVENT, key, new SoundEvent(new ResourceLocation(key)));
    }
}
*/