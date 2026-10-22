package com.applegoddess.enchantmentsremade.blockentity;

import com.applegoddess.enchantmentsremade.EnchantmentsRemade;
import com.applegoddess.enchantmentsremade.block.ModBlocks;
import com.applegoddess.enchantmentsremade.blockentity.custom.EnchantmentTableBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, EnchantmentsRemade.MODID);

    public static final Supplier<BlockEntityType<EnchantmentTableBlockEntity>> ENCHANTMENT_TABLE_BLOCK_ENTITY =
            BLOCK_ENTITY_TYPES.register(
                    "enchantment_table_block_entity",
                    () -> new BlockEntityType<>(
                            EnchantmentTableBlockEntity::new,
                            false,
                            ModBlocks.ENCHANTMENT_TABLE_BLOCK.get()
                    )
            );

    public static void register(IEventBus eventBus){
        BLOCK_ENTITY_TYPES.register(eventBus);
    }
}
