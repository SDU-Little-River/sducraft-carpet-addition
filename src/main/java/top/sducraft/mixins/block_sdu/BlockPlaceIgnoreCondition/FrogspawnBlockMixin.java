package top.sducraft.mixins.block_sdu.BlockPlaceIgnoreCondition;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FrogspawnBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.sducraft.Settings;

@Mixin(FrogspawnBlock.class)
public abstract class FrogspawnBlockMixin extends Block {
    public FrogspawnBlockMixin(Properties properties) {super(properties);}

    @Inject(method = "mayPlaceOn",at = @At("HEAD"), cancellable = true)
    private static void mayPlaceon(BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
        if(Settings.blockPlaceIgnoreCondition){
            cir.setReturnValue(true);
        }
    }
}
