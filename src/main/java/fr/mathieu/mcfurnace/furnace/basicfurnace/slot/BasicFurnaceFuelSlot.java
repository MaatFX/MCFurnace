package fr.mathieu.mcfurnace.furnace.basicfurnace.slot;

import fr.mathieu.mcfurnace.furnace.basicfurnace.container.AbstractBasicFurnaceContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class BasicFurnaceFuelSlot extends Slot {
    private final AbstractBasicFurnaceContainer field_216939_a;

    public BasicFurnaceFuelSlot(AbstractBasicFurnaceContainer p_i50084_1_, IInventory p_i50084_2_, int p_i50084_3_, int p_i50084_4_, int p_i50084_5_) {
        super(p_i50084_2_, p_i50084_3_, p_i50084_4_, p_i50084_5_);
        this.field_216939_a = p_i50084_1_;
    }

    /**
     * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
     */
    public boolean isItemValid(ItemStack stack) {
        return this.field_216939_a.isFuel(stack) || isBucket(stack);
    }

    public int getItemStackLimit(ItemStack stack) {
        return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
    }

    public static boolean isBucket(ItemStack stack) {
        return stack.getItem() == Items.BUCKET;
    }
}
