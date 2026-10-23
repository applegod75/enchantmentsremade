package com.applegoddess.enchantmentsremade.menu.custom;

import com.applegoddess.enchantmentsremade.EnchantmentsRemade;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class EnchantmentTableScreen extends AbstractContainerScreen<EnchantmentTableMenu> {
    private static final Identifier GUI_TEXTURE = Identifier.fromNamespaceAndPath(EnchantmentsRemade.MODID, "textures/gui/pedestal/pedestal_gui.png");

    public EnchantmentTableScreen(EnchantmentTableMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor gui, int mouseX, int mouseY, float a){
        super.extractBackground(gui, mouseX, mouseY, a);
        int x =  width - (imageWidth / 2);
        int y = height - (imageHeight / 2);

        gui.blit(RenderPipelines.GUI_TEXTURED, GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight, 256, 256);
    }
}
