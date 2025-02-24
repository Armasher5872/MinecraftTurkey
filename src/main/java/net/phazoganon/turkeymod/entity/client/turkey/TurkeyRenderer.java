package net.phazoganon.turkeymod.entity.client.turkey;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.phazoganon.turkeymod.TurkeyMod;
import net.phazoganon.turkeymod.entity.custom.TurkeyEntity;

@OnlyIn(Dist.CLIENT)
public class TurkeyRenderer extends MobRenderer<TurkeyEntity, TurkeyRendererState, TurkeyModel<TurkeyRendererState>> {
    public TurkeyRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new TurkeyModel<>(pContext.bakeLayer(TurkeyModel.MODEL_LAYER_LOCATION)), 0.25f);
    }
    @Override
    public TurkeyRendererState createRenderState() {
        return new TurkeyRendererState();
    }
    @Override
    public ResourceLocation getTextureLocation(TurkeyRendererState turkeyRendererState) {
        return ResourceLocation.fromNamespaceAndPath(TurkeyMod.MODID, "textures/entity/turkey.png");
    }
}