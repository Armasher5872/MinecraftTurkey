package net.phazoganon.turkeymod.entity.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.phazoganon.turkeymod.entity.ModEntities;
import net.phazoganon.turkeymod.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

public class TurkeyEntity extends Animal {
    public static final AnimationState idleAnimationState = new AnimationState();
    public static final AnimationState fallingAnimationState = new AnimationState();
    public TurkeyEntity(EntityType<? extends TurkeyEntity> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, Ingredient.of(Items.BEETROOT_SEEDS), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createAnimalAttributes().add(Attributes.MAX_HEALTH, 6.0).add(Attributes.MOVEMENT_SPEED, 0.35);
    }
    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide) {
            this.setupAnimationStates();
        }
    }
    private void setupAnimationStates() {
        if (this.fallingAnimationState.isStarted() || this.walkAnimation.isMoving()) {
            this.idleAnimationState.stop();
        }
        else {
            this.idleAnimationState.startIfStopped(this.tickCount);
        }
    }
    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(Items.BEETROOT_SEEDS);
    }
    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return ModEntities.TURKEY.get().create(serverLevel, EntitySpawnReason.BREEDING);
    }
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.TURKEY_AMBIENT.get();
    }
    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.TURKEY_HURT.get();
    }
    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.TURKEY_DEATH.get();
    }
}