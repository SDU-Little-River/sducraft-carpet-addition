package top.sducraft.mixins.block_sdu.BlockPlaceIgnoreCondition;

import net.minecraft.world.level.block.KelpPlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.sducraft.Settings;

@Mixin(KelpPlantBlock.class)
public abstract class KelpPlantBlockMixin {
    @Inject(method = "canAttachTo",at=@At("HEAD"), cancellable = true)
    protected void canAttachTo(BlockState blockState, CallbackInfoReturnable<Boolean> cir) {
        if(Settings.blockPlaceIgnoreCondition){
            cir.setReturnValue(true);
        }
    }

}
