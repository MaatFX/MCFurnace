package fr.mathieu.mcfurnace.furnace.simplegenerator.model.tileentity;


import fr.mathieu.mcfurnace.furnace.simplegenerator.model.container.SimpleGeneratorContainer;
import fr.mathieu.mcfurnace.items.MCFurnaceCard;
import fr.mathieu.mcfurnace.utils.MCFurnaceMain;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nullable;

public abstract class AbstractSimpleGeneratorTileEntity extends LockableLootTileEntity implements ITickableTileEntity, ISidedInventory {

    private static final int[] SLOTS_UP = new int[]{0};
    private static final int[] SLOTS_DOWN = new int[]{9,8,7,6,5,4,3,2,1};
    private static final int[] SLOTS_HORIZONTAL = new int[]{0};
    private NonNullList<ItemStack> stacks = NonNullList.withSize(10, ItemStack.EMPTY);

    private int cookTimeTotal = 200;
    private int cookTime = 0;
    private int extraOutput;
    private int cookSpeed;

    /*
   This array is used to store and access data linked to this tileEntity such as burnTime or cookTime
   It is useful to get data from outside of this class
    */
    private IIntArray simpleGeneratorData = new IIntArray() {
        @Override
        public int get(int index) {
            switch (index) {
                case 0:
                    return AbstractSimpleGeneratorTileEntity.this.cookTime;
                case 1:
                    return AbstractSimpleGeneratorTileEntity.this.cookTimeTotal;
                default:
                    return -1;
            }
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0:
                    AbstractSimpleGeneratorTileEntity.this.cookTime = value;
                case 1:
                    AbstractSimpleGeneratorTileEntity.this.cookTimeTotal = value;
            }
        }

        @Override
        public int size() {
            return 2;
        }
    };

    protected AbstractSimpleGeneratorTileEntity(TileEntityType<?> typeIn, int cookSpeed, int extraOutput) {
        super(typeIn);
        this.cookSpeed = cookSpeed;
        this.extraOutput = extraOutput;
    }



    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.stacks;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.stacks = itemsIn;
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        this.stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.stacks);
        cookTime = compound.getInt("cookTime");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        ItemStackHelper.saveAllItems(compound, this.stacks);
        compound.putInt("cookTime", cookTime);
        return compound;
    }

    @Override
    protected ITextComponent getDefaultName() {
        return null;
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new SimpleGeneratorContainer(id, player, this, simpleGeneratorData);
    }

    @Override
    public int getSizeInventory() {
        return 10;
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack itemstack : this.stacks) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    @Override
    public void tick() {

        if (!world.isRemote) {

            if (isItemInSlotValid() && !isContainerFull() && isSlotAvailableFor(getCurrentCardInSlot().getFromBlock())) {

                cookTime += cookSpeed;

                if (cookTime >= cookTimeTotal) {
                    cookTime = 0;
                    produceNewBlock();
                    this.markDirty();
                }
            } else if (cookTime > 0) {
                cookTime--;
            }
        }


    }

    public boolean isSlotAvailableFor(Block block) {

        boolean isSlotAvailableFor = false;
        for (int i = 1; i < 10; i++) {

            if ((stacks.get(i).getItem() == block.asItem() || stacks.get(i).isEmpty()) && !isItemStackFull(stacks.get(i))) {
                isSlotAvailableFor = true;
                break;
            }
        }
            return  isSlotAvailableFor;
    }

    public boolean isItemInSlotValid() {
        return this.stacks.get(0).getItem().getClass() == MCFurnaceCard.class;
    }

    public MCFurnaceCard getCurrentCardInSlot() {
        if (this.stacks.get(0).getItem().getClass() == MCFurnaceCard.class)
            return (MCFurnaceCard)this.stacks.get(0).getItem();
        else
            return null;
    }

    public void produceNewBlock() {
        MCFurnaceCard card = getCurrentCardInSlot();

        Block b = card.getFromBlock();

        for (int i = 1; i < 10; i++) {

            ItemStack outputItemStack = stacks.get(i);

            if (outputItemStack.isEmpty()) {

                ItemStack itemStack = new ItemStack(b);
                itemStack.setCount(extraOutput);

                this.stacks.set(i, itemStack);
                break;

            } else if (!isItemStackFull(outputItemStack) && b.asItem() == outputItemStack.getItem()) {
                outputItemStack.grow(extraOutput);
                break;
            }
        }

        int itemDamage = stacks.get(0).getDamage();
        MCFurnaceMain.LOGGER.info(itemDamage);

        if (itemDamage < 31)
            stacks.get(0).setDamage(stacks.get(0).getDamage() + 1);
        else if (itemDamage == 31)
            stacks.get(0).shrink(1);

    }

    public boolean isItemStackFull(ItemStack itemStack) {
        return itemStack.getCount() == 64;
    }

    public boolean isContainerFull() {
        int count = stacks.stream().mapToInt(ItemStack::getCount).sum();
        return count == 64 * 9; // 64 * 9 is the max size allowed by the container
    }

    net.minecraftforge.common.util.LazyOptional<? extends net.minecraftforge.items.IItemHandler>[] handlers =
            net.minecraftforge.items.wrapper.SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);

    @Override
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable Direction facing) {
        if (!this.removed && facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (facing == Direction.UP)
                return handlers[0].cast();
            else if (facing == Direction.DOWN)
                return handlers[1].cast();
            else
                return handlers[2].cast();
        }
        return super.getCapability(capability, facing);
    }

    /**
     * invalidates a tile entity
     */
    @Override
    public void remove() {
        super.remove();
        for (int x = 0; x < handlers.length; x++)
            handlers[x].invalidate();
    }

    public int[] getSlotsForFace(Direction side) {
        if (side == Direction.DOWN) {
            return SLOTS_DOWN;
        } else {
            return side == Direction.UP ? SLOTS_UP : SLOTS_HORIZONTAL;
        }
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side.
     */
    public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction) {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side.
     */
    public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
        return direction == Direction.DOWN && index != 0;
    }
}
