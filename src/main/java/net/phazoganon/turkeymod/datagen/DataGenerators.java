package net.phazoganon.turkeymod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.phazoganon.turkeymod.TurkeyMod;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = TurkeyMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(@NotNull GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        generator.addProvider(true, new ModItemModelProvider(packOutput));
        generator.addProvider(true, new ModDataPackProvider(packOutput, lookupProvider));
        generator.addProvider(true, new ModLootTableProvider(packOutput, lookupProvider));
    }
}