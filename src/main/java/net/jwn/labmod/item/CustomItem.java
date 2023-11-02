package net.jwn.labmod.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CustomItem extends Item {
    public CustomItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.addTag("hello");
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
