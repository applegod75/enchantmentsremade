package com.applegoddess.enchantmentsremade.blockitem;

import com.applegoddess.enchantmentsremade.EnchantmentsRemade;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBlockItems {
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.createItems(EnchantmentsRemade.MODID);

    public static final DeferredHolder<Item, BlockItem> TEST_BLOCK_ITEM = BLOCK_ITEMS.register(
            "test_block_item",
            registryName ->
    )

    public static void register(IEventBus eventBus){
        BLOCK_ITEMS.register(eventBus);
    }
}
