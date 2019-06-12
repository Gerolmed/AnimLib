package de.gerolmed.animlib.api.interfaces;

import de.gerolmed.animlib.api.ModificationPriority;
import org.bukkit.inventory.ItemStack;

/**
 * Defines a animation modifier
 */
public interface IModifier {

    /**
     * Modifies item to fit the current modification.
     * Some modifiers do this time dependent (see {@link de.gerolmed.animlib.api.modifiers.TickableModifier}).
     * The item stack returned <b>might not</b> be the item that was inserted. Use the return value to continue.
     *
     * @param itemStack the item stack that should be modified
     * @return the modified item stack. Use this as the input might not be stable.
     */
    ItemStack modify(ItemStack itemStack);

    /**
     * @return the priority of this modifier
     */
    ModificationPriority getPriority();
}
