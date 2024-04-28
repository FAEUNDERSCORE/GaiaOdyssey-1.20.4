package net.faeunderscore.gaiaodyssey.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.faeunderscore.gaiaodyssey.item.GOItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(GOItems.CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(GOItems.CRYSTAL_SHARD, Models.GENERATED);
        itemModelGenerator.register(GOItems.TELLURIC_METAL, Models.GENERATED);
        itemModelGenerator.register(GOItems.TELLURIC_PLATE, Models.GENERATED);
        itemModelGenerator.register(GOItems.RAW_TELLURIC, Models.GENERATED);
    }
}
