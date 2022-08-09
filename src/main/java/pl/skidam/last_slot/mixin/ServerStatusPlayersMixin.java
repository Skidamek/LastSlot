package pl.skidam.last_slot.mixin;

import net.minecraft.network.protocol.status.ServerStatus;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerStatus.Players.class)
public class ServerStatusPlayersMixin {
    @Final @Mutable @Shadow private int numPlayers;
    @Final @Mutable @Shadow private int maxPlayers;

    @Inject(method = "getNumPlayers", at = @At("HEAD"))
    private void setPlayerFakeMaxSlot1(CallbackInfoReturnable<Integer> cir) {
        maxPlayers = numPlayers + 1;
    }

    @Inject(method = "getMaxPlayers", at = @At("HEAD"))
    private void setPlayerFakeMaxSlot2(CallbackInfoReturnable<Integer> cir) {
        maxPlayers = numPlayers + 1;
    }
}
