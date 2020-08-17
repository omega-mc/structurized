package draylar.structurized.mixin;

import draylar.structurized.api.FabricStructurePool;
import draylar.structurized.api.StructurePoolAddCallback;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePools;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StructurePools.class)
public class StructurePoolsRegistry {

    @Inject(method = "register", at = @At("HEAD"))
    private static void injectAdd(StructurePool pool, CallbackInfoReturnable<StructurePool> cir) {
        StructurePoolAddCallback.EVENT.invoker().add(new FabricStructurePool(pool));
    }
}
