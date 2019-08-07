package fr.mathieu.mcfurnace.furnace.basicfurnace;

import fr.mathieu.mcfurnace.utils.MCFurnaceBlocksRegistered;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;


public class BasicFurnaceTileEntity extends AbstractBasicFurnaceTileEntity {

    public BasicFurnaceTileEntity() {
        super(MCFurnaceBlocksRegistered.BASIC_FURNACE_TE, IRecipeType.SMELTING);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new FurnaceContainer(id, player, this, this.furnaceData);
    }




}
