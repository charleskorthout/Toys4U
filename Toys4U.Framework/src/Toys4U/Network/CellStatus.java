package Toys4U.Network;

/**
 * Created by charles korthout on 1/11/2017.
 */
public enum CellStatus {
    PreInitialized, // All cells are initalized, neighbors are not
    Initialized, // All cells and neighbors are initialized
    Processing, // Processing the particle behavior
    Processed, // All processing is completed
    Surpassing, // Guiding the surpassing particles
    Surpassed // all traveling has been completed
}
