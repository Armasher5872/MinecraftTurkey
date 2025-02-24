package net.phazoganon.turkeymod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.phazoganon.turkeymod.TurkeyMod;
import net.phazoganon.turkeymod.entity.ModEntities;
import net.phazoganon.turkeymod.food.ModConsumables;
import net.phazoganon.turkeymod.food.ModFoods;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TurkeyMod.MODID);
    public static final DeferredItem<Item> TURKEY_SPAWN_EGG = ITEMS.register("turkey_spawn_egg", () -> new SpawnEggItem(ModEntities.TURKEY.get(), (new Item.Properties()).setId(prefix("turkey_spawn_egg"))));
    public static final DeferredItem<Item> RAW_TURKEY = ITEMS.register("raw_turkey", () -> new Item((new Item.Properties()).setId(prefix("raw_turkey")).food(ModFoods.RAW_TURKEY, ModConsumables.RAW_TURKEY)));
    public static final DeferredItem<Item> COOKED_TURKEY = ITEMS.register("cooked_turkey", () -> new Item((new Item.Properties()).setId(prefix("cooked_turkey")).food(ModFoods.COOKED_TURKEY)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    private static ResourceKey<Item> prefix(String path) {
        return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TurkeyMod.MODID, path));
    }
}