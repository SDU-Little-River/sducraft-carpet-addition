package top.sducraft.mixins.block_campus.BlockPlaceIgnoreCondition;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.sducraft.Settings;

@Mixin(PointedDripstoneBlock.class)
public abstract class PointedDripstoneBlockMixin extends Block implements Fallable, SimpleWaterloggedBlock {
    public PointedDripstoneBlockMixin(Properties properties) {super(properties);}

    @Inject(method = "getStateForPlacement",at=@At("HEAD"), cancellable = true)
    private void getStateForPlacement(BlockPlaceContext blockPlaceContext, CallbackInfoReturnable<BlockState> cir){
        if(Settings.blockPlaceIgnoreCondition){
            cir.setReturnValue(super.getStateForPlacement(blockPlaceContext));
        }
    }

    @Inject(method = "canSurvive",at=@At("HEAD"), cancellable = true)
    private void canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir){
         if(Settings.blockPlaceIgnoreCondition) {
             cir.setReturnValue(true);
      }
    }
}
