package com.novamachina.exnihilosequentia.common.registries.defaults;

import com.novamachina.exnihilosequentia.common.init.ModBlocks;
import com.novamachina.exnihilosequentia.common.item.mesh.EnumMesh;
import com.novamachina.exnihilosequentia.common.item.ore.EnumOre;
import com.novamachina.exnihilosequentia.common.registries.sieve.SieveRegistry;
import net.minecraft.block.Blocks;

public class ImmersiveEngineering implements IDefaultRegistry {
    @Override
    public void registerSieve(SieveRegistry registry) {
        if (!EnumOre.ALUMINUM.isEnabled()) {
            registry.addMultiMeshDrop(Blocks.SAND, EnumOre.ALUMINUM.getPieceItem()
                .get(), null, 0.05F, 0.075F, null, false);
            registry.addMultiMeshDrop(ModBlocks.CRUSHED_END_STONE.get(), EnumOre.ALUMINUM.getPieceItem()
                .get(), null, null, 0.15F, 0.25F, false);
            EnumOre.ALUMINUM.setEnabled();
        }

        if (!EnumOre.COPPER.isEnabled()) {
            registry.addMultiMeshDrop(Blocks.GRAVEL, EnumOre.COPPER.getPieceItem()
                .get(), null, 0.05F, 0.075F, null, false);
            EnumOre.COPPER.setEnabled();
        }

        if (!EnumOre.SILVER.isEnabled()) {
            registry.addDrop(Blocks.SAND, EnumOre.SILVER.getPieceItem()
                .get(), 0.15F, EnumMesh.DIAMOND, false);
            registry.addMultiMeshDrop(ModBlocks.CRUSHED_END_STONE.get(), EnumOre.SILVER.getPieceItem()
                .get(), null, null, 0.15F, 0.25F, false);
            EnumModdedOre.SILVER.setEnabled();
        }

        if (!EnumOre.NICKEL.isEnabled()) {
            registry.addMultiMeshDrop(Blocks.GRAVEL, EnumOre.NICKEL.getPieceItem()
                .get(), null, 0.05F, 0.075F, 0.15F, false);
            EnumOre.NICKEL.setEnabled();
        }

        if (!EnumOre.LEAD.isEnabled()) {
            registry.addMultiMeshDrop(Blocks.GRAVEL, EnumOre.LEAD.getPieceItem()
                .get(), null, 0.05F, 0.075F, 0.15F, false);
            EnumOre.LEAD.setEnabled();
        }

        if (!EnumOre.URANIUM.isEnabled()) {
            registry.addMultiMeshDrop(Blocks.GRAVEL, EnumOre.URANIUM.getPieceItem()
                .get(), null, 0.05F, 0.075F, 0.15F, false);
            EnumOre.URANIUM.setEnabled();
        }
    }
}