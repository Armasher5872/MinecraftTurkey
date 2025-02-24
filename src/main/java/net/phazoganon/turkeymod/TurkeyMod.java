package net.phazoganon.turkeymod;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.phazoganon.turkeymod.entity.ModEntities;
import net.phazoganon.turkeymod.item.ModItems;
import net.phazoganon.turkeymod.sound.ModSounds;

@Mod(TurkeyMod.MODID)
public class TurkeyMod {
    public static final String MODID = "turkeymod";
    public TurkeyMod(IEventBus modEventBus) {
        modEventBus.addListener(this::addCreative);
        ModEntities.register(modEventBus);
        ModItems.register(modEventBus);
        ModSounds.register(modEventBus);
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        ResourceKey<CreativeModeTab> getTabKey = event.getTabKey();
        if (getTabKey == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.RAW_TURKEY);
            event.accept(ModItems.COOKED_TURKEY);
        }
        if (getTabKey == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.TURKEY_SPAWN_EGG);
        }
    }
}