package de.gerolmed.animlib.api.interfaces;

import de.gerolmed.animlib.api.ModificationPriority;
import org.bukkit.inventory.ItemStack;

public interface IModifier {
    ItemStack modify(ItemStack itemStack);

    ModificationPriority getPriority();
}
