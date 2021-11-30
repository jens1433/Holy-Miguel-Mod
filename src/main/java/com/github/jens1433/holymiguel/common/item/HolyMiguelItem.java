package com.github.jens1433.holymiguel.common.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class HolyMiguelItem extends Item {

    public HolyMiguelItem(Properties properties) {
        super(properties);
    }



    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity instanceof Ocelot)
        {
            Level world = player.level;
            if(!world.isClientSide()) {
                LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT, world);
                bolt.setPos(new Vec3(entity.getX(), entity.getY(), entity.getZ()));
                bolt.setDamage(100);
                world.addFreshEntity(bolt);
                ItemStack stack1 = new ItemStack(Items.NETHERITE_BLOCK, 64);
                ItemEntity item = new ItemEntity(world, player.getX(), player.getY() + 0.5D, player.getZ(), stack1);
                item.setInvulnerable(true);
                world.addFreshEntity(item);
                stack.shrink(1);
                return true;
            }
        }
        return super.onLeftClickEntity(stack, player, entity);
    }
}
