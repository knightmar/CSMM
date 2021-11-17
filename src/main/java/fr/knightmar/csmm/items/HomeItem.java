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
        super(new Item.Properties().tab(Main.items).rarity(Rarity.EPIC).stacksTo(1));
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!playerIn.getPersistentData().isEmpty()) {
            int x = playerIn.getPersistentData().getInt("home_x");
            int y = playerIn.getPersistentData().getInt("home_y");
            int z = playerIn.getPersistentData().getInt("home_z");
            playerIn.setPos(x + 0.5, y, z + 0.5);
            playerIn.setDeltaMovement(0, 0, 0);
        } else {
            playerIn.displayClientMessage(new StringTextComponent("Home non trouvé"), true);

        }
        return super.use(worldIn, playerIn, handIn);
    }
}
