package net.faeunderscore.gaiaodyssey.renderer.item;

import net.faeunderscore.gaiaodyssey.GaiaOdyssey;
import net.faeunderscore.gaiaodyssey.item.armor.CrystalArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class CrystalArmorItemRenderer extends GeoItemRenderer<CrystalArmorItem> {
    public CrystalArmorItemRenderer() {
        super(new DefaultedItemGeoModel<>(Identifier.of(GaiaOdyssey.MOD_ID, "armor/crystal_armor")));
    }
}
