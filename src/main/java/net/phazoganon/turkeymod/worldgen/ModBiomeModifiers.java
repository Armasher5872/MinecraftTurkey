package net.phazoganon.turkeymod.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.phazoganon.turkeymod.TurkeyMod;
import net.phazoganon.turkeymod.entity.ModEntities;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> TURKEY_SPAWN = registerKey("turkey_spawn");
    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var biomes = context.lookup(Registries.BIOME);
        context.register(TURKEY_SPAWN, BiomeModifiers.AddSpawnsBiomeModifier.singleSpawn(
                biomes.getOrThrow(BiomeTags.IS_TAIGA),
                new MobSpawnSettings.SpawnerData(ModEntities.TURKEY.get(), 5, 1, 4)
        ));
    }
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(TurkeyMod.MODID, name));
    }
}