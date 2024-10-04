package com.apehum.replayaudio.mixin;

import com.replaymod.render.rendering.VideoRenderer;
import net.minecraft.client.option.SimpleOption;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(VideoRenderer.class)
public class MixinVideoRenderer {

    @Redirect(method = "setup", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/SimpleOption;setValue(Ljava/lang/Object;)V"))
    private void setSoundVolume(SimpleOption<?> instance, Object object) {
        // do nothing
    }
}
