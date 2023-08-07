package de.johni0702.minecraft.bobby.sodium;

import de.johni0702.minecraft.bobby.mixin.sodium.SodiumWorldRendererAccessor;
import me.jellysquid.mods.sodium.client.render.SodiumWorldRenderer;

public class SodiumChunkStatusListenerImpl implements ChunkStatusListener {
    @Override
    public void onChunkAdded(int x, int z) {
        SodiumWorldRenderer sodiumRenderer = SodiumWorldRenderer.instanceNullable();
        if (sodiumRenderer instanceof SodiumWorldRendererAccessor accessor) {
            accessor.getRenderSectionManager().onChunkAdded(x, z);
        }
    }

    @Override
    public void onChunkRemoved(int x, int z) {
        SodiumWorldRenderer sodiumRenderer = SodiumWorldRenderer.instanceNullable();
        if (sodiumRenderer instanceof SodiumWorldRendererAccessor accessor) {
            accessor.getRenderSectionManager().onChunkRemoved(x, z);
        }
    }
}
