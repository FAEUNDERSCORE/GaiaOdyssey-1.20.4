package net.faeunderscore.gaiaodyssey.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.faeunderscore.gaiaodyssey.block.GOBlocks;
import net.faeunderscore.gaiaodyssey.item.GOItems;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class LootTableProvider extends FabricBlockLootTableProvider {
    public LootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(GOBlocks.CRYSTAL_CLUSTER, GOItems.CRYSTAL_SHARD);
        addDrop(GOBlocks.FOUNDRY_BASE);
        addDrop(GOBlocks.FOUNDRY_BLOCK);
        addDrop(GOBlocks.FOUNDRY_FURNACE);
    }
}
