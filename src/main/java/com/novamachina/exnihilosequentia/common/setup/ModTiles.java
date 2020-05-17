package com.novamachina.exnihilosequentia.common.setup;

import com.novamachina.exnihilosequentia.common.tileentity.sieve.SieveTile;
import com.novamachina.exnihilosequentia.common.utility.Constants;
import com.novamachina.exnihilosequentia.common.utility.Constants.Blocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTiles {

    private static final DeferredRegister<TileEntityType<?>> TILES =
        new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Constants.ModInfo.MOD_ID);

    public static final RegistryObject<TileEntityType<SieveTile>> SIEVE = TILES
        .register(Blocks.SIEVE,
            () -> TileEntityType.Builder.create(SieveTile::new, ModBlocks.SIEVE.get())
                .build(null));

    public static void init(IEventBus eventBus) {
        TILES.register(eventBus);
    }
}