package de.gerolmed.animlib.api;

import de.gerolmed.animlib.api.impl.BasicAnimatedInventory;
import de.gerolmed.animlib.api.impl.BasicComponentFactory;
import de.gerolmed.animlib.api.interfaces.AnimatedInventory;
import de.gerolmed.animlib.api.interfaces.AnimationManager;
import de.gerolmed.animlib.api.interfaces.ComponentFactory;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class AnimationFactory {

    /**
     * Creates a new {@link BasicComponentFactory}. Used to
     * create components and through that animate inventories.
     * See its docs for more details.
     *
     * @return a new ComponentFactory. In this case a {@link BasicComponentFactory}
     */
    public ComponentFactory createComponentFactory() {
        return new BasicComponentFactory(this);
    }

    /**
     * Creates a new {@link BasicAnimatedInventory}. This
     * will do nothing until added to a {@link AnimationManager}.
     * See {@link AnimationFactory#createAnimationManager(Plugin)}
     *
     * @param targetInventory the target inventory
     * @return the new animated inventory
     */
    public AnimatedInventory createAnimatedInventory(Inventory targetInventory) {
        return new BasicAnimatedInventory(targetInventory);
    }

    /**
     * Creates a new {@link AnimationManager}. This can be
     * used to animate inventories.
     *
     * @param plugin the plugin creating the animated inventory
     * @return the new animation manager
     *
     * @see AnimationFactory#createAnimatedInventory(Inventory)
     */
    public AnimationManager createAnimationManager(Plugin plugin) {
        return new BasicAnimationManager(plugin);
    }
}
