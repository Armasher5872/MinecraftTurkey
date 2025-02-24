package net.phazoganon.turkeymod.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.phazoganon.turkeymod.TurkeyMod;
import net.phazoganon.turkeymod.item.ModItems;

public class ModItemModelProvider extends ModelProvider {
    public ModItemModelProvider(PackOutput output) {
        super(output, TurkeyMod.MODID);
    }
    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.RAW_TURKEY.value(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.COOKED_TURKEY.value(), ModelTemplates.FLAT_ITEM);
        itemModels.generateSpawnEgg(ModItems.TURKEY_SPAWN_EGG.value(), 0x402e27, 0x34d5eb);
    }
}