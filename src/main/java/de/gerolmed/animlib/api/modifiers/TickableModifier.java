package de.gerolmed.animlib.api.modifiers;

import de.gerolmed.animlib.api.interfaces.IModifier;
import de.gerolmed.animlib.api.interfaces.ITickable;

public abstract class TickableModifier implements IModifier, ITickable {

    private int currentTicks;

    @Override
    public void tick() {
        currentTicks--;
        if(currentTicks <= 0)
            currentTicks = proceed();
    }

    /**
     * Calls upon finishing a step (group of ticks). Return is used to calculate time until next proceed.
     * Starts with first task.
     *
     * @return the ticks until the the next proceed
     */
    protected abstract int proceed();
}
