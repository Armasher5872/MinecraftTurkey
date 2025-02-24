package net.phazoganon.turkeymod.entity;

import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.phazoganon.turkeymod.TurkeyMod;
import net.phazoganon.turkeymod.entity.custom.TurkeyEntity;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, TurkeyMod.MODID);
    public static final Supplier<EntityType<TurkeyEntity>> TURKEY = ENTITY_TYPES.register("turkey", () -> EntityType.Builder.of(TurkeyEntity::new, MobCategory.CREATURE).sized(0.4F, 0.4F).build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(TurkeyMod.MODID, "turkey"))));
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}