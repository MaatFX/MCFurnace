package fr.mathieu.mcfurnace.furnace.simplegenerator.model.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;

public class SimpleGeneratorFuelSlot extends Slot {

    public SimpleGeneratorFuelSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }
}
