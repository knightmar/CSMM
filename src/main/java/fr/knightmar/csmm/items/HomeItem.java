package fr.knightmar.csmm.items;

import fr.knightmar.csmm.Main;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class HomeItem extends Item {
    public HomeItem() {
        super(new Item.Properties().group(Main.ITEMS).rarity(Rarity.EPIC).maxStackSize(1));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!playerIn.getPersistentData().isEmpty()) {
            int x = playerIn.getPersistentData().getInt("home_x");
            int y = playerIn.getPersistentData().getInt("home_y");
            int z = playerIn.getPersistentData().getInt("home_z");
            playerIn.setPosition(x + 0.5, y, z + 0.5);
            playerIn.setMotion(0, 0, 0);
        } else {
            playerIn.sendStatusMessage(new StringTextComponent("Home non trouvé"), true);

        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
