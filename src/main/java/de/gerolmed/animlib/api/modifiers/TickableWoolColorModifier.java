package de.gerolmed.animlib.api.modifiers;

import de.gerolmed.animlib.api.ModificationPriority;
import de.gerolmed.animlib.api.utils.ItemMaterial;
import de.gerolmed.animlib.api.utils.WoolColor;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Wool;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class TickableWoolColorModifier extends TickableModifier {

    @Getter(AccessLevel.PRIVATE)
    private final LinkedHashMap<WoolColor, Integer> nameTags;
    @Getter(AccessLevel.PRIVATE)
    private final int ticksPerStep;

    private final ModificationPriority priority;

    private Iterator<Map.Entry<WoolColor, Integer>> iterator;
    private WoolColor current;
    private WoolColor next;

    /**
     * @param nameTags on the one side the name on the other the amount of steps to take. By default 1 step = 1 tick
     */
    public TickableWoolColorModifier(LinkedHashMap<WoolColor, Integer> nameTags) {
        this(nameTags, 1);
    }

    /**
     * @param nameTags on the one side the name on the other the amount of steps to take. By default 1 step = 1 tick
     * @param ticksPerStep the amount of ticks to wait for each step.
     */
    public TickableWoolColorModifier(LinkedHashMap<WoolColor, Integer> nameTags, int ticksPerStep) {
        this(nameTags, ticksPerStep, ModificationPriority.NORMAL);
    }

    private TickableWoolColorModifier(LinkedHashMap<WoolColor, Integer> nameTags, int ticksPerStep, ModificationPriority priority) {
        this.nameTags = nameTags;
        this.ticksPerStep = ticksPerStep;
        this.priority = priority;

        this.iterator = this.nameTags.entrySet().iterator();
        proceed(); // Select first
    }

    @Override
    public ItemStack modify(ItemStack itemStack) {

        if(current == null || !(itemStack.getData() instanceof Wool))
            return itemStack;

        Wool wool = (Wool) itemStack.getData();

        wool.setColor(current.getColor());

        return itemStack;
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
            Map.Entry<WoolColor, Integer> val = iterator.next();
            this.current = this.next;
            this.next = val.getKey();

            return val.getValue()*ticksPerStep;
        }

        // List end reached => jump to start
        this.iterator = this.nameTags.entrySet().iterator();
        return proceed();
    }
}
