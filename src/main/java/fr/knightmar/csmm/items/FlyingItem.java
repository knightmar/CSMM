package fr.knightmar.csmm.items;

import fr.knightmar.csmm.Main;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class FlyingItem extends Item {
    public FlyingItem() {
        super(new Item.Properties().maxStackSize(1).group(Main.items).rarity(Rarity.RARE));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        boolean mayfly = playerIn.getPersistentData().getBoolean("mayfly");
        if (!playerIn.isCreative()) {
            if (!mayfly) {
                playerIn.getPersistentData().putBoolean("mayfly", true);
                playerIn.abilities.allowFlying = true;
                playerIn.abilities.setFlySpeed(0.05f);
            } else {
                playerIn.getPersistentData().putBoolean("mayfly", false);
                playerIn.abilities.allowFlying = false;
                playerIn.abilities.isFlying = false;
                playerIn.abilities.setFlySpeed(0f);
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
