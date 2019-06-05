package de.gerolmed.animlib.api;

import de.gerolmed.animlib.api.interfaces.AnimatedInventory;
import de.gerolmed.animlib.api.interfaces.AnimationManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public final class BasicAnimationManager implements AnimationManager {

    private final Plugin plugin;
    private UpdateTask updateTask;

    private ArrayList<AnimatedInventory> animatedInventories;
    private boolean running;

    public BasicAnimationManager(Plugin plugin) {
        this.plugin = plugin;
        this.animatedInventories = new ArrayList<>();
        running = true;
        runTimer();
    }

    private void runTimer() {
        this.updateTask = new UpdateTask(this);
        this.updateTask.runTaskTimer(plugin,0,1);
    }

    @Override
    public void tick() {
        if(!this.running)
            return;
        for(AnimatedInventory inventory : animatedInventories) {
            inventory.tick();
        }
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
    public void shutdown() {
        updateTask.cancel();
    }

    @Override
    public void addAnimatedInventory(AnimatedInventory inventory) {
        this.animatedInventories.add(inventory);
    }

    @Override
    public boolean removeAnimatedInventory(AnimatedInventory inventory) {
        return this.animatedInventories.remove(inventory);
    }

    @Override
    public ArrayList<AnimatedInventory> getAnimatedInventories() {
        return this.animatedInventories;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @AllArgsConstructor
    private class UpdateTask extends BukkitRunnable {

        private final BasicAnimationManager manager;

        @Override
        public void run() {
            manager.tick();
        }
    }
}
