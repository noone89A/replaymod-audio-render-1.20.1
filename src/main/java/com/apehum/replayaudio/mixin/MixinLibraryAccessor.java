package com.apehum.replayaudio.mixin;

import net.minecraft.client.sound.SoundEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SoundEngine.class)
public interface MixinLibraryAccessor {
    @Accessor
    long getDevicePointer();
}
