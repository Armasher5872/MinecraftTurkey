package net.phazoganon.turkeymod.entity.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.phazoganon.turkeymod.TurkeyMod;

public class ModModelLayers {
    public static ModelLayerLocation TURKEY_LAYER = register("turkey");
    public static ModelLayerLocation BABY_TURKEY_LAYER = register("turkey_baby");
    private static ModelLayerLocation register(String entity) {
        return register(entity, "main");
    }
    private static ModelLayerLocation register(String entity, String main) {
        return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TurkeyMod.MODID, entity), main);
    }
}