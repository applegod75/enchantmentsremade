package com.applegoddess.enchantmentsremade.blockentity.custom;

import com.applegoddess.enchantmentsremade.blockentity.ModBlockEntities;
import com.applegoddess.enchantmentsremade.menu.custom.EnchantmentTableMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class EnchantmentTableBlockEntity extends BlockEntity implements MenuProvider {
    public EnchantmentTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ENCHANTMENT_TABLE_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int id, Inventory inv, Player player){
    }
}
