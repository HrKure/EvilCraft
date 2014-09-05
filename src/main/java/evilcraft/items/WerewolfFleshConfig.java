package evilcraft.items;

import evilcraft.core.config.ItemConfig;

/**
 * Config for the {@link WerewolfFlesh}
 * @author rubensworks
 *
 */
public class WerewolfFleshConfig extends ItemConfig {
    
    /**
     * The unique instance.
     */
    public static WerewolfFleshConfig _instance;

    /**
     * Make a new instance.
     */
    public WerewolfFleshConfig() {
        super(
        	true,
            "werewolfFlesh",
            null,
            WerewolfFlesh.class
        );
    }
    
}
