package fr.knightmar.csmm.data;

import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.data.recipe.RecipeGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

import java.io.IOException;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneration {

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();

        if (e.includeServer()) {
            generator.addProvider(new RecipeGenerator(generator));

            try {
                generator.run();
            } catch (IOException x) {
                x.printStackTrace();
            }
        }
    }
}
