package top.sducraft.mixins.block_sdu.BlockPlaceIgnoreCondition;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.sducraft.Settings;

@Mixin(VineBlock.class)
public abstract class VineBlockMixin extends Block {
    public VineBlockMixin(Properties properties) {super(properties);}

    @Inject(method = "canSurvive",at = @At("HEAD"), cancellable = true)
    private void canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir){
       if(Settings.blockPlaceIgnoreCondition) {
           cir.setReturnValue(true);
       }
    }

    @Inject(method = "canSupportAtFace",at = @At("HEAD"), cancellable = true)
    private void canSupportAtFace(BlockGetter blockGetter, BlockPos blockPos, Direction direction, CallbackInfoReturnable<Boolean> cir) {
        if(Settings.blockPlaceIgnoreCondition) {
            cir.setReturnValue(true);
        }
    }
}
