package com.applegoddess.enchantmentsremade.blockentity.custom;

import com.applegoddess.enchantmentsremade.blockentity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class EnchantmentTableBlockEntity extends BlockEntity {
    public EnchantmentTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ENCHANTMENT_TABLE_BLOCK_ENTITY.get(), pos, state);
    }
}
