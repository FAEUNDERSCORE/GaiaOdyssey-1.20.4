package net.faeunderscore.gaiaodyssey;

import net.fabricmc.api.ModInitializer;

import net.faeunderscore.gaiaodyssey.item.GOItems;
import net.faeunderscore.gaiaodyssey.item.itemgroup.GOItemGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GaiaOdyssey implements ModInitializer {
	public static final String MOD_ID = "gaiaodyssey";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		GOItemGroups.registerItemGroups();
		GOItems.registerItems();
	}
}