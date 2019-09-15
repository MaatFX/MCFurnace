package fr.mathieu.mcfurnace.furnace.simplefurnace.model.slot;

import fr.mathieu.mcfurnace.furnace.simplefurnace.model.container.AbstractSimpleFurnaceContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class SimpleFurnaceFuelSlot extends Slot {

    private final AbstractSimpleFurnaceContainer abstractSimpleFurnaceContainer;

    public SimpleFurnaceFuelSlot(AbstractSimpleFurnaceContainer abstractSimpleFurnaceContainer, IInventory iInventory, int p_i50084_3_, int p_i50084_4_, int p_i50084_5_) {
        super(iInventory, p_i50084_3_, p_i50084_4_, p_i50084_5_);
        this.abstractSimpleFurnaceContainer = abstractSimpleFurnaceContainer;
    }

    /**
     * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
     */
    public boolean isItemValid(ItemStack stack) {
        return this.abstractSimpleFurnaceContainer.isFuel(stack) || isBucket(stack);
    }

    public int getItemStackLimit(ItemStack stack) {
        return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
    }

    public static boolean isBucket(ItemStack stack) {
        return stack.getItem() == Items.BUCKET;
    }
}
