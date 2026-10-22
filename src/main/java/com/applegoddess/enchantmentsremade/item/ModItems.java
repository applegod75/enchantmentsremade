package com.applegoddess.enchantmentsremade.item;

import com.applegoddess.enchantmentsremade.EnchantmentsRemade;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EnchantmentsRemade.MODID);

    public static final DeferredHolder<Item, Item> TEST_ITEM = ITEMS.registerItem(
            "test_item",
            Item::new,
            props -> props
    );

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
