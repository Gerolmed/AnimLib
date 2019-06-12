package de.gerolmed.animlib.api.interfaces;

import org.bukkit.inventory.ItemStack;

public interface ComponentFactory {
    /**
     * Creates a simple animated component
     *
     * @param itemStack the itemstack the animation component is based on
     * @return a basic component for animation purposes
     * @see de.gerolmed.animlib.api.impl.BasicComponent
     */
    IComponent createSimpleComponent(ItemStack itemStack);
}
