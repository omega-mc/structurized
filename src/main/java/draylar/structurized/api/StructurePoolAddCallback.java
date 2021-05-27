package draylar.structurized.api;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

public interface StructurePoolAddCallback {

    Event<StructurePoolAddCallback> EVENT = EventFactory.createArrayBacked(StructurePoolAddCallback.class,
            listeners -> initialPool -> {
                for (StructurePoolAddCallback listener : listeners) {
                    listener.onAdd(initialPool);
                }
            }
    );

    void onAdd(FabricStructurePool initialPool);
}