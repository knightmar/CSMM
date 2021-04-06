package fr.knightmar.csmm.init;

import fr.knightmar.csmm.CSMM;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CSMM.MODID);

    public static final RegistryObject<SoundEvent> CROCO_AMBIENT_SOUND = SOUNDS.register("croco_ambient_sound",()-> new SoundEvent(new ResourceLocation(CSMM.MODID, "item.croco_ambient_sound")));
}
