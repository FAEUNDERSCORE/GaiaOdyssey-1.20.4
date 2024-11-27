package net.faeunderscore.gaiaodyssey;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.faeunderscore.gaiaodyssey.block.GOBlocks;
import net.minecraft.client.render.RenderLayer;

public class GaiaOdysseyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(GOBlocks.CRYSTAL_CLUSTER, RenderLayer.getCutout());
    }
}
