package org.cyclops.evilcraft.entity.monster;

import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.cyclops.cyclopscore.config.extendedconfig.EntityConfig;
import org.cyclops.cyclopscore.helper.Helpers;
import org.cyclops.evilcraft.EvilCraft;
import org.cyclops.evilcraft.client.render.entity.RenderWerewolf;
import org.cyclops.evilcraft.client.render.entity.ModelWerewolf;

/**
 * Config for the {@link EntityWerewolf}.
 * @author rubensworks
 *
 */
public class EntityWerewolfConfig extends EntityConfig<EntityWerewolf> {

    public EntityWerewolfConfig() {
        super(
                EvilCraft._instance,
                "werewolf",
                eConfig -> EntityType.Builder.<EntityWerewolf>create(EntityWerewolf::new, EntityClassification.MONSTER)
                        .size(0.6F, 2.9F),
                getDefaultSpawnEggItemConfigConstructor(EvilCraft._instance, "werewolf_spawn_egg", Helpers.RGBToInt(105, 67, 18), Helpers.RGBToInt(57, 25, 10))
        );
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public EntityRenderer<? super EntityWerewolf> getRender(EntityRendererManager entityRendererManager, ItemRenderer itemRenderer) {
        return new RenderWerewolf(entityRendererManager, this, new ModelWerewolf(), 0.5F);
    }
    
}