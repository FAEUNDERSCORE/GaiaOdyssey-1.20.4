package net.faeunderscore.gaiaodyssey.item.armor;

import net.faeunderscore.gaiaodyssey.renderer.armor.CrystalArmorRenderer;
import net.faeunderscore.gaiaodyssey.renderer.item.CrystalArmorBootsItemRenderer;
import net.faeunderscore.gaiaodyssey.renderer.item.CrystalArmorChestplateItemRenderer;
import net.faeunderscore.gaiaodyssey.renderer.item.CrystalArmorHelmetItemRenderer;
import net.faeunderscore.gaiaodyssey.renderer.item.CrystalArmorLeggingsItemRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class CrystalArmorItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public CrystalArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, 20, state -> {
            return PlayState.CONTINUE;
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new CrystalArmorRenderProvider());
    }

    private class CrystalArmorRenderProvider implements GeoRenderProvider{
        private GeoArmorRenderer<?> renderer;
        private GeoItemRenderer<?> itemRenderer;

        @Override
        public @Nullable <T extends LivingEntity> BipedEntityModel<?> getGeoArmorRenderer(@Nullable T livingEntity, ItemStack itemStack, @Nullable EquipmentSlot equipmentSlot, @Nullable BipedEntityModel<T> original) {
            if (renderer == null) {
                renderer = new CrystalArmorRenderer();
            }
            return this.renderer;
        }

        @Override
        public @Nullable BuiltinModelItemRenderer getGeoItemRenderer() {
            if (itemRenderer == null) {
                switch (getType()){
                    case HELMET -> itemRenderer = new CrystalArmorHelmetItemRenderer();
                    case CHESTPLATE -> itemRenderer = new CrystalArmorChestplateItemRenderer();
                    case LEGGINGS -> itemRenderer = new CrystalArmorLeggingsItemRenderer();
                    case BOOTS -> itemRenderer = new CrystalArmorBootsItemRenderer();
                }
            }

            return itemRenderer;
        }




    }
}
