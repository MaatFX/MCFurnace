package fr.mathieu.mcfurnace.furnace.adiamondfurnace;

import fr.mathieu.mcfurnace.furnace.adiamondfurnace.container.ADiamondFurnaceContainer;
import fr.mathieu.mcfurnace.utils.MCFurnaceBlocks;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ADiamondFurnaceTileEntity extends AbstractADiamondFurnaceTileEntity {

    public ADiamondFurnaceTileEntity() {
        super(MCFurnaceBlocks.ADIAMOND_FURNACE_TE, IRecipeType.SMELTING);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new ADiamondFurnaceContainer(id, player, this, this.furnaceData);
    }
}
