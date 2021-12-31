package fr.knightmar.csmm.data.capability;

public interface ICoinCapability {

    /**
     * Returns a number between 0(minimal power) and 1000(maximal power)
     *
     * @return the power stored
     **/
    int getCoin();

    /**
     * Allow to define the power stored
     * @param value the new amount of power
     */
    void setCoin(int value);

    /**
     * Reduce the power stored from a given amount
     * @param value the power subtracted from the actual power
     */
    default void reduceCoin(int value){
        this.setCoin(this.getCoin() - value);
    }

    /**
     * Increase the power stored from a given amount
     * @param value the power added from the actual power
     */
    default void increaseCoin(int value){
        this.setCoin(this.getCoin() + value);
    }

}
