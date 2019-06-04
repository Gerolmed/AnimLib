package de.gerolmed.animlib.api;

import de.gerolmed.animlib.api.impl.BasicComponentFactory;
import de.gerolmed.animlib.api.interfaces.ComponentFactory;

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
}
