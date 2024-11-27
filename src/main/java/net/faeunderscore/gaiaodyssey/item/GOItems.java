package net.faeunderscore.gaiaodyssey.item;

import net.faeunderscore.gaiaodyssey.GaiaOdyssey;
import net.faeunderscore.gaiaodyssey.item.armor.CrystalArmorItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class GOItems {

    public static final Item CRYSTAL = registerItem("crystal", new Item(new Item.Settings()));
    public static final Item CRYSTAL_SHARD = registerItem("crystal_shard", new Item(new Item.Settings()));

    public static final Item TELLURIC_METAL = registerItem("telluric_metal", new Item(new Item.Settings()));
    public static final Item TELLURIC_PLATE = registerItem("telluric_plate", new Item(new Item.Settings()));
    public static final Item RAW_TELLURIC = registerItem("raw_telluric", new Item(new Item.Settings()));

    public static final Item CRYSTAL_ARMOR_HELMET = registerItem("crystal_armor_helmet", new CrystalArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Settings()));
    public static final Item CRYSTAL_ARMOR_CHESTPLATE = registerItem("crystal_armor_chestplate", new CrystalArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
    public static final Item CRYSTAL_ARMOR_LEGGINGS = registerItem("crystal_armor_leggings", new CrystalArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Settings()));
    public static final Item CRYSTAL_ARMOR_BOOTS = registerItem("crystal_armor_boots", new CrystalArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(GaiaOdyssey.MOD_ID, name), item);
    }

    public static void registerItems(){
        GaiaOdyssey.LOGGER.info("Registering Items for " + GaiaOdyssey.MOD_ID);
    }
}
