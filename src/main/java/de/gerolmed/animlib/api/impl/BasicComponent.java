package de.gerolmed.animlib.api.impl;

import de.gerolmed.animlib.api.ModificationPriority;
import de.gerolmed.animlib.api.PriorityComparator;
import de.gerolmed.animlib.api.interfaces.IComponent;
import de.gerolmed.animlib.api.interfaces.IModifier;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicComponent implements IComponent {

    private ItemStack itemStack;
    private ArrayList<IModifier> modifiers;
    private boolean running;

    public BasicComponent(ItemStack itemStack) {

        this.itemStack = itemStack;
        this.modifiers = new ArrayList<>();
        start(); // Start animating by default
    }

    @Override
    public void addModifiers(IModifier... modifiers) {
        if(modifiers == null)
            return;
        this.modifiers.addAll(new ArrayList<>(Arrays.asList(modifiers)));
        this.modifiers.sort(new PriorityComparator());
    }

    @Override
    public List<IModifier> getModifiers() {
        return modifiers;
    }

    @Override
    public ItemStack getDisplay() {
        return itemStack;
    }

    @Override
    public void stop() {
        this.running = false;
    }

    @Override
    public void start() {
        this.running = true;
    }

    @Override
    public void tick() {
        if(!running)
            return;
        modifiers.forEach(e->itemStack = e.modify(itemStack));
    }
}
