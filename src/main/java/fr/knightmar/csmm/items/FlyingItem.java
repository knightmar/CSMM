package fr.knightmar.csmm.items;

import fr.knightmar.csmm.Main;
import net.minecraft.world.InteractionHand;
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
    public ActionResult<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        boolean mayfly = playerIn.getPersistentData().getBoolean("mayfly");
        if (!playerIn.isCreative()) {
            if (!mayfly) {
                playerIn.getPersistentData().putBoolean("mayfly", true);
                playerIn.abilities.mayfly = true;
                playerIn.abilities.setFlyingSpeed(0.05f);
            } else {
                playerIn.getPersistentData().putBoolean("mayfly", false);
                playerIn.abilities.mayfly = false;
                playerIn.abilities.flying = false;
                playerIn.abilities.setFlyingSpeed(0f);
            }
        }
        return super.use(worldIn, playerIn, handIn);
    }
}
