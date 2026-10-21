package com.applegoddess.enchantmentsremade.item;

import com.applegoddess.enchantmentsremade.EnchantmentsRemade;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EnchantmentsRemade.MODID);

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
