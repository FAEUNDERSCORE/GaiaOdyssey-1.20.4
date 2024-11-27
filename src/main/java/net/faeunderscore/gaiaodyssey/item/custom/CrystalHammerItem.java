package net.faeunderscore.gaiaodyssey.item.custom;

import net.faeunderscore.gaiaodyssey.renderer.item.*;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class CrystalHammerItem extends PickaxeItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private static final RawAnimation IDLE_ANIMATION = RawAnimation
            .begin()
            .then("animation.crystal_hammer.idle", Animation.LoopType.LOOP);

    private static final RawAnimation BREAK_ANIMATION = RawAnimation
            .begin()
            .then("animation.crystal_hammer.break", Animation.LoopType.PLAY_ONCE);

    public CrystalHammerItem(Settings settings) {
        super(ToolMaterials.DIAMOND, settings);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        /*controllerRegistrar.add(new AnimationController<>(this, "hammer_controller",20, state -> {
            return state.setAndContinue(IDLE_ANIMATION);
        }).triggerableAnim("break", BREAK_ANIMATION));*/

    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        // break 3x3x1 area around the block
        BlockPos.iterate(pos.add(0, -1, -1), pos.add(0, 1, 1)).forEach(blockPos -> {
            if (blockPos.equals(pos)) {
                return;
            }

            BlockState blockState = world.getBlockState(blockPos);
            if (blockState.isOf(state.getBlock())) {
                world.breakBlock(blockPos, true, miner);
            }
        });
        return super.postMine(stack, world, state, pos, miner);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld() instanceof ServerWorld serverWorld){
            triggerAnim(context.getPlayer(), GeoItem.getOrAssignId(context.getStack(), serverWorld), "hammer_controller", "break");
        }

        return super.useOnBlock(context);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new CrystalHammerItem.CrystalHammerRenderProvider());
    }

    private class CrystalHammerRenderProvider implements GeoRenderProvider {
        private GeoItemRenderer<?> itemRenderer;

        @Override
        public @Nullable BuiltinModelItemRenderer getGeoItemRenderer() {
            if (itemRenderer == null) {
                itemRenderer = new CrystalHammerRenderer();
            }

            return itemRenderer;
        }
    }
}
