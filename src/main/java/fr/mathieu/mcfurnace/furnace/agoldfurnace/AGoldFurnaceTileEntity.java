package fr.mathieu.mcfurnace.furnace.agoldfurnace;

import fr.mathieu.mcfurnace.furnace.agoldfurnace.container.AGoldFurnaceContainer;
import fr.mathieu.mcfurnace.utils.MCFurnaceBlocks;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class AGoldFurnaceTileEntity extends AbstractAGoldFurnaceTileEntity {

    public AGoldFurnaceTileEntity() {
        super(MCFurnaceBlocks.AGOLD_FURNACE_TE, IRecipeType.SMELTING);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new AGoldFurnaceContainer(id, player, this, this.furnaceData);
    }
}
