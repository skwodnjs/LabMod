package net.jwn.labmod.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Skeleton.class)
public class MixinSkeleton extends Mob {
    int timer;

    protected MixinSkeleton(EntityType<? extends Mob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    @Inject(at = @At("HEAD"), method = "tick")
    public void tick(CallbackInfo ci) {
        if (!this.level().isClientSide) {
            if (this.getTags().contains("hello")) {
                System.out.println("NO AI");
                this.setNoAi(true);
                timer += 1;
                if (timer >= 60) {
                    timer = 0;
                    System.out.println("YES AI");
                    this.setNoAi(false);
                    this.getTags().remove("hello");
                }
            }
        }
    }

    @Override
    @Shadow
    protected void defineSynchedData() {}

    @Override
    @Shadow
    public void readAdditionalSaveData(CompoundTag pCompound) {}

    @Override
    @Shadow
    public void addAdditionalSaveData(CompoundTag pCompound) {}
}
