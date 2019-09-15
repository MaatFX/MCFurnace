package fr.mathieu.mcfurnace.furnace.simplegenerator.goldgenerator;

import fr.mathieu.mcfurnace.furnace.simplegenerator.model.tileentity.AbstractSimpleGeneratorTileEntity;
import fr.mathieu.mcfurnace.utils.MCFurnaceBlocks;
import fr.mathieu.mcfurnace.utils.MCFurnaceType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class GoldGeneratorTileEntity extends AbstractSimpleGeneratorTileEntity {

    public GoldGeneratorTileEntity() {
        super(MCFurnaceBlocks.GOLD_GENERATOR_TE, MCFurnaceType.GOLD_GENERATOR.cookSpeed, MCFurnaceType.GOLD_GENERATOR.output);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("block.mcfurnace.gold_generator");
    }
}
