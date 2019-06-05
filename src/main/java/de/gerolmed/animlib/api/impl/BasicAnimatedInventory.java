package de.gerolmed.animlib.api.impl;

import de.gerolmed.animlib.api.interfaces.AnimatedInventory;
import de.gerolmed.animlib.api.interfaces.IComponent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class BasicAnimatedInventory implements AnimatedInventory {

    private final Inventory inventory;
    private boolean running;
    private HashMap<Integer, IComponent> components;

    public BasicAnimatedInventory(Inventory inventory) {
        this.inventory = inventory;
        this.components = new HashMap<>();
        this.running = true;
    }


    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public Map<Integer, IComponent> getComponents() {
        return components;
    }

    @Override
    public void setComponents(Map<Integer, IComponent> components) {
        if(components == null) {
            this.components = new HashMap<>();
            return;
        }
        this.components = new HashMap<>(components);
    }

    @Override
    public void addComponent(int slot, IComponent component) {
        this.components.put(slot, component);
    }

    @Override
    public IComponent getComponent(int slot) {
        return this.components.get(slot);
    }

    @Override
    public void tick() {

        if(!running)
            return;

        this.components.forEach(
            (slot, component)->
                {
                    component.tick();
                    this.inventory.setItem(slot, component.getDisplay());
                }
        );
    }

    @Override
    public void stop() {
        this.running = false;
    }

    @Override
    public void start() {
        this.running = true;
    }
}
