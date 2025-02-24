package net.phazoganon.turkeymod.event;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.phazoganon.turkeymod.TurkeyMod;
import net.phazoganon.turkeymod.entity.ModEntities;
import net.phazoganon.turkeymod.entity.client.turkey.TurkeyRenderer;

@EventBusSubscriber(modid = TurkeyMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntities.TURKEY.get(), TurkeyRenderer::new);
    }
}