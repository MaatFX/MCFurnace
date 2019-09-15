package fr.mathieu.mcfurnace.furnace.simplegenerator.model.container;

import fr.mathieu.mcfurnace.utils.MCFurnaceBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class AbstractSimpleGeneratorContainer extends Container {

    private final IInventory simpleGeneratorInventory;

    private IIntArray simpleGeneratorData;

    public AbstractSimpleGeneratorContainer(int p_i50087_1_, PlayerInventory p_i50087_2_) {
        this(p_i50087_1_, p_i50087_2_, new Inventory(10), new IntArray(2));
    }

    public AbstractSimpleGeneratorContainer(int p_i50088_1_, PlayerInventory playerInventory, IInventory simpleGeneratorInventory, IIntArray simpleGeneratorData) {
        super(MCFurnaceBlocks.SIMPLE_GENERATOR_C, p_i50088_1_);
        assertInventorySize(simpleGeneratorInventory, 9);


        this.simpleGeneratorData = simpleGeneratorData;
        this.simpleGeneratorInventory = simpleGeneratorInventory;
        simpleGeneratorInventory.openInventory(playerInventory.player);


        this.addSlot(new Slot(simpleGeneratorInventory, 0, 56, 35));

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                this.addSlot(new Slot(simpleGeneratorInventory, j + i * 3 + 1, 110 + j * 18, 17 + i * 18));
            }
        }


        for(int k = 0; k < 3; ++k) {
            for(int i1 = 0; i1 < 9; ++i1) {
                this.addSlot(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
            }
        }

        for(int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(playerInventory, l, 8 + l * 18, 142));
        }

        this.trackIntArray(simpleGeneratorData);

    }

    public AbstractSimpleGeneratorContainer(int i, PlayerInventory playerInventory, PacketBuffer packetBuffer) {
        this(i, playerInventory);

    }

    /**
     * Determines whether supplied player can use this container
     */
    public boolean canInteractWith(PlayerEntity playerIn) {
        return this.simpleGeneratorInventory.isUsableByPlayer(playerIn);
    }

    /**
     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
     * inventory and the other inventory(s).
     */
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index < 9) {
                if (!this.mergeItemStack(itemstack1, 9, 45, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, 9, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }

    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(PlayerEntity playerIn) {
        super.onContainerClosed(playerIn);
        this.simpleGeneratorInventory.closeInventory(playerIn);
    }

    @OnlyIn(Dist.CLIENT)
    public int getCookProgressionScaled() {
        int i = this.simpleGeneratorData.get(0);
        int j = this.simpleGeneratorData.get(1);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }

}
