package fr.mathieu.mcfurnace.furnace.simplegenerator.irongenerator;

import fr.mathieu.mcfurnace.furnace.simplegenerator.model.AbstractSimpleGenerator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class IronGenerator extends AbstractSimpleGenerator {

    public IronGenerator(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader world) {
        return new IronGeneratorTileEntity();
    }
}
