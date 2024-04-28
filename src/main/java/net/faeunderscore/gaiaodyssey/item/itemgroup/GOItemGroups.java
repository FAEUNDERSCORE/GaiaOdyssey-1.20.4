package net.faeunderscore.gaiaodyssey.item.itemgroup;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.faeunderscore.gaiaodyssey.GaiaOdyssey;
import net.faeunderscore.gaiaodyssey.item.GOItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GOItemGroups {

    public static final ItemGroup GO_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(GaiaOdyssey.MOD_ID, "go_item"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.gaiaodyssey_item"))
                    .icon(() -> new ItemStack(GOItems.CRYSTAL)).entries((displayContext, entries) -> {
                        entries.add(GOItems.CRYSTAL);
                        entries.add(GOItems.CRYSTAL_SHARD);
                        entries.add(GOItems.TELLURIC_METAL);
                        entries.add(GOItems.TELLURIC_PLATE);
                        entries.add(GOItems.RAW_TELLURIC);
                    }).build());

    public static void registerItemGroups(){
        GaiaOdyssey.LOGGER.info("Registering Item Groups for " + GaiaOdyssey.MOD_ID);
    }
}
