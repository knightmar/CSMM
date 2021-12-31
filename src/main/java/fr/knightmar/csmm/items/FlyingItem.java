package fr.knightmar.csmm.items;

import fr.knightmar.csmm.Main;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class FlyingItem extends Item {
    public FlyingItem() {
        super(new Item.Properties().stacksTo(1).tab(Main.items).rarity(Rarity.RARE));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        boolean mayfly = playerIn.getPersistentData().getBoolean("mayfly");
        if (!playerIn.isCreative()) {
            if (!mayfly) {
                playerIn.getPersistentData().putBoolean("mayfly", true);
                playerIn.getAbilities().mayfly = true;
                playerIn.getAbilities().setFlyingSpeed(0.05f);
            } else {
                playerIn.getPersistentData().putBoolean("mayfly", false);
                playerIn.getAbilities().mayfly = false;
                playerIn.getAbilities().flying = false;
                playerIn.getAbilities().setFlyingSpeed(0f);
            }
        }
        return super.use(worldIn, playerIn, handIn);
    }
}
