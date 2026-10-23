package com.applegoddess.enchantmentsremade.menu;

import com.applegoddess.enchantmentsremade.EnchantmentsRemade;
import com.applegoddess.enchantmentsremade.menu.custom.EnchantmentTableMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, EnchantmentsRemade.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<EnchantmentTableMenu>> ENCHANTMENT_TABLE_MENU =
            registerMenuType("enchantment_table_menu", EnchantmentTableMenu::new);

    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory){
        return MENU_TYPES.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus){
        MENU_TYPES.register(eventBus);
    }
}
