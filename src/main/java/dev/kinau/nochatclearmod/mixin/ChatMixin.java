package dev.kinau.nochatclearmod.mixin;

import net.minecraft.client.gui.components.ChatComponent;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatComponent.class)
public class ChatMixin {

	@Inject(at = @At(value = "HEAD"), method = "clearMessages", cancellable = true)
	private void init(boolean disconnect, CallbackInfo ci) {
		if (disconnect)
			ci.cancel();
	}

}