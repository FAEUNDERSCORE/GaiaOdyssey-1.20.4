package net.faeunderscore.gaiaodyssey.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.faeunderscore.gaiaodyssey.GaiaOdyssey;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class GOBlocks {

    public static final Block CRYSTAL_CLUSTER = registerBlock("crystal_cluster",
            new AmethystClusterBlock(14.0F, 3.0F, AbstractBlock.Settings.copy(Blocks.AMETHYST_CLUSTER)));
    public static final Block FOUNDRY_BASE = registerBlock("foundry_base",
            new Block(AbstractBlock.Settings.copy(Blocks.REINFORCED_DEEPSLATE)));
    public static final Block FOUNDRY_BLOCK = registerBlock("foundry_block",
            new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_BRICKS)));
    public static final Block FOUNDRY_FURNACE = registerBlock("foundry_furnace",
            new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_BRICKS)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(GaiaOdyssey.MOD_ID, name), block);
    }

    public static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(GaiaOdyssey.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        GaiaOdyssey.LOGGER.info("Registering ModBlocks for " + GaiaOdyssey.MOD_ID);
    }
}
