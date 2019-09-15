package fr.mathieu.mcfurnace.furnace.simplegenerator.irongenerator;

import fr.mathieu.mcfurnace.furnace.simplegenerator.model.tileentity.AbstractSimpleGeneratorTileEntity;
import fr.mathieu.mcfurnace.utils.MCFurnaceBlocks;
import fr.mathieu.mcfurnace.utils.MCFurnaceType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class IronGeneratorTileEntity extends AbstractSimpleGeneratorTileEntity {

    public IronGeneratorTileEntity() {
        super(MCFurnaceBlocks.IRON_GENERATOR_TE, MCFurnaceType.IRON_GENERATOR.cookSpeed, MCFurnaceType.IRON_GENERATOR.output);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("block.mcfurnace.iron_generator");
    }
}
