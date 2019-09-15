package fr.mathieu.mcfurnace.furnace.simplegenerator.basicgenerator;

import fr.mathieu.mcfurnace.furnace.simplegenerator.model.AbstractSimpleGenerator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BasicGenerator extends AbstractSimpleGenerator {

    public BasicGenerator(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader world) {
        return new BasicGeneratorTileEntity();
    }

}
