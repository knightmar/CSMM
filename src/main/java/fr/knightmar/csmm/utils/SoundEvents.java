package fr.knightmar.csmm.utils;

import fr.knightmar.csmm.Main;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class SoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENT_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Main.MODID);

    public static final RegistryObject<SoundEvent> CROCO_AMBIENT = SOUND_EVENT_DEFERRED_REGISTER.register("croco_ambient",
            () -> new SoundEvent(new ResourceLocation(Main.MODID,"sound/croco_ambient")));

//sound/croco-ambient_sound.ogg






}
