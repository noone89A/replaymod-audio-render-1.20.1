package com.apehum.replayaudio;

import com.replaymod.render.rendering.VideoRenderer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReplayModAudioRender implements ModInitializer {
	public static final String MOD_ID = "replaymodaudiorender";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
	}

	public static AudioRender AUDIO_RENDER;

	public static boolean isRendering() {
		return AUDIO_RENDER != null;
	}

	public static void startRender(@NotNull VideoRenderer renderer) {
		if (AUDIO_RENDER != null) return;

		AUDIO_RENDER = new AudioRender(renderer);
		MinecraftClient.getInstance().submitAndJoin(ReplayModAudioRender::reloadDevice);
	}

	public static void stopRender() {
		if (AUDIO_RENDER == null) return;

		AUDIO_RENDER.flush();
		AUDIO_RENDER = null;

		MinecraftClient.getInstance().submitAndJoin(ReplayModAudioRender::reloadDevice);
	}

	private static void reloadDevice() {
		MinecraftClient.getInstance().getSoundManager().reloadSounds();
	}
}