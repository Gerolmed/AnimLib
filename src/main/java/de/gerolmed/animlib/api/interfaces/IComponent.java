package de.gerolmed.animlib.api.interfaces;

import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Defines how an animated component interacts with its environment
 */
public interface IComponent extends ITickable {

    /**
     * Adds a list of modifiers to this component.
     *
     * @param modifiers the list of modifiers to
     *                 be added
     */
    void addModifiers(IModifier... modifiers);

    /**
     * The list of modifiers used to modify the
     * animation behaviour
     *
     * @return the list of modifiers (no copy)
     */
    List<IModifier> getModifiers();

    /**
     * The way the component would be displayed
     * as an item stack to the current tick time
     *
     * @return an itemstack representation of
     * this component
     */
    ItemStack getDisplay();
}
