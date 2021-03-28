package fr.knightmar.csmm.events;


import fr.knightmar.csmm.gui.TestGui;
import fr.knightmar.csmm.utils.KeyBoard;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class KeyBoardEvent {
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent e){
        if (KeyBoard.GUI.isPressed()){
            Minecraft.getInstance().displayGuiScreen(new TestGui());
            System.out.println("test_gui a été ouvert");
        }

    }
}