package fr.knightmar.csmm.init;

import fr.knightmar.csmm.Main;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Main.MODID);

    public static final RegistryObject<SoundEvent> CROCO_AMBIENT_SOUND = SOUNDS.register("croco_ambient_sound", () -> new SoundEvent(new ResourceLocation(Main.MODID, "entity.croco_ambient_sound")));
}
