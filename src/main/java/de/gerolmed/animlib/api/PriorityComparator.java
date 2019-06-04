package de.gerolmed.animlib.api;

import de.gerolmed.animlib.api.interfaces.IModifier;

import java.util.Comparator;

public class PriorityComparator implements Comparator<IModifier> {

    @Override
    public int compare(IModifier o1, IModifier o2) {
        return o1.getPriority().ordinal()-o2.getPriority().ordinal();
    }
}
