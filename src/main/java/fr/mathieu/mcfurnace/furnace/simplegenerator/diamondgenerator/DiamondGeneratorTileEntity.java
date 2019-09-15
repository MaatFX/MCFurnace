package fr.mathieu.mcfurnace.furnace.simplegenerator.diamondgenerator;

import fr.mathieu.mcfurnace.furnace.simplegenerator.model.tileentity.AbstractSimpleGeneratorTileEntity;
import fr.mathieu.mcfurnace.utils.MCFurnaceBlocks;
import fr.mathieu.mcfurnace.utils.MCFurnaceType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;


public class DiamondGeneratorTileEntity extends AbstractSimpleGeneratorTileEntity {

    public DiamondGeneratorTileEntity() {
        super(MCFurnaceBlocks.DIAMOND_GENERATOR_TE, MCFurnaceType.DIAMOND_GENERATOR.cookSpeed, MCFurnaceType.DIAMOND_GENERATOR.output);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("block.mcfurnace.diamond_generator");
    }
}
