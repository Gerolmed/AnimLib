package de.gerolmed.animlib.api.interfaces;

import org.bukkit.inventory.Inventory;

import java.util.Map;

public interface AnimatedInventory extends ITickable{

    /**
     * @return the inventory the animation is applied to
     */
    Inventory getInventory();

    /**
     * Returns the list of components with their specific slot
     *
     * @return the list of components with the targeted inventory
     * slot
     */
    Map<Integer, IComponent> getComponents();

    /**
     * Set the components used for animation. Overwrites old
     * list.
     *
     * @param components components with the targeted slot
     *                  number
     */
    void setComponents(Map<Integer, IComponent> components);

    /**
     * Adds a component to the list. Only one component per
     * slot. If already in use the new component will
     * overwrite the old.
     *
     * @param slot inventory slot to target
     * @param component the component to use
     */
    void addComponent(int slot, IComponent component);

    /**
     * Retrieves the component targeting a slot. Will return
     * null if nothing is found
     *
     * @param slot target slot
     * @return the component targeting the slot. Null if none
     * is found.
     */
    IComponent getComponent(int slot);
}
