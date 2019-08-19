package fr.mathieu.mcfurnace.furnace.diamondfurnace;

import fr.mathieu.mcfurnace.furnace.diamondfurnace.container.DiamondFurnaceContainer;
import fr.mathieu.mcfurnace.utils.MCFurnaceBlocksRegistered;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;


public class DiamondFurnaceTileEntity extends AbstractDiamondFurnaceTileEntity {

    public DiamondFurnaceTileEntity() {
        super(MCFurnaceBlocksRegistered.DIAMOND_FURNACE_TE, IRecipeType.SMELTING);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new DiamondFurnaceContainer(id, player, this, this.furnaceData);
    }




}
