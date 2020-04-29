package draylar.structurized;

import draylar.structurized.api.StructurePoolAddCallback;
import net.fabricmc.api.ModInitializer;
import net.minecraft.structure.pool.SinglePoolElement;

public class Structurized implements ModInitializer {

    @Override
    public void onInitialize() {
        StructurePoolAddCallback.EVENT.register(structurePool -> {
            if(structurePool.getUnderlying().getId().toString().equals("minecraft:village/plains/houses")) {
                structurePool.addStructurePoolElement(new SinglePoolElement("village/desert/houses/desert_small_house_1"), 50);
            }
        });
    }
}
