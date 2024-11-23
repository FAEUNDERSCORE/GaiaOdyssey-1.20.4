package net.faeunderscore.gaiaodyssey.renderer.armor;

import net.faeunderscore.gaiaodyssey.GaiaOdyssey;
import net.faeunderscore.gaiaodyssey.item.armor.CrystalArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class CrystalArmorRenderer extends GeoArmorRenderer<CrystalArmorItem> {
    public CrystalArmorRenderer() {
        super(new DefaultedItemGeoModel<>(Identifier.of(GaiaOdyssey.MOD_ID, "armor/crystal_armor")));
    }
}
