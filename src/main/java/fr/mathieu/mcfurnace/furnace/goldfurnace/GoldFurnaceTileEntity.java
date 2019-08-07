package fr.mathieu.mcfurnace.furnace.goldfurnace;

import fr.mathieu.mcfurnace.utils.MCFurnaceBlocksRegistered;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.BlastFurnaceContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class GoldFurnaceTileEntity extends AbstractGoldFurnaceTileEntity {

    public GoldFurnaceTileEntity() {
        super(MCFurnaceBlocksRegistered.GOLD_FURNACE_TE, IRecipeType.SMELTING);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new BlastFurnaceContainer(id, player, this, this.furnaceData);
    }
}
