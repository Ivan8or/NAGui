package ivan8or.fluidgui.components.presentation;

import ivan8or.fluidgui.components.transition.Transition;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class Slide {

    private final String slideName;
    private final Map<String, Transition> transitions;

    public Slide(String slideName) {
        this.slideName = slideName;
        transitions = new HashMap<>();
    }

    public String getName() {
        return slideName;
    }

    public boolean hasResponse(String goalSlide) {
        return transitions.containsKey(goalSlide);
    }

    public void addTransition(Transition response) {
        transitions.put(response.getEndSlide(), response);
    }

    // starts the transition to another slide
    // returns the total time it will take for the transition
    public int start(String goalSlide, Inventory inv, Map<String, Object> context, Plugin plugin) {
        try {
            return transitions.get(goalSlide).start(inv, context, false, plugin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
