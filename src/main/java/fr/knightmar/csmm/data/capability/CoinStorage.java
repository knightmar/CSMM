package fr.knightmar.csmm.data.capability;

public class CoinStorage implements ICoinCapability{
    private int coin = 0;

    @Override
    public int getCoin() {
        return coin;
    }

    @Override
    public void setCoin(int value) {
        this.coin = clamp(value);
    }

    private int clamp(int value) {
        if(value < 0) return 0;
        return value;
    }
}
