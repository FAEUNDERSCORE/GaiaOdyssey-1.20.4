package net.faeunderscore.gaiaodyssey.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.faeunderscore.gaiaodyssey.item.GOItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class RecipeProvider extends FabricRecipeProvider {
    private static List<ItemConvertible> TELLURIC_SMELTABLES = List.of(GOItems.RAW_TELLURIC);

    public RecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, TELLURIC_SMELTABLES, RecipeCategory.MISC, GOItems.TELLURIC_PLATE, 0.7F, 200, "telluric");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, GOItems.CRYSTAL,1)
                .pattern(" C ")
                .pattern("CCC")
                .pattern("CCC")
                .input('C', GOItems.CRYSTAL_SHARD)
                .criterion(hasItem(GOItems.CRYSTAL_SHARD), conditionsFromItem(GOItems.CRYSTAL_SHARD))
                .offerTo(exporter, new Identifier(getRecipeName(GOItems.CRYSTAL)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, GOItems.TELLURIC_METAL, 1)
                .input(GOItems.TELLURIC_PLATE, 4)
                .criterion(hasItem(GOItems.TELLURIC_PLATE), conditionsFromItem(GOItems.TELLURIC_PLATE))
                .offerTo(exporter);
    }
}
