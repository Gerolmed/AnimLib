package de.gerolmed.animlib.api.interfaces;

import java.util.ArrayList;

public interface AnimationManager extends ITickable {
    /**
     * Stops scheduler for good.
     * Can not be restarted!
     */
    void shutdown();

    /**
     * Add animated inventory
     *
     * @param inventory inventory to add to the list
     */
    void addAnimatedInventory(AnimatedInventory inventory);

    /**
     * Removes an animated inventory from the list
     *
     * @param inventory inventory to remove
     * @return was removal successful
     */
    boolean removeAnimatedInventory(AnimatedInventory inventory);

    /**
     * Returns the animated inventories managed by this animation
     * manager
     *
     * @return the list of animated inventories
     */
    ArrayList<AnimatedInventory> getAnimatedInventories();
}
