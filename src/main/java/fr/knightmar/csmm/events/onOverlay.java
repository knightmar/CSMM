package fr.knightmar.csmm.events;

import fr.knightmar.csmm.CSMM;
import fr.knightmar.csmm.gui.TestGui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = CSMM.MODID)
public class onOverlay {


    @SubscribeEvent
    public static void onOverlay(RenderGameOverlayEvent.Text event) {
        event.getLeft().add(TestGui.toOverlay);
    }
}
