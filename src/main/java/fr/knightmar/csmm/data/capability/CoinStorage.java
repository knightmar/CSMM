package fr.knightmar.csmm.data.capability;

public class CoinStorage implements ICoinCapability{
    private int power = 0;

    @Override
    public int getCoin() {
        return power;
    }

    @Override
    public void setCoin(int value) {
        this.power = clamp(value);
    }

    private int clamp(int value) {
        if(value < 0) return 0;
        return value;
    }
}