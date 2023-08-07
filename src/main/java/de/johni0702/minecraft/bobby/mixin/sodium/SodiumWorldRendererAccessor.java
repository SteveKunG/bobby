package de.johni0702.minecraft.bobby.mixin.sodium;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import me.jellysquid.mods.sodium.client.render.SodiumWorldRenderer;
import me.jellysquid.mods.sodium.client.render.chunk.RenderSectionManager;

@Mixin(SodiumWorldRenderer.class)
public interface SodiumWorldRendererAccessor
{
    @Accessor("renderSectionManager")
    RenderSectionManager getRenderSectionManager();
}