package pl.skidam.last_slot.mixin;

import net.minecraft.server.ServerMetadata;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerMetadata.Players.class)
public class ServerMetadataPlayersMixin {
    @Final @Mutable @Shadow private int online;
    @Final @Mutable @Shadow private int max;

    @Inject(method = "getOnlinePlayerCount", at = @At("HEAD"))
    private void setPlayerFakeMaxSlot1(CallbackInfoReturnable<Integer> cir) {
        max = online + 1;
    }

    @Inject(method = "getPlayerLimit", at = @At("HEAD"))
    private void setPlayerFakeMaxSlot10(CallbackInfoReturnable<Integer> cir) {
        max = online + 1;
    }
}
