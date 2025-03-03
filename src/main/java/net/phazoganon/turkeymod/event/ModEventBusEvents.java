package net.phazoganon.turkeymod.event;

import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.phazoganon.turkeymod.TurkeyMod;
import net.phazoganon.turkeymod.entity.ModEntities;
import net.phazoganon.turkeymod.entity.client.ModModelLayers;
import net.phazoganon.turkeymod.entity.client.turkey.TurkeyModel;
import net.phazoganon.turkeymod.entity.custom.TurkeyEntity;

@EventBusSubscriber(modid = TurkeyMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions registerLayerDefinitions) {
        registerLayerDefinitions.registerLayerDefinition(ModModelLayers.TURKEY_LAYER, TurkeyModel::createBodyLayer);
        registerLayerDefinitions.registerLayerDefinition(ModModelLayers.BABY_TURKEY_LAYER, () -> TurkeyModel.createBodyLayer().apply(TurkeyModel.BABY_TRANSFORMER));
    }
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent entityAttributeCreationEvent) {
        entityAttributeCreationEvent.put(ModEntities.TURKEY.get(), TurkeyEntity.createAttributes().build());
    }
    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(
                ModEntities.TURKEY.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.REPLACE
        );
    }
}