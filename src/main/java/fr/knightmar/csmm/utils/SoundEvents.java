package fr.knightmar.csmm.utils;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Registry;

@net.minecraftforge.registries.ObjectHolder("csmm")
public class SoundEvents {

    public static final SoundEvent CROCO_AMBIANT = register("sound/croco-ambient.ogg");







    private static SoundEvent register(String key) {
        return Registry.register(Registry.SOUND_EVENT, key, new SoundEvent(new ResourceLocation(key)));
    }
}
