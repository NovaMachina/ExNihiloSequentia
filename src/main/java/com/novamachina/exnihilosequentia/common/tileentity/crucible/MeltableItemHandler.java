package com.novamachina.exnihilosequentia.common.tileentity.crucible;

import javax.annotation.Nonnull;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.items.ItemStackHandler;

public class MeltableItemHandler extends ItemStackHandler {

    private boolean crucibleHasRoom = true;

    public MeltableItemHandler() {
        super(1);
    }

    @Nonnull
    @Override
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
        if (crucibleHasRoom) {
            return super.insertItem(slot, stack, simulate);
        }
        return stack;
    }

    public void setCrucibleHasRoom(boolean crucibleHasRoom) {
        this.crucibleHasRoom = crucibleHasRoom;
    }

    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
        return MeltableItems.isMeltable(stack.getItem());
    }

    @Override
    protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
        return 4;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt = super.serializeNBT();
        nbt.putBoolean("hasRoom", crucibleHasRoom);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        super.deserializeNBT(nbt);
        this.crucibleHasRoom = nbt.getBoolean("hasRoom");
    }

    @Nonnull
    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        return ItemStack.EMPTY;
    }
}
