package top.sducraft.mixins.block_sdu.BlockPlaceIgnoreCondition;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.sducraft.Settings;

@Mixin(MultifaceBlock.class)
public abstract class MultifaceBlockMixin extends Block {
    public MultifaceBlockMixin(Properties properties) {super(properties);}

    @Inject(method = "canSurvive",at=@At("HEAD"), cancellable = true)
    protected void canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
        if(Settings.blockPlaceIgnoreCondition){
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "canAttachTo",at = @At("HEAD"), cancellable = true)
    private static void canAttachTo(BlockGetter blockGetter, Direction direction, BlockPos blockPos, BlockState blockState, CallbackInfoReturnable<Boolean> cir) {
        if(Settings.blockPlaceIgnoreCondition){
            cir.setReturnValue(true);
        }
    }

}
