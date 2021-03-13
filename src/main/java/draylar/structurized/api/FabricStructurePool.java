package draylar.structurized.api;

import com.mojang.datafixers.util.Pair;
import draylar.structurized.mixin.StructurePoolAccessor;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;

import java.util.ArrayList;
import java.util.List;

public class FabricStructurePool {

    private final StructurePool pool;

    public FabricStructurePool(StructurePool underlying) {
        this.pool = underlying;
    }

    public void addStructurePoolElement(StructurePoolElement element) {
        addStructurePoolElement(element, 1);
    }

    public void addStructurePoolElement(StructurePoolElement element, int weight) {
        //adds to elementCounts list
        List<Pair<StructurePoolElement, Integer>> list = new ArrayList<>(((StructurePoolAccessor) pool).getElementCounts());
        list.add(Pair.of(element, weight));
        ((StructurePoolAccessor) pool).setElementCounts(list);

        //adds to elements list
        for (int i = 0; i < weight; i++) {
            ((StructurePoolAccessor) pool).getElements().add(element);
        }
    }

    public StructurePool getStructurePool() {
        return pool;
    }
}
