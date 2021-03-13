package draylar.structurized.mixin;

import draylar.structurized.api.FabricStructurePool;
import draylar.structurized.api.StructurePoolAddCallback;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.util.dynamic.RegistryOps;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.SimpleRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Map;

@Mixin(DynamicRegistryManager.class)
public abstract class DynamicRegistryManagerMixin {

    @Inject(method = "load(Lnet/minecraft/util/dynamic/RegistryOps;Lnet/minecraft/util/registry/DynamicRegistryManager$Impl;Lnet/minecraft/util/registry/DynamicRegistryManager$Info;)V", at = @At(value = "TAIL"), cancellable = true, locals = LocalCapture.CAPTURE_FAILSOFT)
    private static <E> void load(RegistryOps<?> ops, DynamicRegistryManager.Impl manager, DynamicRegistryManager.Info<E> info, CallbackInfo ci, RegistryKey<? extends Registry<E>> registryKey, SimpleRegistry<E> simpleRegistry) {
        if (registryKey.getValue().toString().contains("template_pool")) {
            for (Map.Entry<RegistryKey<Object>, Object> e : ((SimpleRegistryAccessor) simpleRegistry).getKeyToEntry().entrySet()) {
                if (e.getValue() instanceof StructurePool) {
                    StructurePoolAddCallback.EVENT.invoker().add(new FabricStructurePool((StructurePool) e.getValue()));
                }
            }
        }
    }
}