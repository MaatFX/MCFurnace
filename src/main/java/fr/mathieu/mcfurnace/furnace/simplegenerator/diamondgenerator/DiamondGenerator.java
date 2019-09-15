package fr.mathieu.mcfurnace.furnace.simplegenerator.diamondgenerator;

import fr.mathieu.mcfurnace.furnace.simplegenerator.model.AbstractSimpleGenerator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class DiamondGenerator extends AbstractSimpleGenerator {

    public DiamondGenerator(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new DiamondGeneratorTileEntity();
    }
}
