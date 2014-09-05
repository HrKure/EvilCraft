package evilcraft.blocks;

import evilcraft.core.config.BlockConfig;

/**
 * Config for the {@link LightningBomb}.
 * @author rubensworks
 *
 */
public class LightningBombConfig extends BlockConfig {
    
    /**
     * The unique instance.
     */
    public static LightningBombConfig _instance;

    /**
     * Make a new instance.
     */
    public LightningBombConfig() {
        super(
        	true,
            "lightningBomb",
            null,
            LightningBomb.class
        );
    }
    
}
