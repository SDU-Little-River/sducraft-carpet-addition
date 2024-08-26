package top.sducraft.mixins.block_campus.BlockPlaceIgnoreCondition;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.sducraft.Settings;

@Mixin(StandingSignBlock.class)
public abstract class StangingSignBlcokMixin extends SignBlock {
    protected StangingSignBlcokMixin(WoodType woodType, Properties properties) {super(woodType, properties);}

    @Inject(method = "canSurvive",at = @At("HEAD"), cancellable = true)
    protected void canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
        if(Settings.blockPlaceIgnoreCondition){
            cir.setReturnValue(true);
        }
    }
}
