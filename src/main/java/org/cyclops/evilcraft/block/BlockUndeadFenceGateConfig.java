package org.cyclops.evilcraft.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.cyclops.cyclopscore.config.extendedconfig.BlockConfig;
import org.cyclops.cyclopscore.helper.BlockHelpers;
import org.cyclops.evilcraft.EvilCraft;

/**
 * Config for the Undead Fence Gate.
 * @author rubensworks
 *
 */
public class BlockUndeadFenceGateConfig extends BlockConfig {

    public BlockUndeadFenceGateConfig() {
        super(
                EvilCraft._instance,
            "undead_fence_gate",
                eConfig -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_ORANGE)
                        .strength(2.0F, 3.0F)
                        .sound(SoundType.WOOD)),
                getDefaultItemConstructor(EvilCraft._instance)
        );
    }

    @Override
    public void onForgeRegistered() {
        super.onForgeRegistered();
        BlockHelpers.setFireInfo(getInstance(), 5, 20);
    }

}