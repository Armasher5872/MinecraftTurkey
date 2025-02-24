package net.phazoganon.turkeymod.food;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties RAW_TURKEY = new FoodProperties.Builder().nutrition(3).saturationModifier(1.6f).build();
    public static final FoodProperties COOKED_TURKEY = new FoodProperties.Builder().nutrition(8).saturationModifier(10.0f).build();
}