package evilcraft.api.config.elementtypeaction;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import evilcraft.api.config.DummyConfig;

public class LiquidAction extends IElementTypeAction<DummyConfig>{

    @Override
    public void preRun(DummyConfig eConfig, Configuration config) {
        eConfig.ID = 1;
    }

    @Override
    public void postRun(DummyConfig eConfig, Configuration config) {
        // Save the config inside the correct element
        eConfig.save();
        
        // Register
        FluidRegistry.registerFluid((Fluid) eConfig.getSubInstance());
        
        // Add I18N
        //LanguageRegistry.instance().addStringLocalization("fluid."+eConfig.NAMEDID+".name", eConfig.NAME);
    }

}
