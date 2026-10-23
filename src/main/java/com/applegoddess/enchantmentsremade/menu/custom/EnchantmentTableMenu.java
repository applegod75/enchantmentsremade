package com.applegoddess.enchantmentsremade.menu.custom;

import com.applegoddess.enchantmentsremade.block.ModBlocks;
import com.applegoddess.enchantmentsremade.blockentity.custom.EnchantmentTableBlockEntity;
import com.applegoddess.enchantmentsremade.menu.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;

import javax.annotation.Nullable;

public class EnchantmentTableMenu extends AbstractContainerMenu {
    public final EnchantmentTableBlockEntity blockEntity;
    private final Level level;

    public EnchantmentTableMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new ItemStacksResourceHandler(1));
    }

    public EnchantmentTableMenu(int containerId, @Nullable Inventory inv, BlockEntity blockEntity, ItemStacksResourceHandler handler) {
        super(ModMenuTypes.ENCHANTMENT_TABLE_MENU.get(), containerId);
        this.blockEntity = (EnchantmentTableBlockEntity) blockEntity;
        this.level = inv.player.level();

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        addSlot(new ResourceHandlerSlot(handler, handler::set, 0, 80, 35) {
            @Override
            public int getMaxStackSize() {
                return 1;
            }
        });
    }

    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int ET_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    private static final int ET_INVENTORY_SLOT_COUNT = 1;

    @Override
    public ItemStack quickMoveStack(Player playerIn, int i){
        Slot src = slots.get(i);
        if (src == null || !src.hasItem()) return ItemStack.EMPTY;

        ItemStack srcStack = src.getItem();
        ItemStack srcCopy = srcStack.copy();

        if (i < ET_INVENTORY_FIRST_SLOT_INDEX) {
            if (!moveItemStackTo(srcStack, ET_INVENTORY_FIRST_SLOT_INDEX, ET_INVENTORY_FIRST_SLOT_INDEX + ET_INVENTORY_SLOT_COUNT, false)){
                return ItemStack.EMPTY;
            }
        } else if (i < ET_INVENTORY_FIRST_SLOT_INDEX + ET_INVENTORY_SLOT_COUNT){
            if (!moveItemStackTo(srcStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)){
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("invalid i: " + i);
        }

        if (srcStack.getCount() == 0){ // the entire stack was moved
            src.set(ItemStack.EMPTY);
        } else {
            src.setChanged();
        }
        src.onTake(playerIn, srcStack);
        return srcCopy;
    }

    @Override
    public boolean stillValid(Player player){
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, ModBlocks.ENCHANTMENT_TABLE_BLOCK.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
