package fr.knightmar.csmm.items;

import fr.knightmar.csmm.Main;
import fr.knightmar.csmm.data.capability.CoinCapability;
import fr.knightmar.csmm.data.capability.CoinStorage;
import fr.knightmar.csmm.data.capability.ICoinCapability;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;

public class CoinItem extends Item {
    public CoinItem() {
        super(new Item.Properties().tab(Main.items).rarity(Rarity.EPIC).stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        LazyOptional<ICoinCapability> capa = pPlayer.getCapability(CoinCapability.COIN_CAPABILITY);
        capa.orElse(new CoinStorage()).addCoin(1000);

        String coins = String.valueOf(capa.orElse(new CoinStorage()).getCoin());
        pPlayer.sendMessage(new TextComponent("Vous avez désormais," + coins +" coins."), pPlayer.getUUID());

        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
