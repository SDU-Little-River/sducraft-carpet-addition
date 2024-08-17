package top.sducraft.mixins.SDUcraft3RD;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.LeadItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LeadItem.class)

public abstract class LeadItemMixin extends Item {

    public LeadItemMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "bindPlayerMobs",at = @At(value = "HEAD"), cancellable = true)
    private static void leadBandBeeDisable(Player player, Level level, BlockPos blockPos, CallbackInfoReturnable<InteractionResult> cir){
//       if(Settings.leadBandBeeDisable) {
//           int i = blockPos.getX();
//           int j = blockPos.getY();
//           int k = blockPos.getZ();
//           List<Mob> A = level.getEntitiesOfClass(Mob.class, new AABB((double)i - 7.0, (double)j - 7.0, (double)k - 7.0, (double)i + 7.0, (double)j + 7.0, (double)k + 7.0));
//            Iterator<Mob> B = A.iterator();
//             if ( B == EntityType.BEE){
//            cir.setReturnValue(InteractionResult.FAIL);
//        }
//        }
    }
}
