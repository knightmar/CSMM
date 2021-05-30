package fr.knightmar.csmm.event;

import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.gui.TestGui;
import fr.knightmar.csmm.init.ModItems;
import fr.knightmar.csmm.utils.KeyBoard;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID,value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent e){
        if (KeyBoard.GUI.isPressed()){
            Minecraft.getInstance().displayGuiScreen(new TestGui());

        }
    }
}



//    @SubscribeEvent
//    public static void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {
//        Minecraft.getInstance().fontRenderer.drawTextWithShadow(event.getMatrixStack(),new TranslationTextComponent("overlay.test"),0,0,0x000000);
//    }

