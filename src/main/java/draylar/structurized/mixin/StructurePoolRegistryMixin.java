package draylar.structurized.mixin;

import draylar.structurized.api.FabricStructurePool;
import draylar.structurized.api.StructurePoolAddCallback;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(StructurePoolRegistry.class)
public class StructurePoolRegistryMixin {

    @Inject(method = "add", at = @At("HEAD"))
    private void injectAdd(StructurePool pool, CallbackInfo ci) {
        StructurePoolAddCallback.EVENT.invoker().add(new FabricStructurePool(pool));
    }
}
