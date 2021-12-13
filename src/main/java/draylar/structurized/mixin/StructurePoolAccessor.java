package draylar.structurized.mixin;

import java.util.List;

import com.mojang.datafixers.util.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;

@Mixin(StructurePool.class)
public interface StructurePoolAccessor {
    @Accessor(value = "elements")
    List<StructurePoolElement> getElements();

    @Accessor(value = "elementCounts")
    List<Pair<StructurePoolElement, Integer>> getElementCounts();

    @Accessor(value = "elementCounts")
    void setElementCounts(List<Pair<StructurePoolElement, Integer>> list);
}
