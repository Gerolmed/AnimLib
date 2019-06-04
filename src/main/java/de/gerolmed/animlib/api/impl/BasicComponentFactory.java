package de.gerolmed.animlib.api.impl;

import de.gerolmed.animlib.api.AnimationFactory;
import de.gerolmed.animlib.api.interfaces.ComponentFactory;
import de.gerolmed.animlib.api.interfaces.IComponent;
import org.bukkit.inventory.ItemStack;

public class BasicComponentFactory implements ComponentFactory {

    private final AnimationFactory animationFactory;

    public BasicComponentFactory(AnimationFactory animationFactory) {
        this.animationFactory = animationFactory;
    }

    @Override
    public IComponent createSimpleComponent(ItemStack itemStack) {
        return null;
    }
}
