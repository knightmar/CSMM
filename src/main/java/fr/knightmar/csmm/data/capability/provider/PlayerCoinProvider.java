package fr.knightmar.csmm.data.capability.provider;

import fr.knightmar.csmm.data.capability.CoinCapability;
import fr.knightmar.csmm.data.capability.ICoinCapability;
import net.minecraft.core.Direction;
import net.minecraft.nbt.IntTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PlayerCoinProvider implements ICapabilitySerializable<IntTag> {
    private ICoinCapability holder;
    private final LazyOptional<ICoinCapability> lazyOptional = LazyOptional.of(() -> this.holder);

    public PlayerCoinProvider(ICoinCapability holder) {
        this.holder = holder;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return CoinCapability.COIN_CAPABILITY.orEmpty(cap, lazyOptional);
    }

    @Override
    public IntTag serializeNBT() {
        return IntTag.valueOf(this.holder.getCoin());
    }

    @Override
    public void deserializeNBT(IntTag nbt) {
        if (holder == null)
            throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");
        holder.setCoin(nbt.getAsInt());
    }
}
