package de.gerolmed.animlib.api.interfaces;

import org.bukkit.inventory.ItemStack;

public interface ComponentFactory {
    IComponent createSimpleComponent(ItemStack itemStack);
}
