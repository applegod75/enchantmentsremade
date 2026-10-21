package com.applegoddess.enchantmentsremade.block;

import com.applegoddess.enchantmentsremade.EnchantmentsRemade;
import com.applegoddess.enchantmentsremade.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(EnchantmentsRemade.MODID);

    public static final DeferredBlock<Block> TEST_BLOCK = registerBlock(
            "test_block",
            props -> new Block(props
                    .destroyTime(2.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.GRAVEL)
                    .lightLevel(state -> 7)
            )
    );

    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> func){
        DeferredBlock<T> rtn = BLOCKS.registerBlock(name, func);
        registerBlockItem(name, rtn);
        return rtn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.registerItem(name, props -> new BlockItem(block.get(), props.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
