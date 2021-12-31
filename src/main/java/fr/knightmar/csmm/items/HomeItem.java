package fr.knightmar.csmm.items;

import fr.knightmar.csmm.Main;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class HomeItem extends Item {
    private final TextComponent translation1 = new TextComponent("home_blocked");
    private final TextComponent translation2 = new TextComponent("home_not_find");

    public HomeItem() {
        super(new Item.Properties().tab(Main.items).rarity(Rarity.EPIC).stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pPlayer.getPersistentData().isEmpty()) {
            int x = pPlayer.getPersistentData().getInt("home_x");
            int y = pPlayer.getPersistentData().getInt("home_y");
            int z = pPlayer.getPersistentData().getInt("home_z");
            BlockPos blockUP = new BlockPos(x, y, z);
            BlockState blockState = pLevel.getBlockState(blockUP);
            BlockPos blockUP2 = new BlockPos(x, y + 1, z);
            BlockState blockState2 = pLevel.getBlockState(blockUP2);
            if (blockState.getBlock() == Blocks.AIR && blockState2.getBlock() == Blocks.AIR) {
                pPlayer.setPos(x + 0.5, y, z + 0.5);
                pPlayer.setDeltaMovement(0, 0, 0);
            } else {
                pPlayer.displayClientMessage(new TextComponent(translation1.getString()), true);

            }

        } else {
            pPlayer.displayClientMessage(new TextComponent(translation2.getString()), true);
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

//    @Override
//
//    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
//        if (!pPlayer.getPersistentData().isEmpty()) {
//            int x = pPlayer.getPersistentData().getInt("home_x");
//            int y = pPlayer.getPersistentData().getInt("home_y");
//            int z = pPlayer.getPersistentData().getInt("home_z");
//            pPlayer.setPos(x + 0.5, y, z + 0.5);
//            pPlayer.setDeltaMovement(0, 0, 0);
//        } else {
//            pPlayer.displayClientMessage(new TextComponent("Home non trouvé"), true);
//
//        }
//        return super.use(pLevel, pPlayer, pUsedHand);
//    }

}

