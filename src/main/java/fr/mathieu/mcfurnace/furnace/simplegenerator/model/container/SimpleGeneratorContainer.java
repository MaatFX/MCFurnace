package fr.mathieu.mcfurnace.furnace.simplegenerator.model.container;


import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;

public class SimpleGeneratorContainer extends AbstractSimpleGeneratorContainer {

    public SimpleGeneratorContainer(int p_i50088_1_, PlayerInventory playerInventory, IInventory simpleExtractorInventory, IIntArray simpleExtractorData) {
        super(p_i50088_1_, playerInventory, simpleExtractorInventory, simpleExtractorData);
    }

    public SimpleGeneratorContainer(int i, PlayerInventory playerInventory, PacketBuffer packetBuffer) {
        super(i, playerInventory, packetBuffer);
    }
}
