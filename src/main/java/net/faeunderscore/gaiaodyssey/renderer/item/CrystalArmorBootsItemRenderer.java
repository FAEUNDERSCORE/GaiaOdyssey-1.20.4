package net.faeunderscore.gaiaodyssey.renderer.item;

import net.faeunderscore.gaiaodyssey.GaiaOdyssey;
import net.faeunderscore.gaiaodyssey.item.armor.CrystalArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class CrystalArmorBootsItemRenderer extends GeoItemRenderer<CrystalArmorItem> {
    public CrystalArmorBootsItemRenderer() {
        super(new DefaultedItemGeoModel<>(Identifier.of(GaiaOdyssey.MOD_ID, "crystal_armor_boots")));
    }
}
