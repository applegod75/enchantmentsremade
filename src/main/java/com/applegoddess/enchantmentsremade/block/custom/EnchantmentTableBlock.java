package com.applegoddess.enchantmentsremade.block.custom;

import com.applegoddess.enchantmentsremade.blockentity.custom.EnchantmentTableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.EnchantingTableBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class EnchantmentTableBlock extends Block implements EntityBlock {
    public EnchantmentTableBlock(BlockBehaviour.Properties props){
        super(props);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state){
        return new EnchantmentTableBlockEntity(pos, state);
    }

    protected InteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos,
                                          Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof EnchantmentTableBlockEntity enchantmentTableBlockEntity){
            if (player.isCrouching()){
                player.openMenu(new SimpleMenuProvider(enchantmentTableBlockEntity, Component.translatable("block.enchantmentsremade.enchantment_table_block")), pos);
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.FAIL;
    }
}
