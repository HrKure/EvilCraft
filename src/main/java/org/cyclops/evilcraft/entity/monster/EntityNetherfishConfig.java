package org.cyclops.evilcraft.entity.monster;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.cyclops.cyclopscore.config.extendedconfig.EntityConfig;
import org.cyclops.cyclopscore.helper.Helpers;
import org.cyclops.evilcraft.EvilCraft;
import org.cyclops.evilcraft.client.render.entity.RenderNetherfish;

/**
 * Config for the {@link EntityNetherfish}.
 * @author rubensworks
 *
 */
public class EntityNetherfishConfig extends EntityConfig<EntityNetherfish> {

    public EntityNetherfishConfig() {
        super(
                EvilCraft._instance,
                "netherfish",
                eConfig -> EntityType.Builder.<EntityNetherfish>of(EntityNetherfish::new, MobCategory.MONSTER)
                        .sized(0.4F, 0.3F)
                        .fireImmune(),
                getDefaultSpawnEggItemConfigConstructor(EvilCraft._instance, "netherfish_spawn_egg", Helpers.RGBToInt(73, 27, 20), Helpers.RGBToInt(160, 45, 27))
        );
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onEntityAttributesModification);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public EntityRenderer<? super EntityNetherfish> getRender(EntityRendererProvider.Context renderContext, ItemRenderer itemRenderer) {
        return new RenderNetherfish(renderContext, this);
    }

    public void onEntityAttributesModification(EntityAttributeModificationEvent event) {
        // Copied from Monster.createMonsterAttributes()
        event.add(getInstance(), Attributes.ATTACK_DAMAGE);
        event.add(getInstance(), Attributes.FOLLOW_RANGE, 16.0D);
        event.add(getInstance(), Attributes.ATTACK_KNOCKBACK);
        event.add(getInstance(), Attributes.MAX_HEALTH);
        event.add(getInstance(), Attributes.KNOCKBACK_RESISTANCE);
        event.add(getInstance(), Attributes.MOVEMENT_SPEED);
        event.add(getInstance(), Attributes.ARMOR);
        event.add(getInstance(), Attributes.ARMOR_TOUGHNESS);
        event.add(getInstance(), net.minecraftforge.common.ForgeMod.SWIM_SPEED.get());
        event.add(getInstance(), net.minecraftforge.common.ForgeMod.NAMETAG_DISTANCE.get());
        event.add(getInstance(), net.minecraftforge.common.ForgeMod.ENTITY_GRAVITY.get());

        event.add(getInstance(), Attributes.FOLLOW_RANGE, 35.0D);
        event.add(getInstance(), Attributes.MOVEMENT_SPEED, 0.25D);
        event.add(getInstance(), Attributes.ATTACK_DAMAGE, 2.0D);
    }

}
