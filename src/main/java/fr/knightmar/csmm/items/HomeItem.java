package fr.knightmar.csmm.items;

import fr.knightmar.csmm.Main;
<<<<<<< Updated upstream
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
=======
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
>>>>>>> Stashed changes

public class HomeItem extends Item {
    private final TranslationTextComponent translation1 = new TranslationTextComponent("home_blocked");
    private final TranslationTextComponent translation2 = new TranslationTextComponent("home_not_find");
    public HomeItem() {
        super(new Item.Properties().tab(Main.items).rarity(Rarity.EPIC).stacksTo(1));
    }

    @Override
<<<<<<< Updated upstream
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!playerIn.getPersistentData().isEmpty()) {
            int x = playerIn.getPersistentData().getInt("home_x");
            int y = playerIn.getPersistentData().getInt("home_y");
            int z = playerIn.getPersistentData().getInt("home_z");
            BlockPos blockUP = new BlockPos(x, y , z);
            BlockState blockState = worldIn.getBlockState(blockUP);
            BlockPos blockUP2 = new BlockPos(x, y + 1, z);
            BlockState blockState2 = worldIn.getBlockState(blockUP2);
            if (blockState.getBlock() == Blocks.AIR && blockState2.getBlock() == Blocks.AIR) {
                playerIn.setPos(x + 0.5, y, z + 0.5);
                playerIn.setDeltaMovement(0, 0, 0);
            } else {
                playerIn.displayClientMessage(new StringTextComponent(translation1.getString()), true);

            }

        } else {
            playerIn.displayClientMessage(new StringTextComponent(translation2.getString()), true);
=======
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pPlayer.getPersistentData().isEmpty()) {
            int x = pPlayer.getPersistentData().getInt("home_x");
            int y = pPlayer.getPersistentData().getInt("home_y");
            int z = pPlayer.getPersistentData().getInt("home_z");
            pPlayer.setPos(x + 0.5, y, z + 0.5);
            pPlayer.setDeltaMovement(0, 0, 0);
        } else {
            pPlayer.displayClientMessage(new StringTextComponent("Home non trouvé"), true);
>>>>>>> Stashed changes

        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }


}
