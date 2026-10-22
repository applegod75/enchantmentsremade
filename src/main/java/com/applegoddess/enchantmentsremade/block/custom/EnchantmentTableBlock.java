package com.applegoddess.enchantmentsremade.block.custom;

import com.applegoddess.enchantmentsremade.blockentity.custom.EnchantmentTableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.EnchantingTableBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class EnchantmentTableBlock extends Block implements EntityBlock {
    public EnchantmentTableBlock(BlockBehaviour.Properties props){
        super(props);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state){
        return new EnchantmentTableBlockEntity(pos, state);
    }
}
