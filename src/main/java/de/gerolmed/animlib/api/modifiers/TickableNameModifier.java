package de.gerolmed.animlib.api.modifiers;

import de.gerolmed.animlib.api.ModificationPriority;
import de.gerolmed.animlib.api.utils.ItemNameTag;
import lombok.*;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class TickableNameModifier extends TickableModifier {

    @Getter(AccessLevel.PRIVATE)
    private final HashMap<ItemNameTag, Integer> nameTags;
    @Getter(AccessLevel.PRIVATE)
    private final int ticksPerStep;

    private final ModificationPriority priority;

    private Iterator<Map.Entry<ItemNameTag, Integer>> iterator;
    private ItemNameTag current;
    private ItemNameTag next;

    /**
     * @param nameTags on the one side the name on the other the amount of steps to take. By default 1 step = 1 tick
     */
    public TickableNameModifier(HashMap<ItemNameTag, Integer> nameTags) {
        this(nameTags, 1);
    }

    /**
     * @param nameTags on the one side the name on the other the amount of steps to take. By default 1 step = 1 tick
     * @param ticksPerStep the amount of ticks to wait for each step.
     */
    public TickableNameModifier(HashMap<ItemNameTag, Integer> nameTags, int ticksPerStep) {
        this(nameTags, ticksPerStep, ModificationPriority.NORMAL);
    }

    private TickableNameModifier(HashMap<ItemNameTag, Integer> nameTags, int ticksPerStep, ModificationPriority priority) {
        this.nameTags = nameTags;
        this.ticksPerStep = ticksPerStep;
        this.priority = priority;

        this.iterator = this.nameTags.entrySet().iterator();
    }

    @Override
    public ItemStack modify(ItemStack itemStack) {
        return null;
    }

    @Override
    public ModificationPriority getPriority() {
        return priority;
    }

    @Override
    protected int proceed() {

        // Stop to prevent infinite loop
        if(nameTags.isEmpty())
            return 0;

        if(iterator.hasNext()) {
            Map.Entry<ItemNameTag, Integer> val = iterator.next();

            this.current = this.next;
            this.next = val.getKey();

            return val.getValue();
        }
        // List end reached => jump to start
        this.iterator = this.nameTags.entrySet().iterator();
        return proceed();
    }
}
