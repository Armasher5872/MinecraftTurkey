package net.phazoganon.turkeymod.entity.client.turkey;

import net.minecraft.client.renderer.entity.state.ChickenRenderState;
import net.minecraft.world.entity.AnimationState;

public class TurkeyRendererState extends ChickenRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState fallingAnimationState = new AnimationState();
}