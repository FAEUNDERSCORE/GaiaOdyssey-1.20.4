package net.faeunderscore.gaiaodyssey.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.faeunderscore.gaiaodyssey.GaiaOdyssey;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class GOItems {

    public static final Item CRYSTAL = registerItem("crystal", new Item(new FabricItemSettings()));
    public static final Item CRYSTAL_SHARD = registerItem("crystal_shard", new Item(new FabricItemSettings()));

    public static final Item TELLURIC_METAL = registerItem("telluric_metal", new Item(new FabricItemSettings()));
    public static final Item TELLURIC_PLATE = registerItem("telluric_plate", new Item(new FabricItemSettings()));
    public static final Item RAW_TELLURIC = registerItem("raw_telluric", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(GaiaOdyssey.MOD_ID, name), item);
    }

    public static void registerItems(){
        GaiaOdyssey.LOGGER.info("Registering Items for " + GaiaOdyssey.MOD_ID);
    }
}
