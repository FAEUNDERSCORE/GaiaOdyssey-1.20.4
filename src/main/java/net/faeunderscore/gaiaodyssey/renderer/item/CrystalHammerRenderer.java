package net.faeunderscore.gaiaodyssey.renderer.item;

import net.faeunderscore.gaiaodyssey.GaiaOdyssey;
import net.faeunderscore.gaiaodyssey.item.custom.CrystalHammerItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class CrystalHammerRenderer extends GeoItemRenderer<CrystalHammerItem> {
    public CrystalHammerRenderer() {
        super(new DefaultedItemGeoModel<>(Identifier.of(GaiaOdyssey.MOD_ID, "crystal_hammer")));
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
