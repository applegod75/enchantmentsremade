package com.applegoddess.enchantmentsremade.datagen;

import com.applegoddess.enchantmentsremade.EnchantmentsRemade;
import com.applegoddess.enchantmentsremade.block.ModBlocks;
import com.applegoddess.enchantmentsremade.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, EnchantmentsRemade.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels){
        blockModels.createTrivialCube(ModBlocks.TEST_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.ENCHANTMENT_TABLE_BLOCK.get());
        itemModels.generateFlatItem(ModItems.TEST_ITEM.get(), ModelTemplates.FLAT_ITEM);
    }
}
