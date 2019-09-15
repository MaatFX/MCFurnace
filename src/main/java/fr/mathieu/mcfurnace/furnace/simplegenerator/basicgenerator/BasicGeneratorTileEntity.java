package fr.mathieu.mcfurnace.furnace.simplegenerator.basicgenerator;

import fr.mathieu.mcfurnace.furnace.simplegenerator.model.tileentity.AbstractSimpleGeneratorTileEntity;
import fr.mathieu.mcfurnace.utils.MCFurnaceBlocks;
import fr.mathieu.mcfurnace.utils.MCFurnaceType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class BasicGeneratorTileEntity extends AbstractSimpleGeneratorTileEntity {

    public BasicGeneratorTileEntity() {
        super(MCFurnaceBlocks.BASIC_GENERATOR_TE, MCFurnaceType.BASIC_GENERATOR.cookSpeed, MCFurnaceType.BASIC_GENERATOR.output);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("block.mcfurnace.basic_generator");
    }
}
