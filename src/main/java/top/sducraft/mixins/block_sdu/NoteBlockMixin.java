package top.sducraft.mixins.block_sdu;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NoteBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.sducraft.Settings;

@Mixin(NoteBlock.class)
public abstract class NoteBlockMixin extends Block {
    public NoteBlockMixin(Properties properties) {
        super(properties);
    }
@Inject(method = "updateShape",at=@At("HEAD"), cancellable = true)
protected void updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2, CallbackInfoReturnable<BlockState> cir) {
    if(Settings.notebookIgnoreupdate) {
        boolean isVerticalAxis = direction.getAxis() == Direction.Axis.Y;
        if (isVerticalAxis) {
            // 在 Y 轴方向时不改变 Instrument 属性
            cir.setReturnValue(blockState);
        } else {
            // 其他方向时调用原有的方法
            cir.setReturnValue(super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2));
        }
    }
}

}
