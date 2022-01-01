package fr.knightmar.csmm.data.capability;

public interface ICoinCapability {

    int getCoin();

    void setCoin(int value);

    default void removeCoin(int value){
        this.setCoin(this.getCoin() - value);
    }

    default void addCoin(int value){
        this.setCoin(this.getCoin() + value);
    }

}
