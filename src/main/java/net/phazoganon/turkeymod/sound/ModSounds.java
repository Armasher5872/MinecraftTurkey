package net.phazoganon.turkeymod.sound;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.phazoganon.turkeymod.TurkeyMod;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, TurkeyMod.MODID);
    public static final Supplier<SoundEvent> TURKEY_AMBIENT = registerSoundEvents("turkey_ambient");
    public static final Supplier<SoundEvent> TURKEY_HURT = registerSoundEvents("turkey_hurt");
    public static final Supplier<SoundEvent> TURKEY_DEATH = registerSoundEvents("turkey_death");
    private static Supplier<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TurkeyMod.MODID, name)));
    }
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
