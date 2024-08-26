package top.sducraft.mixins.block_campus.BlockPlaceIgnoreCondition;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.sducraft.Settings;

@Mixin(RedStoneWireBlock.class)
public abstract class RedStoneWireBlockMixin extends Block {
    public RedStoneWireBlockMixin(Properties properties) {super(properties);}

    @Inject(method = "canSurviveOn",at=@At("HEAD"), cancellable = true)
    private void canSurviveOn(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, CallbackInfoReturnable<Boolean> cir) {
        if(Settings.blockPlaceIgnoreCondition){
            cir.setReturnValue(true);
        }
    }
}
