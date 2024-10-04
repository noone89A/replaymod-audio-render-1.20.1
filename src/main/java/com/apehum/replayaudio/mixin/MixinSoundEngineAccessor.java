package com.apehum.replayaudio.mixin;

import net.minecraft.client.sound.SoundEngine;
import net.minecraft.client.sound.SoundSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SoundSystem.class)
public interface MixinSoundEngineAccessor {

    @Accessor
    SoundEngine getSoundEngine();
}
