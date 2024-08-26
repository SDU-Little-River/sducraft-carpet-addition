package top.sducraft.mixins.block_campus.BlockPlaceIgnoreCondition;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.SeagrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.sducraft.Settings;

@Mixin(SeagrassBlock.class)
public abstract class SeagrassBlockMixin extends BushBlock implements BonemealableBlock, LiquidBlockContainer {
    protected SeagrassBlockMixin(Properties properties) {super(properties);}

    @Inject(method = "getStateForPlacement",at=@At("HEAD"), cancellable = true)
    private void getStateForPlacement(BlockPlaceContext blockPlaceContext, CallbackInfoReturnable<BlockState> cir){
        if(Settings.blockPlaceIgnoreCondition){
            cir.setReturnValue(super.getStateForPlacement(blockPlaceContext));
        }
    }
}
