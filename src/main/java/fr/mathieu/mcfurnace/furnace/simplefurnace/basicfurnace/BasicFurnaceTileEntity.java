package fr.mathieu.mcfurnace.furnace.simplefurnace.basicfurnace;

import fr.mathieu.mcfurnace.furnace.simplefurnace.model.container.SimpleFurnaceContainer;
import fr.mathieu.mcfurnace.furnace.simplefurnace.model.tileentity.AbstractSimpleFurnaceTileEntity;
import fr.mathieu.mcfurnace.utils.MCFurnaceBlocks;
import fr.mathieu.mcfurnace.utils.MCFurnaceType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;


public class BasicFurnaceTileEntity extends AbstractSimpleFurnaceTileEntity {


    public BasicFurnaceTileEntity() {
        super(MCFurnaceBlocks.BASIC_FURNACE_TE, IRecipeType.SMELTING, MCFurnaceType.BASIC_FURNACE.cookSpeed, MCFurnaceType.BASIC_FURNACE.output);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("block.mcfurnace.basic_furnace");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new SimpleFurnaceContainer(id, player, this, this.furnaceData);
    }

}
