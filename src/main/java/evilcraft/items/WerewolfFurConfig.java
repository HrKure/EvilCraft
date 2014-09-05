package evilcraft.items;

import evilcraft.core.config.ItemConfig;

/**
 * Config for the {@link WerewolfFur}.
 * @author rubensworks
 *
 */
public class WerewolfFurConfig extends ItemConfig {
    
    /**
     * The unique instance.
     */
    public static WerewolfFurConfig _instance;

    /**
     * Make a new instance.
     */
    public WerewolfFurConfig() {
        super(
        	true,
            "werewolfFur",
            null,
            WerewolfFur.class
        );
    }
    
}
